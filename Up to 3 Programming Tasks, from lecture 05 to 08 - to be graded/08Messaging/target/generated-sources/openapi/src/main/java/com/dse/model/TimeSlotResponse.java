package com.dse.model;

import java.net.URI;
import java.util.Objects;
import com.dse.model.AvailabilityEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.hateoas.RepresentationModel;

import java.util.*;
import jakarta.annotation.Generated;

/**
 * TimeSlotResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-15T07:59:44.685903900+02:00[Europe/Vienna]", comments = "Generator version: 7.5.0")
public class TimeSlotResponse extends RepresentationModel<TimeSlotResponse>  {

  private String timeSlotId;

  private AvailabilityEnum availability;

  public TimeSlotResponse timeSlotId(String timeSlotId) {
    this.timeSlotId = timeSlotId;
    return this;
  }

  /**
   * Get timeSlotId
   * @return timeSlotId
  */
  
  @Schema(name = "timeSlotId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("timeSlotId")
  public String getTimeSlotId() {
    return timeSlotId;
  }

  public void setTimeSlotId(String timeSlotId) {
    this.timeSlotId = timeSlotId;
  }

  public TimeSlotResponse availability(AvailabilityEnum availability) {
    this.availability = availability;
    return this;
  }

  /**
   * Get availability
   * @return availability
  */
  @Valid 
  @Schema(name = "availability", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("availability")
  public AvailabilityEnum getAvailability() {
    return availability;
  }

  public void setAvailability(AvailabilityEnum availability) {
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
    TimeSlotResponse timeSlotResponse = (TimeSlotResponse) o;
    return Objects.equals(this.timeSlotId, timeSlotResponse.timeSlotId) &&
        Objects.equals(this.availability, timeSlotResponse.availability);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timeSlotId, availability);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeSlotResponse {\n");
    sb.append("    timeSlotId: ").append(toIndentedString(timeSlotId)).append("\n");
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

