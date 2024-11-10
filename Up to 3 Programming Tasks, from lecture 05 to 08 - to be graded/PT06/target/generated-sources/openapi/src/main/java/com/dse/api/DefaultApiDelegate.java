package com.dse.api;

import com.dse.model.Meeting;
import com.dse.model.MeetingCreationRequest;
import com.dse.model.MeetingExport;
import com.dse.model.MeetingResponse;
import com.dse.model.MeetingUpdateRequest;
import com.dse.model.TimeSlotRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link DefaultApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-13T10:38:19.491351+02:00[Europe/Vienna]", comments = "Generator version: 7.5.0")
public interface DefaultApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /meetings/{meetingId}/timeslots : Add time slots to a meeting poll
     *
     * @param meetingId  (required)
     * @param timeSlotRequest  (required)
     * @return Time slots added successfully (status code 200)
     * @see DefaultApi#addTimeSlots
     */
    default ResponseEntity<Meeting> addTimeSlots(String meetingId,
        TimeSlotRequest timeSlotRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"creator\" : \"creator\", \"description\" : \"description\", \"timeSlots\" : [ { \"availabilities\" : [ { \"availability\" : \"availability\", \"user\" : \"user\" }, { \"availability\" : \"availability\", \"user\" : \"user\" } ], \"start\" : \"2000-01-23T04:56:07.000+00:00\", \"end\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"availabilities\" : [ { \"availability\" : \"availability\", \"user\" : \"user\" }, { \"availability\" : \"availability\", \"user\" : \"user\" } ], \"start\" : \"2000-01-23T04:56:07.000+00:00\", \"end\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" } ], \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"published\" : true, \"title\" : \"title\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /meetings : Create a new meeting poll
     *
     * @param meetingCreationRequest  (required)
     * @return Meeting created successfully (status code 201)
     * @see DefaultApi#createMeeting
     */
    default ResponseEntity<Meeting> createMeeting(MeetingCreationRequest meetingCreationRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"creator\" : \"creator\", \"description\" : \"description\", \"timeSlots\" : [ { \"availabilities\" : [ { \"availability\" : \"availability\", \"user\" : \"user\" }, { \"availability\" : \"availability\", \"user\" : \"user\" } ], \"start\" : \"2000-01-23T04:56:07.000+00:00\", \"end\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"availabilities\" : [ { \"availability\" : \"availability\", \"user\" : \"user\" }, { \"availability\" : \"availability\", \"user\" : \"user\" } ], \"start\" : \"2000-01-23T04:56:07.000+00:00\", \"end\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" } ], \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"published\" : true, \"title\" : \"title\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /meetings/{meetingId} : Delete a meeting poll
     *
     * @param meetingId  (required)
     * @return Meeting deleted successfully (status code 204)
     * @see DefaultApi#deleteMeeting
     */
    default ResponseEntity<Void> deleteMeeting(String meetingId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /meetings/{meetingId}/export : Export meeting responses
     *
     * @param meetingId  (required)
     * @return Meeting responses exported successfully (status code 200)
     * @see DefaultApi#exportResponses
     */
    default ResponseEntity<MeetingExport> exportResponses(String meetingId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"responses\" : [ { \"name\" : \"name\", \"responses\" : [ { \"timeSlotId\" : \"timeSlotId\", \"availability\" : \"availability\" }, { \"timeSlotId\" : \"timeSlotId\", \"availability\" : \"availability\" } ] }, { \"name\" : \"name\", \"responses\" : [ { \"timeSlotId\" : \"timeSlotId\", \"availability\" : \"availability\" }, { \"timeSlotId\" : \"timeSlotId\", \"availability\" : \"availability\" } ] } ], \"meetingId\" : \"meetingId\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /meetings/{meetingId} : Get meeting details
     *
     * @param meetingId  (required)
     * @return Meeting details retrieved successfully (status code 200)
     * @see DefaultApi#getMeeting
     */
    default ResponseEntity<Meeting> getMeeting(String meetingId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"creator\" : \"creator\", \"description\" : \"description\", \"timeSlots\" : [ { \"availabilities\" : [ { \"availability\" : \"availability\", \"user\" : \"user\" }, { \"availability\" : \"availability\", \"user\" : \"user\" } ], \"start\" : \"2000-01-23T04:56:07.000+00:00\", \"end\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"availabilities\" : [ { \"availability\" : \"availability\", \"user\" : \"user\" }, { \"availability\" : \"availability\", \"user\" : \"user\" } ], \"start\" : \"2000-01-23T04:56:07.000+00:00\", \"end\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" } ], \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"published\" : true, \"title\" : \"title\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /meetings/{meetingId}/publish : Publish a meeting poll
     *
     * @param meetingId  (required)
     * @return Meeting poll published successfully (status code 200)
     * @see DefaultApi#publishMeeting
     */
    default ResponseEntity<Meeting> publishMeeting(String meetingId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"creator\" : \"creator\", \"description\" : \"description\", \"timeSlots\" : [ { \"availabilities\" : [ { \"availability\" : \"availability\", \"user\" : \"user\" }, { \"availability\" : \"availability\", \"user\" : \"user\" } ], \"start\" : \"2000-01-23T04:56:07.000+00:00\", \"end\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"availabilities\" : [ { \"availability\" : \"availability\", \"user\" : \"user\" }, { \"availability\" : \"availability\", \"user\" : \"user\" } ], \"start\" : \"2000-01-23T04:56:07.000+00:00\", \"end\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" } ], \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"published\" : true, \"title\" : \"title\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /meetings/{meetingId}/timeslots/{timeSlotId} : Remove a time slot from a meeting poll
     *
     * @param meetingId  (required)
     * @param timeSlotId  (required)
     * @return Time slot removed successfully (status code 204)
     * @see DefaultApi#removeTimeSlot
     */
    default ResponseEntity<Void> removeTimeSlot(String meetingId,
        String timeSlotId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /meetings/{meetingId}/responses : Submit responses to a meeting poll
     *
     * @param meetingId  (required)
     * @param meetingResponse  (required)
     * @return Responses submitted successfully (status code 200)
     * @see DefaultApi#submitResponses
     */
    default ResponseEntity<Meeting> submitResponses(String meetingId,
        MeetingResponse meetingResponse) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"creator\" : \"creator\", \"description\" : \"description\", \"timeSlots\" : [ { \"availabilities\" : [ { \"availability\" : \"availability\", \"user\" : \"user\" }, { \"availability\" : \"availability\", \"user\" : \"user\" } ], \"start\" : \"2000-01-23T04:56:07.000+00:00\", \"end\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"availabilities\" : [ { \"availability\" : \"availability\", \"user\" : \"user\" }, { \"availability\" : \"availability\", \"user\" : \"user\" } ], \"start\" : \"2000-01-23T04:56:07.000+00:00\", \"end\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" } ], \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"published\" : true, \"title\" : \"title\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /meetings/{meetingId} : Update a meeting poll
     *
     * @param meetingId  (required)
     * @param meetingUpdateRequest  (required)
     * @return Meeting updated successfully (status code 200)
     * @see DefaultApi#updateMeeting
     */
    default ResponseEntity<Meeting> updateMeeting(String meetingId,
        MeetingUpdateRequest meetingUpdateRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"creator\" : \"creator\", \"description\" : \"description\", \"timeSlots\" : [ { \"availabilities\" : [ { \"availability\" : \"availability\", \"user\" : \"user\" }, { \"availability\" : \"availability\", \"user\" : \"user\" } ], \"start\" : \"2000-01-23T04:56:07.000+00:00\", \"end\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"availabilities\" : [ { \"availability\" : \"availability\", \"user\" : \"user\" }, { \"availability\" : \"availability\", \"user\" : \"user\" } ], \"start\" : \"2000-01-23T04:56:07.000+00:00\", \"end\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" } ], \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"published\" : true, \"title\" : \"title\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
