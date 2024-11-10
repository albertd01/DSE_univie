package com.dse;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dse.model.AvailabilityEnum;
import com.dse.model.Meeting;
import com.dse.model.MeetingCreationRequest;
import com.dse.model.MeetingResponse;
import com.dse.model.TimeSlot;
import com.dse.model.TimeSlotRequest;
import com.dse.model.TimeSlotResponse;
import com.dse.server.MeetingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@BeforeEach
	public void setup() {
		// Set up MockMvc with the application context
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void whenCreateMeetingWithEmptyJson_expectBadRequest() throws Exception {
		mockMvc.perform(post("/rest/pt6/meetings").contentType(MediaType.APPLICATION_JSON).content("{}"))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void whenCreateMeetingWithValidJson_expectCreated() throws Exception {
		String validJson = "{" + "\"title\":\"testTitle\"," + "\"description\":\"testdescription\","
				+ "\"creator\":\"testcreator\"," + "\"timeSlots\":[" + "{"
				+ "\"id\":\"3fa85f64-5717-4562-b3fc-2c963f66afa6\"," + "\"start\":\"2024-06-10T19:20:16.754Z\","
				+ "\"end\":\"2024-06-10T19:20:16.754Z\"," + "\"availabilities\":[" + "{" + "\"user\":\"testuser\","
				+ "\"availability\":\"true\"" + "}" + "]" + "}" + "]" + "}";

		mockMvc.perform(post("/rest/pt6/meetings").contentType(MediaType.APPLICATION_JSON).content(validJson))
				.andExpect(status().isCreated());
	}

	@Test
	public void whenDeleteExistingMeeting_expectOk() throws Exception {
		String validJson = "{" + "\"title\":\"testTitle\"," + "\"description\":\"testdescription\","
				+ "\"creator\":\"testcreator\"," + "\"timeSlots\":[" + "{"
				+ "\"id\":\"3fa85f64-5717-4562-b3fc-2c963f66afa6\"," + "\"start\":\"2024-06-10T19:20:16.754Z\","
				+ "\"end\":\"2024-06-10T19:20:16.754Z\"," + "\"availabilities\":[" + "{" + "\"user\":\"testuser\","
				+ "\"availability\":\"true\"" + "}" + "]" + "}" + "]" + "}";

		// Perform POST request to create a meeting
		String response = mockMvc
				.perform(post("/rest/pt6/meetings").contentType(MediaType.APPLICATION_JSON).content(validJson))
				.andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();

		// Step 2: Extract the meeting ID from the response
		String meetingId = JsonPath.read(response, "$.id");

		// Step 3: Perform DELETE request to delete the meeting using the extracted ID
		mockMvc.perform(delete("/rest/pt6/meetings/" + meetingId).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void whenDeleteNonExistingMeeting_expectNotFound() throws Exception {
		String validJson = "{" + "\"title\":\"testTitle\"," + "\"description\":\"testdescription\","
				+ "\"creator\":\"testcreator\"," + "\"timeSlots\":[" + "{"
				+ "\"id\":\"3fa85f64-5717-4562-b3fc-2c963f66afa6\"," + "\"start\":\"2024-06-10T19:20:16.754Z\","
				+ "\"end\":\"2024-06-10T19:20:16.754Z\"," + "\"availabilities\":[" + "{" + "\"user\":\"testuser\","
				+ "\"availability\":\"true\"" + "}" + "]" + "}" + "]" + "}";

		// Perform POST request to create a meeting
		mockMvc.perform(post("/rest/pt6/meetings").contentType(MediaType.APPLICATION_JSON).content(validJson))
				.andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();

		mockMvc.perform(
				delete("/rest/pt6/meetings/" + UUID.randomUUID().toString()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}

	@Test
	public void whenRetrievingExistingMeeting_expectOK() throws Exception {
		String validJson = "{" + "\"title\":\"testTitle\"," + "\"description\":\"testdescription\","
				+ "\"creator\":\"testcreator\"," + "\"timeSlots\":[" + "{"
				+ "\"id\":\"3fa85f64-5717-4562-b3fc-2c963f66afa6\"," + "\"start\":\"2024-06-10T19:20:16.754Z\","
				+ "\"end\":\"2024-06-10T19:20:16.754Z\"," + "\"availabilities\":[" + "{" + "\"user\":\"testuser\","
				+ "\"availability\":\"true\"" + "}" + "]" + "}" + "]" + "}";

		String response = mockMvc
				.perform(post("/rest/pt6/meetings").contentType(MediaType.APPLICATION_JSON).content(validJson))
				.andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();

		String meetingId = JsonPath.read(response, "$.id");

		mockMvc.perform(get("/rest/pt6/meetings/" + meetingId).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void whenRetrievingNonExistingMeeting_expectNotFound() throws Exception {
		String validJson = "{" + "\"title\":\"testTitle\"," + "\"description\":\"testdescription\","
				+ "\"creator\":\"testcreator\"," + "\"timeSlots\":[" + "{"
				+ "\"id\":\"3fa85f64-5717-4562-b3fc-2c963f66afa6\"," + "\"start\":\"2024-06-10T19:20:16.754Z\","
				+ "\"end\":\"2024-06-10T19:20:16.754Z\"," + "\"availabilities\":[" + "{" + "\"user\":\"testuser\","
				+ "\"availability\":\"true\"" + "}" + "]" + "}" + "]" + "}";

		// Perform POST request to create a meeting
		mockMvc.perform(post("/rest/pt6/meetings").contentType(MediaType.APPLICATION_JSON).content(validJson))
				.andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();

		mockMvc.perform(
				get("/rest/pt6/meetings/" + UUID.randomUUID().toString()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}

	@Test
	public void whenPublishingExistingMeeting_expectOK() throws Exception {
		String validJson = "{" + "\"title\":\"testTitle\"," + "\"description\":\"testdescription\","
				+ "\"creator\":\"testcreator\"," + "\"timeSlots\":[" + "{"
				+ "\"id\":\"3fa85f64-5717-4562-b3fc-2c963f66afa6\"," + "\"start\":\"2024-06-10T19:20:16.754Z\","
				+ "\"end\":\"2024-06-10T19:20:16.754Z\"," + "\"availabilities\":[" + "{" + "\"user\":\"testuser\","
				+ "\"availability\":\"true\"" + "}" + "]" + "}" + "]" + "}";

		String response = mockMvc
				.perform(post("/rest/pt6/meetings").contentType(MediaType.APPLICATION_JSON).content(validJson))
				.andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();

		String meetingId = JsonPath.read(response, "$.id");

		mockMvc.perform(post("/rest/pt6/meetings/" + meetingId + "/publish").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void whenPublishingNonExistingMeeting_expectNotFound() throws Exception {
		String validJson = "{" + "\"title\":\"testTitle\"," + "\"description\":\"testdescription\","
				+ "\"creator\":\"testcreator\"," + "\"timeSlots\":[" + "{"
				+ "\"id\":\"3fa85f64-5717-4562-b3fc-2c963f66afa6\"," + "\"start\":\"2024-06-10T19:20:16.754Z\","
				+ "\"end\":\"2024-06-10T19:20:16.754Z\"," + "\"availabilities\":[" + "{" + "\"user\":\"testuser\","
				+ "\"availability\":\"true\"" + "}" + "]" + "}" + "]" + "}";

		// Perform POST request to create a meeting
		mockMvc.perform(post("/rest/pt6/meetings").contentType(MediaType.APPLICATION_JSON).content(validJson))
				.andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();

		mockMvc.perform(post("/rest/pt6/meetings/" + UUID.randomUUID().toString() + "/publish")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());

	}

	@Test
	public void whenUpdatingExistingMeeting_expectOK() throws Exception {
		String validJson = "{" + "\"title\":\"testTitle\"," + "\"description\":\"testdescription\","
				+ "\"creator\":\"testcreator\"," + "\"timeSlots\":[" + "{"
				+ "\"id\":\"3fa85f64-5717-4562-b3fc-2c963f66afa6\"," + "\"start\":\"2024-06-10T19:20:16.754Z\","
				+ "\"end\":\"2024-06-10T19:20:16.754Z\"," + "\"availabilities\":[" + "{" + "\"user\":\"testuser\","
				+ "\"availability\":\"true\"" + "}" + "]" + "}" + "]" + "}";

		String anotherValidJson = "{" + "\"title\":\"testTitle\"," + "\"description\":\"updated description\","
				+ "\"creator\":\"testcreator\"," + "\"timeSlots\":[" + "{"
				+ "\"id\":\"3fa85f64-5717-4562-b3fc-2c963f66afa6\"," + "\"start\":\"2024-06-10T19:20:16.754Z\","
				+ "\"end\":\"2024-06-10T19:20:16.754Z\"," + "\"availabilities\":[" + "{" + "\"user\":\"testuser\","
				+ "\"availability\":\"true\"" + "}" + "]" + "}" + "]" + "}";

		String response = mockMvc
				.perform(post("/rest/pt6/meetings").contentType(MediaType.APPLICATION_JSON).content(validJson))
				.andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();

		String meetingId = JsonPath.read(response, "$.id");

		String meeting = mockMvc
				.perform(put("/rest/pt6/meetings/" + meetingId).contentType(MediaType.APPLICATION_JSON)
						.content(anotherValidJson))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		assert (JsonPath.read(meeting, "$.description").equals("updated description"));
	}

	@Test
	public void whenUpdatingNonExistingMeeting_expectNotFound() throws Exception {
		String validJson = "{" + "\"title\":\"testTitle\"," + "\"description\":\"testdescription\","
				+ "\"creator\":\"testcreator\"," + "\"timeSlots\":[" + "{"
				+ "\"id\":\"3fa85f64-5717-4562-b3fc-2c963f66afa6\"," + "\"start\":\"2024-06-10T19:20:16.754Z\","
				+ "\"end\":\"2024-06-10T19:20:16.754Z\"," + "\"availabilities\":[" + "{" + "\"user\":\"testuser\","
				+ "\"availability\":\"true\"" + "}" + "]" + "}" + "]" + "}";

		String anotherValidJson = "{" + "\"title\":\"testTitle\"," + "\"description\":\"updated description\","
				+ "\"creator\":\"testcreator\"," + "\"timeSlots\":[" + "{"
				+ "\"id\":\"3fa85f64-5717-4562-b3fc-2c963f66afa6\"," + "\"start\":\"2024-06-10T19:20:16.754Z\","
				+ "\"end\":\"2024-06-10T19:20:16.754Z\"," + "\"availabilities\":[" + "{" + "\"user\":\"testuser\","
				+ "\"availability\":\"true\"" + "}" + "]" + "}" + "]" + "}";

		mockMvc.perform(post("/rest/pt6/meetings").contentType(MediaType.APPLICATION_JSON).content(validJson))
				.andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();

		mockMvc.perform(put("/rest/pt6/meetings/" + UUID.randomUUID().toString())
				.contentType(MediaType.APPLICATION_JSON).content(anotherValidJson)).andExpect(status().isNotFound());
	}

	@Test
	public void whenAddTimeSlotToExistingMeeting_expectOk() throws Exception {
		String validJson = "{" + "\"title\":\"testTitle\"," + "\"description\":\"testdescription\","
				+ "\"creator\":\"testcreator\"," + "\"timeSlots\":[" + "{"
				+ "\"id\":\"3fa85f64-5717-4562-b3fc-2c963f66afa6\"," + "\"start\":\"2024-06-10T19:20:16.754Z\","
				+ "\"end\":\"2024-06-10T19:20:16.754Z\"," + "\"availabilities\":[" + "{" + "\"user\":\"testuser\","
				+ "\"availability\":\"true\"" + "}" + "]" + "}" + "]" + "}";

		String validTimeSlot = "{" + "\"timeSlots\": [" + "{" + "\"id\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\","
				+ "\"start\": \"2024-06-10T19:20:16.754Z\"," + "\"end\": \"2024-06-10T20:20:16.754Z\","
				+ "\"availabilities\": [" + "{" + "\"user\": \"testuser1\"," + "\"availability\": \"true\"" + "}," + "{"
				+ "\"user\": \"testuser2\"," + "\"availability\": \"false\"" + "}" + "]" + "}," + "{"
				+ "\"id\": \"4fb85f64-5717-4562-b3fc-2c963f66bfa7\"," + "\"start\": \"2024-06-11T19:20:16.754Z\","
				+ "\"end\": \"2024-06-11T20:20:16.754Z\"," + "\"availabilities\": [" + "{" + "\"user\": \"testuser3\","
				+ "\"availability\": \"maybe\"" + "}" + "]" + "}" + "]" + "}";

		String response = mockMvc
				.perform(post("/rest/pt6/meetings").contentType(MediaType.APPLICATION_JSON).content(validJson))
				.andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();

		String meetingId = JsonPath.read(response, "$.id");

		mockMvc.perform(post("/rest/pt6/meetings/" + meetingId + "/timeslots").contentType(MediaType.APPLICATION_JSON)
				.content(validTimeSlot)).andExpect(status().isCreated());

	}

	@Test
	public void whenAddTimeSlotToNonExistingMeeting_expectNotFound() throws Exception {
		String validJson = "{" + "\"title\":\"testTitle\"," + "\"description\":\"testdescription\","
				+ "\"creator\":\"testcreator\"," + "\"timeSlots\":[" + "{"
				+ "\"id\":\"3fa85f64-5717-4562-b3fc-2c963f66afa6\"," + "\"start\":\"2024-06-10T19:20:16.754Z\","
				+ "\"end\":\"2024-06-10T19:20:16.754Z\"," + "\"availabilities\":[" + "{" + "\"user\":\"testuser\","
				+ "\"availability\":\"true\"" + "}" + "]" + "}" + "]" + "}";

		String validTimeSlot = "{" + "\"timeSlots\": [" + "{" + "\"id\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\","
				+ "\"start\": \"2024-06-10T19:20:16.754Z\"," + "\"end\": \"2024-06-10T20:20:16.754Z\","
				+ "\"availabilities\": [" + "{" + "\"user\": \"testuser1\"," + "\"availability\": \"true\"" + "}," + "{"
				+ "\"user\": \"testuser2\"," + "\"availability\": \"false\"" + "}" + "]" + "}," + "{"
				+ "\"id\": \"4fb85f64-5717-4562-b3fc-2c963f66bfa7\"," + "\"start\": \"2024-06-11T19:20:16.754Z\","
				+ "\"end\": \"2024-06-11T20:20:16.754Z\"," + "\"availabilities\": [" + "{" + "\"user\": \"testuser3\","
				+ "\"availability\": \"maybe\"" + "}" + "]" + "}" + "]" + "}";

		mockMvc.perform(post("/rest/pt6/meetings").contentType(MediaType.APPLICATION_JSON).content(validJson))
				.andExpect(status().isCreated());

		mockMvc.perform(post("/rest/pt6/meetings/" + UUID.randomUUID().toString() + "/timeslots")
				.contentType(MediaType.APPLICATION_JSON).content(validTimeSlot)).andExpect(status().isNotFound());

	}

	@Test
	public void whenRemovingExistingTimeSlot_expectOk() throws Exception {
		String validJson = "{" + "\"title\":\"testTitle\"," + "\"description\":\"testdescription\","
				+ "\"creator\":\"testcreator\"," + "\"timeSlots\":[" + "{"
				+ "\"id\":\"3fa85f64-5717-4562-b3fc-2c963f66afa6\"," + "\"start\":\"2024-06-10T19:20:16.754Z\","
				+ "\"end\":\"2024-06-10T19:20:16.754Z\"," + "\"availabilities\":[" + "{" + "\"user\":\"testuser\","
				+ "\"availability\":\"true\"" + "}" + "]" + "}" + "]" + "}";

		String validTimeSlot = "{" + "\"timeSlots\": [" + "{" + "\"id\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\","
				+ "\"start\": \"2024-06-10T19:20:16.754Z\"," + "\"end\": \"2024-06-10T20:20:16.754Z\","
				+ "\"availabilities\": [" + "{" + "\"user\": \"testuser1\"," + "\"availability\": \"true\"" + "}," + "{"
				+ "\"user\": \"testuser2\"," + "\"availability\": \"false\"" + "}" + "]" + "}," + "{"
				+ "\"id\": \"4fb85f64-5717-4562-b3fc-2c963f66bfa7\"," + "\"start\": \"2024-06-11T19:20:16.754Z\","
				+ "\"end\": \"2024-06-11T20:20:16.754Z\"," + "\"availabilities\": [" + "{" + "\"user\": \"testuser3\","
				+ "\"availability\": \"maybe\"" + "}" + "]" + "}" + "]" + "}";

		String response = mockMvc
				.perform(post("/rest/pt6/meetings").contentType(MediaType.APPLICATION_JSON).content(validJson))
				.andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();

		String meetingId = JsonPath.read(response, "$.id");

		mockMvc.perform(post("/rest/pt6/meetings/" + meetingId + "/timeslots").contentType(MediaType.APPLICATION_JSON)
				.content(validTimeSlot)).andExpect(status().isCreated());

		mockMvc.perform(delete("/rest/pt6/meetings/" + meetingId + "/timeslots/4fb85f64-5717-4562-b3fc-2c963f66bfa7")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void whenPublishingExistingMeeting_expectOk() throws Exception {
		String validJson = "{" + "\"title\":\"testTitle\"," + "\"description\":\"testdescription\","
				+ "\"creator\":\"testcreator\"," + "\"timeSlots\":[" + "{"
				+ "\"id\":\"3fa85f64-5717-4562-b3fc-2c963f66afa6\"," + "\"start\":\"2024-06-10T19:20:16.754Z\","
				+ "\"end\":\"2024-06-10T19:20:16.754Z\"," + "\"availabilities\":[" + "{" + "\"user\":\"testuser\","
				+ "\"availability\":\"true\"" + "}" + "]" + "}" + "]" + "}";

		String response = mockMvc
				.perform(post("/rest/pt6/meetings").contentType(MediaType.APPLICATION_JSON).content(validJson))
				.andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();

		String meetingId = JsonPath.read(response, "$.id");

		mockMvc.perform(post("/rest/pt6/meetings/" + meetingId + "/publish").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void whenSubmittingResponsesToExistingMeeting_expectCreated() throws Exception {
		String validJson = "{" + "\"title\":\"testTitle\"," + "\"description\":\"testdescription\","
				+ "\"creator\":\"testcreator\"," + "\"timeSlots\":[" + "{"
				+ "\"id\":\"3fa85f64-5717-4562-b3fc-2c963f66afa6\"," + "\"start\":\"2024-06-10T19:20:16.754Z\","
				+ "\"end\":\"2024-06-10T20:20:16.754Z\"," + "\"availabilities\":[]" + "}," + "{"
				+ "\"id\":\"4fb85f64-5717-4562-b3fc-2c963f66bfa7\"," + "\"start\":\"2024-06-11T19:20:16.754Z\","
				+ "\"end\":\"2024-06-11T20:20:16.754Z\"," + "\"availabilities\":[]" + "}" + "]" + "}";

		String response = mockMvc
				.perform(post("/rest/pt6/meetings").contentType(MediaType.APPLICATION_JSON).content(validJson))
				.andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();

		String meetingId = JsonPath.read(response, "$.id");
		String timeSlotId1 = JsonPath.read(response, "$.timeSlots[0].id");
		String timeSlotId2 = JsonPath.read(response, "$.timeSlots[1].id");

		String responseJson = "{" + "\"name\": \"Jane Doe\"," + "\"responses\": [" + "{" + "\"timeSlotId\": \""
				+ timeSlotId1 + "\"," + "\"availability\": \"true\"" + "}," + "{" + "\"timeSlotId\": \"" + timeSlotId2
				+ "\"," + "\"availability\": \"false\"" + "}" + "]" + "}";

		mockMvc.perform(post("/rest/pt6/meetings/" + meetingId + "/responses").contentType(MediaType.APPLICATION_JSON)
				.content(responseJson)).andExpect(status().isCreated());
	}

	@Test
	public void whenExportResponses_thenStatusIsOk() throws Exception {
		String validJson = "{" + "\"title\":\"testTitle\"," + "\"description\":\"testdescription\","
				+ "\"creator\":\"testcreator\"," + "\"timeSlots\":[" + "{"
				+ "\"id\":\"3fa85f64-5717-4562-b3fc-2c963f66afa6\"," + "\"start\":\"2024-06-10T19:20:16.754Z\","
				+ "\"end\":\"2024-06-10T20:20:16.754Z\"," + "\"availabilities\":[]" + "}," + "{"
				+ "\"id\":\"4fb85f64-5717-4562-b3fc-2c963f66bfa7\"," + "\"start\":\"2024-06-11T19:20:16.754Z\","
				+ "\"end\":\"2024-06-11T20:20:16.754Z\"," + "\"availabilities\":[]" + "}" + "]" + "}";
		
		String response = mockMvc
				.perform(post("/rest/pt6/meetings").contentType(MediaType.APPLICATION_JSON).content(validJson))
				.andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();

		String meetingId = JsonPath.read(response, "$.id");
		
		mockMvc.perform(get("/rest/pt6/meetings/" + meetingId + "/export")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
