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
 * MeetingUpdateRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-13T10:38:19.491351+02:00[Europe/Vienna]", comments = "Generator version: 7.5.0")
public class MeetingUpdateRequest extends RepresentationModel<MeetingUpdateRequest>  {

  private String title;

  private String description;

  @Valid
  private List<@Valid TimeSlot> timeSlots = new ArrayList<>();

  public MeetingUpdateRequest title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  */
  
  @Schema(name = "title", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public MeetingUpdateRequest description(String description) {
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

  public MeetingUpdateRequest timeSlots(List<@Valid TimeSlot> timeSlots) {
    this.timeSlots = timeSlots;
    return this;
  }

  public MeetingUpdateRequest addTimeSlotsItem(TimeSlot timeSlotsItem) {
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
    MeetingUpdateRequest meetingUpdateRequest = (MeetingUpdateRequest) o;
    return Objects.equals(this.title, meetingUpdateRequest.title) &&
        Objects.equals(this.description, meetingUpdateRequest.description) &&
        Objects.equals(this.timeSlots, meetingUpdateRequest.timeSlots);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, description, timeSlots);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeetingUpdateRequest {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

