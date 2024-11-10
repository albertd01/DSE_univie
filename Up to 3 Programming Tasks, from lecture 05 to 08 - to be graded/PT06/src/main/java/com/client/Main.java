package com.client;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import client.openapi.api.DefaultApi;
import client.openapi.model.Meeting;
import client.openapi.model.MeetingCreationRequest;
import client.openapi.model.TimeSlot;

public class Main {
	public static void main(String[] args) {
		DefaultApi api = new DefaultApi();

		MeetingCreationRequest request = new MeetingCreationRequest();
		request.setCreator("Albert Dinstl");
		request.setTitle("PT7 Code review");
		request.setDescription("We will discuss the quality of my implementation");

		List<TimeSlot> slots = new ArrayList<>();
		TimeSlot ts1 = new TimeSlot();
		ts1.setStart(OffsetDateTime.of(2024, 5, 28, 9, 45, 0, 0, ZoneOffset.UTC));
		ts1.setEnd(OffsetDateTime.of(2024, 5, 28, 11, 15, 0, 0, ZoneOffset.UTC));

		TimeSlot ts2 = new TimeSlot();
		ts2.setStart(OffsetDateTime.of(2024, 5, 28, 13, 15, 0, 0, ZoneOffset.UTC));
		ts2.setEnd(OffsetDateTime.of(2024, 5, 28, 14, 45, 0, 0, ZoneOffset.UTC));
		slots.add(ts1);
		slots.add(ts2);
		request.setTimeSlots(slots);

		Meeting createdMeeting = api.createMeeting(request);
		System.out.println("-------------------------- CREATING A MEETING ON THE SERVER ----------------------");
		System.out.println(createdMeeting.getCreator());
		System.out.println(createdMeeting.getTitle());
		System.out.println(createdMeeting.getDescription());
		
		System.out.println("-------------------------- FETCHING THE SAME MEETING FROM THE SERVER ----------------------");
		Meeting fetchedMeeting = api.getMeeting(createdMeeting.getId().toString());
		System.out.println(fetchedMeeting.getCreator());
		System.out.println(fetchedMeeting.getTitle());
		System.out.println(fetchedMeeting.getDescription());
	}
}
