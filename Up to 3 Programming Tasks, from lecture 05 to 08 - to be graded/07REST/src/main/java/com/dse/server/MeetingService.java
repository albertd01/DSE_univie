package com.dse.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dse.model.Meeting;

@Service
public class MeetingService {
    private Map<UUID, Meeting> meetingRepository = new HashMap<>();

    public Meeting createMeeting(Meeting meeting) {
    	meetingRepository.put(meeting.getId(), meeting);
        return meeting;
    }

    public Optional<Meeting> getMeetingById(String meetingId) {
        return Optional.ofNullable(meetingRepository.get(UUID.fromString(meetingId)));
    }

    public Meeting updateMeeting(Meeting meeting) {
        return meetingRepository.replace(meeting.getId(), meeting);
    }

    public void deleteMeeting(String meetingId) {
        meetingRepository.remove(UUID.fromString(meetingId));
    }

    public List<Meeting> getAllMeetings() {
        return new ArrayList<>(meetingRepository.values());
    }
    
}
