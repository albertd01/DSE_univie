package com.dse.server;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.server.ResponseStatusException;

import com.dse.api.DefaultApi;
import com.dse.api.DefaultApiDelegate;
import com.dse.model.Availability;
import com.dse.model.Meeting;
import com.dse.model.MeetingCreationRequest;
import com.dse.model.MeetingExport;
import com.dse.model.MeetingPoll;
import com.dse.model.MeetingResponse;
import com.dse.model.MeetingUpdateRequest;
import com.dse.model.Submission;
import com.dse.model.TimeSlot;
import com.dse.model.TimeSlotRequest;
import com.dse.model.TimeSlotResponse;


@Service
public class DelegateImplementation implements DefaultApiDelegate{
	
	@Autowired
    private MeetingService meetingService;

	@Override
	public ResponseEntity<Meeting> addTimeSlots(String meetingId, TimeSlotRequest timeSlotRequest) {
		Optional<Meeting> meeting = meetingService.getMeetingById(meetingId);
		if(meeting.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Meeting concreteMeeting = meeting.get();
		List<TimeSlot> proposedSlots = timeSlotRequest.getTimeSlots();
		for(TimeSlot timeslot : proposedSlots) {
			concreteMeeting.addTimeSlotsItem(timeslot);
		}
		addLinks(concreteMeeting);
		return new ResponseEntity<Meeting>(concreteMeeting, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Meeting> createMeeting(MeetingCreationRequest meetingCreationRequest) {
		if(meetingCreationRequest.getCreator() == null || meetingCreationRequest.getDescription()==null || meetingCreationRequest.getTitle() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Meeting meeting = new Meeting();
		meeting.setCreator(meetingCreationRequest.getCreator());
		meeting.setDescription(meetingCreationRequest.getDescription());
		meeting.setPublished(false);
		meeting.setTimeSlots(meetingCreationRequest.getTimeSlots());
		meeting.setTitle(meetingCreationRequest.getTitle());
		meeting.setId(UUID.randomUUID());
		Meeting createdMeeting = meetingService.createMeeting(meeting);
		addLinks(createdMeeting);
		return new ResponseEntity<Meeting>(createdMeeting, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Void> deleteMeeting(String meetingId) {
		Optional<Meeting> meetingToDelete = meetingService.getMeetingById(meetingId);
		if(meetingToDelete.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<MeetingExport> exportResponses(String meetingId) {
		MeetingExport export = new MeetingExport();
		List<MeetingResponse> responses = new ArrayList<>();
		
		Optional<Meeting> meeting = meetingService.getMeetingById(meetingId);
		if(meeting.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Meeting concreteMeeting = meeting.get();
		
		export.setMeetingId(meetingId);
		
		Map<String, List<TimeSlotResponse>> availabilities = new HashMap<>();
		for(TimeSlot slot : concreteMeeting.getTimeSlots()) {
			for(Availability avail : slot.getAvailabilities()) {
				TimeSlotResponse response = new TimeSlotResponse();
				response.setTimeSlotId(slot.getId().toString());
				response.setAvailability(avail.getAvailability());
			}
		}
		for(Entry<String, List<TimeSlotResponse>> entry : availabilities.entrySet()) {
			MeetingResponse meetingResponse = new MeetingResponse();
			meetingResponse.setName(entry.getKey());
			meetingResponse.setResponses(entry.getValue());
		}
		export.setResponses(responses);
		return new ResponseEntity<MeetingExport>(export, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Meeting> getMeeting(String meetingId) {
		Optional<Meeting> meeting = meetingService.getMeetingById(meetingId);
		if(meeting.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Meeting concreteMeeting = meeting.get();
		addLinks(concreteMeeting);
		return new ResponseEntity<>(concreteMeeting, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Meeting> publishMeeting(String meetingId) {
		Optional<Meeting> meeting = meetingService.getMeetingById(meetingId);
		if(meeting.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Meeting concreteMeeting = meeting.get();
		concreteMeeting.setPublished(true);
		addLinks(concreteMeeting);
		return ResponseEntity.status(200).body(concreteMeeting);
	}

	@Override
	public ResponseEntity<Void> removeTimeSlot(String meetingId, String timeSlotId) {
		Optional<Meeting> meeting = meetingService.getMeetingById(meetingId);
		if(meeting.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Meeting concreteMeeting = meeting.get();
		Iterator<TimeSlot> iterator = concreteMeeting.getTimeSlots().iterator();
	    while (iterator.hasNext()) {
	        TimeSlot slot = iterator.next();
	        if (slot.getId().equals(UUID.fromString(timeSlotId))) {
	            iterator.remove();
	            break;
	        }
	    }
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<Meeting> submitResponses(String meetingId, MeetingResponse meetingResponse) {
		Optional<Meeting> meeting = meetingService.getMeetingById(meetingId);
		if(meeting.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Meeting concreteMeeting = meeting.get();
		List<TimeSlotResponse> responses = meetingResponse.getResponses();
		for(TimeSlotResponse response : responses) {
			for(TimeSlot slot : concreteMeeting.getTimeSlots()) {
				if(slot.getId().equals(UUID.fromString(response.getTimeSlotId()))) {
					Availability avail = new Availability();
					avail.setUser(meetingResponse.getName());
					avail.setAvailability(response.getAvailability());
					slot.addAvailabilitiesItem(avail);
				}
			}
		}
		return ResponseEntity.status(201).body(concreteMeeting);
	}

	@Override
	public ResponseEntity<Meeting> updateMeeting(String meetingId, MeetingUpdateRequest meetingUpdateRequest) {
		Optional<Meeting> meeting = meetingService.getMeetingById(meetingId);
		if(meeting.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Meeting concreteMeeting = meeting.get();
		concreteMeeting.setTitle(meetingUpdateRequest.getTitle());
		concreteMeeting.setTimeSlots(meetingUpdateRequest.getTimeSlots());
		concreteMeeting.setDescription(meetingUpdateRequest.getDescription());
		
		addLinks(concreteMeeting);
		return ResponseEntity.status(200).body(concreteMeeting);
	}
	
	private Meeting addLinks(Meeting meeting) {
		meeting.add(linkTo(methodOn(DefaultApi.class).getMeeting(meeting.getId().toString())).withSelfRel());
		meeting.add(linkTo(methodOn(DefaultApi.class).deleteMeeting(meeting.getId().toString())).withSelfRel());
		return meeting;
		
	}

}
