package com.dse.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * TimeSlotAvailabilityRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-10T14:51:03.204359700+02:00[Europe/Vienna]", comments = "Generator version: 7.5.0")
public class TimeSlotAvailabilityRequest {

  private String name;

  /**
   * Gets or Sets availability
   */
  public enum AvailabilityEnum {
    TRUE("true"),
    
    FALSE("false"),
    
    MAYBE("maybe");

    private String value;

    AvailabilityEnum(String value) {
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
    public static AvailabilityEnum fromValue(String value) {
      for (AvailabilityEnum b : AvailabilityEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private AvailabilityEnum availability;

  public TimeSlotAvailabilityRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TimeSlotAvailabilityRequest(String name, AvailabilityEnum availability) {
    this.name = name;
    this.availability = availability;
  }

  public TimeSlotAvailabilityRequest name(String name) {
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

  public TimeSlotAvailabilityRequest availability(AvailabilityEnum availability) {
    this.availability = availability;
    return this;
  }

  /**
   * Get availability
   * @return availability
  */
  @NotNull 
  @Schema(name = "availability", requiredMode = Schema.RequiredMode.REQUIRED)
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
    TimeSlotAvailabilityRequest timeSlotAvailabilityRequest = (TimeSlotAvailabilityRequest) o;
    return Objects.equals(this.name, timeSlotAvailabilityRequest.name) &&
        Objects.equals(this.availability, timeSlotAvailabilityRequest.availability);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, availability);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeSlotAvailabilityRequest {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

