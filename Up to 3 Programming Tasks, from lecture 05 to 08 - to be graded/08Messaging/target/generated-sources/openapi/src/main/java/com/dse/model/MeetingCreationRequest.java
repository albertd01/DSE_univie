package com.dse.model;

import java.net.URI;
import java.util.Objects;
import com.dse.model.TimeSlot;
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
 * MeetingCreationRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-15T07:59:44.685903900+02:00[Europe/Vienna]", comments = "Generator version: 7.5.0")
public class MeetingCreationRequest extends RepresentationModel<MeetingCreationRequest>  {

  private String title;

  private String description;

  private String creator;

  @Valid
  private List<@Valid TimeSlot> timeSlots = new ArrayList<>();

  public MeetingCreationRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public MeetingCreationRequest(String title, String creator) {
    this.title = title;
    this.creator = creator;
  }

  public MeetingCreationRequest title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  */
  @NotNull 
  @Schema(name = "title", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public MeetingCreationRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  
  @Schema(name = "description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public MeetingCreationRequest creator(String creator) {
    this.creator = creator;
    return this;
  }

  /**
   * Get creator
   * @return creator
  */
  @NotNull 
  @Schema(name = "creator", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("creator")
  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public MeetingCreationRequest timeSlots(List<@Valid TimeSlot> timeSlots) {
    this.timeSlots = timeSlots;
    return this;
  }

  public MeetingCreationRequest addTimeSlotsItem(TimeSlot timeSlotsItem) {
    if (this.timeSlots == null) {
      this.timeSlots = new ArrayList<>();
    }
    this.timeSlots.add(timeSlotsItem);
    return this;
  }

  /**
   * Get timeSlots
   * @return timeSlots
  */
  @Valid 
  @Schema(name = "timeSlots", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("timeSlots")
  public List<@Valid TimeSlot> getTimeSlots() {
    return timeSlots;
  }

  public void setTimeSlots(List<@Valid TimeSlot> timeSlots) {
    this.timeSlots = timeSlots;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MeetingCreationRequest meetingCreationRequest = (MeetingCreationRequest) o;
    return Objects.equals(this.title, meetingCreationRequest.title) &&
        Objects.equals(this.description, meetingCreationRequest.description) &&
        Objects.equals(this.creator, meetingCreationRequest.creator) &&
        Objects.equals(this.timeSlots, meetingCreationRequest.timeSlots);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, description, creator, timeSlots);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeetingCreationRequest {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
    sb.append("    timeSlots: ").append(toIndentedString(timeSlots)).append("\n");
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

