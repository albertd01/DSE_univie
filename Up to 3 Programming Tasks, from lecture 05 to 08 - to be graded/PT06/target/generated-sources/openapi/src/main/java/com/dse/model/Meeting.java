package com.dse.model;

import java.net.URI;
import java.util.Objects;
import com.dse.model.TimeSlot;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.hateoas.RepresentationModel;

import java.util.*;
import jakarta.annotation.Generated;

/**
 * Meeting
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-13T10:38:19.491351+02:00[Europe/Vienna]", comments = "Generator version: 7.5.0")
public class Meeting extends RepresentationModel<Meeting>  {

  private UUID id;

  private String title;

  private String description;

  private String creator;

  @Valid
  private List<@Valid TimeSlot> timeSlots = new ArrayList<>();

  private Boolean published;

  public Meeting id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @Valid 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Meeting title(String title) {
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

  public Meeting description(String description) {
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

  public Meeting creator(String creator) {
    this.creator = creator;
    return this;
  }

  /**
   * Get creator
   * @return creator
  */
  
  @Schema(name = "creator", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("creator")
  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public Meeting timeSlots(List<@Valid TimeSlot> timeSlots) {
    this.timeSlots = timeSlots;
    return this;
  }

  public Meeting addTimeSlotsItem(TimeSlot timeSlotsItem) {
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

  public Meeting published(Boolean published) {
    this.published = published;
    return this;
  }

  /**
   * Get published
   * @return published
  */
  
  @Schema(name = "published", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("published")
  public Boolean getPublished() {
    return published;
  }

  public void setPublished(Boolean published) {
    this.published = published;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Meeting meeting = (Meeting) o;
    return Objects.equals(this.id, meeting.id) &&
        Objects.equals(this.title, meeting.title) &&
        Objects.equals(this.description, meeting.description) &&
        Objects.equals(this.creator, meeting.creator) &&
        Objects.equals(this.timeSlots, meeting.timeSlots) &&
        Objects.equals(this.published, meeting.published);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, description, creator, timeSlots, published);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Meeting {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
    sb.append("    timeSlots: ").append(toIndentedString(timeSlots)).append("\n");
    sb.append("    published: ").append(toIndentedString(published)).append("\n");
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

