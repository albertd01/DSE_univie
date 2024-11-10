package com.dse.model;

import java.net.URI;
import java.util.Objects;
import com.dse.model.MeetingResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.hateoas.RepresentationModel;

import java.util.*;
import jakarta.annotation.Generated;

/**
 * MeetingExport
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-15T07:59:44.685903900+02:00[Europe/Vienna]", comments = "Generator version: 7.5.0")
public class MeetingExport extends RepresentationModel<MeetingExport>  {

  private String meetingId;

  @Valid
  private List<@Valid MeetingResponse> responses = new ArrayList<>();

  public MeetingExport meetingId(String meetingId) {
    this.meetingId = meetingId;
    return this;
  }

  /**
   * Get meetingId
   * @return meetingId
  */
  
  @Schema(name = "meetingId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("meetingId")
  public String getMeetingId() {
    return meetingId;
  }

  public void setMeetingId(String meetingId) {
    this.meetingId = meetingId;
  }

  public MeetingExport responses(List<@Valid MeetingResponse> responses) {
    this.responses = responses;
    return this;
  }

  public MeetingExport addResponsesItem(MeetingResponse responsesItem) {
    if (this.responses == null) {
      this.responses = new ArrayList<>();
    }
    this.responses.add(responsesItem);
    return this;
  }

  /**
   * Get responses
   * @return responses
  */
  @Valid 
  @Schema(name = "responses", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("responses")
  public List<@Valid MeetingResponse> getResponses() {
    return responses;
  }

  public void setResponses(List<@Valid MeetingResponse> responses) {
    this.responses = responses;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MeetingExport meetingExport = (MeetingExport) o;
    return Objects.equals(this.meetingId, meetingExport.meetingId) &&
        Objects.equals(this.responses, meetingExport.responses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(meetingId, responses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeetingExport {\n");
    sb.append("    meetingId: ").append(toIndentedString(meetingId)).append("\n");
    sb.append("    responses: ").append(toIndentedString(responses)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

