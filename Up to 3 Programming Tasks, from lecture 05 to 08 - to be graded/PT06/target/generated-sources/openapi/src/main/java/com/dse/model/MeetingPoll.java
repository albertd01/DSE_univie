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


import java.util.*;
import jakarta.annotation.Generated;

/**
 * MeetingPoll
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-10T11:18:35.707084700+02:00[Europe/Vienna]", comments = "Generator version: 7.5.0")
public class MeetingPoll {

  private UUID id;

  private String title;

  @Valid
  private List<@Valid TimeSlot> slots = new ArrayList<>();

  private String creator;

  public MeetingPoll id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for the meeting poll.
   * @return id
  */
  @Valid 
  @Schema(name = "id", description = "Unique identifier for the meeting poll.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public MeetingPoll title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Title of the meeting poll.
   * @return title
  */
  
  @Schema(name = "title", description = "Title of the meeting poll.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public MeetingPoll slots(List<@Valid TimeSlot> slots) {
    this.slots = slots;
    return this;
  }

  public MeetingPoll addSlotsItem(TimeSlot slotsItem) {
    if (this.slots == null) {
      this.slots = new ArrayList<>();
    }
    this.slots.add(slotsItem);
    return this;
  }

  /**
   * Get slots
   * @return slots
  */
  @Valid 
  @Schema(name = "slots", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("slots")
  public List<@Valid TimeSlot> getSlots() {
    return slots;
  }

  public void setSlots(List<@Valid TimeSlot> slots) {
    this.slots = slots;
  }

  public MeetingPoll creator(String creator) {
    this.creator = creator;
    return this;
  }

  /**
   * Username of the meeting creator.
   * @return creator
  */
  
  @Schema(name = "creator", description = "Username of the meeting creator.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("creator")
  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MeetingPoll meetingPoll = (MeetingPoll) o;
    return Objects.equals(this.id, meetingPoll.id) &&
        Objects.equals(this.title, meetingPoll.title) &&
        Objects.equals(this.slots, meetingPoll.slots) &&
        Objects.equals(this.creator, meetingPoll.creator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, slots, creator);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeetingPoll {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    slots: ").append(toIndentedString(slots)).append("\n");
    sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
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

