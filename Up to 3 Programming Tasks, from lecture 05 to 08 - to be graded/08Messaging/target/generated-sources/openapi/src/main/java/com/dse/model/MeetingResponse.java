package com.dse.model;

import java.net.URI;
import java.util.Objects;
import com.dse.model.TimeSlotResponse;
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
 * MeetingResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-15T07:59:44.685903900+02:00[Europe/Vienna]", comments = "Generator version: 7.5.0")
public class MeetingResponse extends RepresentationModel<MeetingResponse>  {

  private String name;

  @Valid
  private List<@Valid TimeSlotResponse> responses = new ArrayList<>();

  public MeetingResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public MeetingResponse(String name, List<@Valid TimeSlotResponse> responses) {
    this.name = name;
    this.responses = responses;
  }

  public MeetingResponse name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MeetingResponse responses(List<@Valid TimeSlotResponse> responses) {
    this.responses = responses;
    return this;
  }

  public MeetingResponse addResponsesItem(TimeSlotResponse responsesItem) {
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
  @NotNull @Valid 
  @Schema(name = "responses", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("responses")
  public List<@Valid TimeSlotResponse> getResponses() {
    return responses;
  }

  public void setResponses(List<@Valid TimeSlotResponse> responses) {
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
    MeetingResponse meetingResponse = (MeetingResponse) o;
    return Objects.equals(this.name, meetingResponse.name) &&
        Objects.equals(this.responses, meetingResponse.responses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, responses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeetingResponse {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

