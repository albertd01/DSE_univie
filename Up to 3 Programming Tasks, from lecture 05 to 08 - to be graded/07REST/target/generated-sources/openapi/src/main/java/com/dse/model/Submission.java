package com.dse.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Submission
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-10T11:18:35.707084700+02:00[Europe/Vienna]", comments = "Generator version: 7.5.0")
public class Submission {

  private String meetingId;

  private String userName;

  /**
   * Gets or Sets inner
   */
  public enum InnerEnum {
    TRUE("true"),
    
    FALSE("false"),
    
    MAYBE("Maybe");

    private String value;

    InnerEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static InnerEnum fromValue(String value) {
      for (InnerEnum b : InnerEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @Valid
  private Map<String, InnerEnum> availability = new HashMap<>();

  public Submission meetingId(String meetingId) {
    this.meetingId = meetingId;
    return this;
  }

  /**
   * ID of the meeting poll to which this submission relates.
   * @return meetingId
  */
  
  @Schema(name = "meetingId", description = "ID of the meeting poll to which this submission relates.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("meetingId")
  public String getMeetingId() {
    return meetingId;
  }

  public void setMeetingId(String meetingId) {
    this.meetingId = meetingId;
  }

  public Submission userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * Name of the user submitting their availability.
   * @return userName
  */
  
  @Schema(name = "userName", description = "Name of the user submitting their availability.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userName")
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Submission availability(Map<String, InnerEnum> availability) {
    this.availability = availability;
    return this;
  }

  public Submission putAvailabilityItem(String key, InnerEnum availabilityItem) {
    if (this.availability == null) {
      this.availability = new HashMap<>();
    }
    this.availability.put(key, availabilityItem);
    return this;
  }

  /**
   * Availability status for each proposed time slot.
   * @return availability
  */
  
  @Schema(name = "availability", description = "Availability status for each proposed time slot.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("availability")
  public Map<String, InnerEnum> getAvailability() {
    return availability;
  }

  public void setAvailability(Map<String, InnerEnum> availability) {
    this.availability = availability;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Submission submission = (Submission) o;
    return Objects.equals(this.meetingId, submission.meetingId) &&
        Objects.equals(this.userName, submission.userName) &&
        Objects.equals(this.availability, submission.availability);
  }

  @Override
  public int hashCode() {
    return Objects.hash(meetingId, userName, availability);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Submission {\n");
    sb.append("    meetingId: ").append(toIndentedString(meetingId)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    availability: ").append(toIndentedString(availability)).append("\n");
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

