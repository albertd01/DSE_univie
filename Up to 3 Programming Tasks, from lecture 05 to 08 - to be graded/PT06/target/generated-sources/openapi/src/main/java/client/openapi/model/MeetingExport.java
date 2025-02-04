/*
 * Meeting Scheduler API
 * API for scheduling and managing meeting polls.
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package client.openapi.model;

import java.util.Objects;
import java.util.Arrays;
import client.openapi.model.MeetingResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * MeetingExport
 */
@JsonPropertyOrder({
  MeetingExport.JSON_PROPERTY_MEETING_ID,
  MeetingExport.JSON_PROPERTY_RESPONSES
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-13T10:38:20.204862800+02:00[Europe/Vienna]", comments = "Generator version: 7.5.0")
public class MeetingExport {
  public static final String JSON_PROPERTY_MEETING_ID = "meetingId";
  private String meetingId;

  public static final String JSON_PROPERTY_RESPONSES = "responses";
  private List<MeetingResponse> responses = new ArrayList<>();

  public MeetingExport() {
  }

  public MeetingExport meetingId(String meetingId) {
    
    this.meetingId = meetingId;
    return this;
  }

   /**
   * Get meetingId
   * @return meetingId
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MEETING_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMeetingId() {
    return meetingId;
  }


  @JsonProperty(JSON_PROPERTY_MEETING_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMeetingId(String meetingId) {
    this.meetingId = meetingId;
  }


  public MeetingExport responses(List<MeetingResponse> responses) {
    
    this.responses = responses;
    return this;
  }

  public MeetingExport addResponsesItem(MeetingResponse responsesItem) {
    if (this.responses == null) {
      this.responses = new ArrayList<>();
    }
    this.responses.add(responsesItem);
    return this;
  }

   /**
   * Get responses
   * @return responses
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_RESPONSES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<MeetingResponse> getResponses() {
    return responses;
  }


  @JsonProperty(JSON_PROPERTY_RESPONSES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResponses(List<MeetingResponse> responses) {
    this.responses = responses;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MeetingExport meetingExport = (MeetingExport) o;
    return Objects.equals(this.meetingId, meetingExport.meetingId) &&
        Objects.equals(this.responses, meetingExport.responses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(meetingId, responses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeetingExport {\n");
    sb.append("    meetingId: ").append(toIndentedString(meetingId)).append("\n");
    sb.append("    responses: ").append(toIndentedString(responses)).append("\n");
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

