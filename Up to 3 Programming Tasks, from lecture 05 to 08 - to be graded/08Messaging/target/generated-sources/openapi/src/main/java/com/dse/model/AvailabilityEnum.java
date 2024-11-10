package com.dse.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.hateoas.RepresentationModel;

import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets AvailabilityEnum
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-15T07:59:44.685903900+02:00[Europe/Vienna]", comments = "Generator version: 7.5.0")
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

