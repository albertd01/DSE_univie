/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.5.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.dse.api;

import com.dse.model.Meeting;
import com.dse.model.MeetingCreationRequest;
import com.dse.model.MeetingExport;
import com.dse.model.MeetingResponse;
import com.dse.model.MeetingUpdateRequest;
import com.dse.model.TimeSlotRequest;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-15T07:59:44.685903900+02:00[Europe/Vienna]", comments = "Generator version: 7.5.0")
@Validated
@Tag(name = "Default", description = "the Default API")
public interface DefaultApi {

    default DefaultApiDelegate getDelegate() {
        return new DefaultApiDelegate() {};
    }

    /**
     * POST /meetings/{meetingId}/timeslots : Add time slots to a meeting poll
     *
     * @param meetingId  (required)
     * @param timeSlotRequest  (required)
     * @return Time slots added successfully (status code 200)
     */
    @Operation(
        operationId = "addTimeSlots",
        summary = "Add time slots to a meeting poll",
        responses = {
            @ApiResponse(responseCode = "200", description = "Time slots added successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Meeting.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/meetings/{meetingId}/timeslots",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Meeting> addTimeSlots(
        @Parameter(name = "meetingId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("meetingId") String meetingId,
        @Parameter(name = "TimeSlotRequest", description = "", required = true) @Valid @RequestBody TimeSlotRequest timeSlotRequest
    ) {
        return getDelegate().addTimeSlots(meetingId, timeSlotRequest);
    }


    /**
     * POST /meetings : Create a new meeting poll
     *
     * @param meetingCreationRequest  (required)
     * @return Meeting created successfully (status code 201)
     */
    @Operation(
        operationId = "createMeeting",
        summary = "Create a new meeting poll",
        responses = {
            @ApiResponse(responseCode = "201", description = "Meeting created successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Meeting.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/meetings",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Meeting> createMeeting(
        @Parameter(name = "MeetingCreationRequest", description = "", required = true) @Valid @RequestBody MeetingCreationRequest meetingCreationRequest
    ) {
        return getDelegate().createMeeting(meetingCreationRequest);
    }


    /**
     * DELETE /meetings/{meetingId} : Delete a meeting poll
     *
     * @param meetingId  (required)
     * @return Meeting deleted successfully (status code 204)
     */
    @Operation(
        operationId = "deleteMeeting",
        summary = "Delete a meeting poll",
        responses = {
            @ApiResponse(responseCode = "204", description = "Meeting deleted successfully")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/meetings/{meetingId}"
    )
    
    default ResponseEntity<Void> deleteMeeting(
        @Parameter(name = "meetingId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("meetingId") String meetingId
    ) {
        return getDelegate().deleteMeeting(meetingId);
    }


    /**
     * GET /meetings/{meetingId}/export : Export meeting responses
     *
     * @param meetingId  (required)
     * @return Meeting responses exported successfully (status code 200)
     */
    @Operation(
        operationId = "exportResponses",
        summary = "Export meeting responses",
        responses = {
            @ApiResponse(responseCode = "200", description = "Meeting responses exported successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = MeetingExport.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/meetings/{meetingId}/export",
        produces = { "application/json" }
    )
    
    default ResponseEntity<MeetingExport> exportResponses(
        @Parameter(name = "meetingId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("meetingId") String meetingId
    ) {
        return getDelegate().exportResponses(meetingId);
    }


    /**
     * GET /meetings/{meetingId} : Get meeting details
     *
     * @param meetingId  (required)
     * @return Meeting details retrieved successfully (status code 200)
     */
    @Operation(
        operationId = "getMeeting",
        summary = "Get meeting details",
        responses = {
            @ApiResponse(responseCode = "200", description = "Meeting details retrieved successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Meeting.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/meetings/{meetingId}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Meeting> getMeeting(
        @Parameter(name = "meetingId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("meetingId") String meetingId
    ) {
        return getDelegate().getMeeting(meetingId);
    }


    /**
     * POST /meetings/{meetingId}/publish : Publish a meeting poll
     *
     * @param meetingId  (required)
     * @return Meeting poll published successfully (status code 200)
     */
    @Operation(
        operationId = "publishMeeting",
        summary = "Publish a meeting poll",
        responses = {
            @ApiResponse(responseCode = "200", description = "Meeting poll published successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Meeting.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/meetings/{meetingId}/publish",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Meeting> publishMeeting(
        @Parameter(name = "meetingId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("meetingId") String meetingId
    ) {
        return getDelegate().publishMeeting(meetingId);
    }


    /**
     * DELETE /meetings/{meetingId}/timeslots/{timeSlotId} : Remove a time slot from a meeting poll
     *
     * @param meetingId  (required)
     * @param timeSlotId  (required)
     * @return Time slot removed successfully (status code 204)
     */
    @Operation(
        operationId = "removeTimeSlot",
        summary = "Remove a time slot from a meeting poll",
        responses = {
            @ApiResponse(responseCode = "204", description = "Time slot removed successfully")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/meetings/{meetingId}/timeslots/{timeSlotId}"
    )
    
    default ResponseEntity<Void> removeTimeSlot(
        @Parameter(name = "meetingId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("meetingId") String meetingId,
        @Parameter(name = "timeSlotId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("timeSlotId") String timeSlotId
    ) {
        return getDelegate().removeTimeSlot(meetingId, timeSlotId);
    }


    /**
     * POST /meetings/{meetingId}/responses : Submit responses to a meeting poll
     *
     * @param meetingId  (required)
     * @param meetingResponse  (required)
     * @return Responses submitted successfully (status code 200)
     */
    @Operation(
        operationId = "submitResponses",
        summary = "Submit responses to a meeting poll",
        responses = {
            @ApiResponse(responseCode = "200", description = "Responses submitted successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Meeting.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/meetings/{meetingId}/responses",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Meeting> submitResponses(
        @Parameter(name = "meetingId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("meetingId") String meetingId,
        @Parameter(name = "MeetingResponse", description = "", required = true) @Valid @RequestBody MeetingResponse meetingResponse
    ) {
        return getDelegate().submitResponses(meetingId, meetingResponse);
    }


    /**
     * PUT /meetings/{meetingId} : Update a meeting poll
     *
     * @param meetingId  (required)
     * @param meetingUpdateRequest  (required)
     * @return Meeting updated successfully (status code 200)
     */
    @Operation(
        operationId = "updateMeeting",
        summary = "Update a meeting poll",
        responses = {
            @ApiResponse(responseCode = "200", description = "Meeting updated successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Meeting.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/meetings/{meetingId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Meeting> updateMeeting(
        @Parameter(name = "meetingId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("meetingId") String meetingId,
        @Parameter(name = "MeetingUpdateRequest", description = "", required = true) @Valid @RequestBody MeetingUpdateRequest meetingUpdateRequest
    ) {
        return getDelegate().updateMeeting(meetingId, meetingUpdateRequest);
    }

}
