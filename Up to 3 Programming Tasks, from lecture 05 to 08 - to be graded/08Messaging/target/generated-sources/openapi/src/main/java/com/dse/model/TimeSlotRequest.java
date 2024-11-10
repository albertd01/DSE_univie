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
 * TimeSlotRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-15T07:59:44.685903900+02:00[Europe/Vienna]", comments = "Generator version: 7.5.0")
public class TimeSlotRequest extends RepresentationModel<TimeSlotRequest>  {

  @Valid
  private List<@Valid TimeSlot> timeSlots = new ArrayList<>();

  public TimeSlotRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TimeSlotRequest(List<@Valid TimeSlot> timeSlots) {
    this.timeSlots = timeSlots;
  }

  public TimeSlotRequest timeSlots(List<@Valid TimeSlot> timeSlots) {
    this.timeSlots = timeSlots;
    return this;
  }

  public TimeSlotRequest addTimeSlotsItem(TimeSlot timeSlotsItem) {
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
  @NotNull @Valid 
  @Schema(name = "timeSlots", requiredMode = Schema.RequiredMode.REQUIRED)
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
    TimeSlotRequest timeSlotRequest = (TimeSlotRequest) o;
    return Objects.equals(this.timeSlots, timeSlotRequest.timeSlots);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timeSlots);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeSlotRequest {\n");
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

