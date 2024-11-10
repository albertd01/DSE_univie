package com.dse.model;

import java.net.URI;
import java.util.Objects;
import com.dse.model.Availability;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.hateoas.RepresentationModel;

import java.util.*;
import jakarta.annotation.Generated;

/**
 * TimeSlot
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-13T10:38:19.491351+02:00[Europe/Vienna]", comments = "Generator version: 7.5.0")
public class TimeSlot extends RepresentationModel<TimeSlot>  {

  private UUID id;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime start;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime end;

  @Valid
  private List<@Valid Availability> availabilities = new ArrayList<>();

  public TimeSlot id(UUID id) {
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

  public TimeSlot start(OffsetDateTime start) {
    this.start = start;
    return this;
  }

  /**
   * Get start
   * @return start
  */
  @Valid 
  @Schema(name = "start", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("start")
  public OffsetDateTime getStart() {
    return start;
  }

  public void setStart(OffsetDateTime start) {
    this.start = start;
  }

  public TimeSlot end(OffsetDateTime end) {
    this.end = end;
    return this;
  }

  /**
   * Get end
   * @return end
  */
  @Valid 
  @Schema(name = "end", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("end")
  public OffsetDateTime getEnd() {
    return end;
  }

  public void setEnd(OffsetDateTime end) {
    this.end = end;
  }

  public TimeSlot availabilities(List<@Valid Availability> availabilities) {
    this.availabilities = availabilities;
    return this;
  }

  public TimeSlot addAvailabilitiesItem(Availability availabilitiesItem) {
    if (this.availabilities == null) {
      this.availabilities = new ArrayList<>();
    }
    this.availabilities.add(availabilitiesItem);
    return this;
  }

  /**
   * Get availabilities
   * @return availabilities
  */
  @Valid 
  @Schema(name = "availabilities", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("availabilities")
  public List<@Valid Availability> getAvailabilities() {
    return availabilities;
  }

  public void setAvailabilities(List<@Valid Availability> availabilities) {
    this.availabilities = availabilities;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimeSlot timeSlot = (TimeSlot) o;
    return Objects.equals(this.id, timeSlot.id) &&
        Objects.equals(this.start, timeSlot.start) &&
        Objects.equals(this.end, timeSlot.end) &&
        Objects.equals(this.availabilities, timeSlot.availabilities);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, start, end, availabilities);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeSlot {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    start: ").append(toIndentedString(start)).append("\n");
    sb.append("    end: ").append(toIndentedString(end)).append("\n");
    sb.append("    availabilities: ").append(toIndentedString(availabilities)).append("\n");
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

