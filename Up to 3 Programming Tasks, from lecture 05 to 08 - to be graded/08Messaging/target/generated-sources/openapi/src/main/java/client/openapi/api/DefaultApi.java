package client.openapi.api;

import client.openapi.ApiClient;
import client.openapi.BaseApi;

import client.openapi.model.Meeting;
import client.openapi.model.MeetingCreationRequest;
import client.openapi.model.MeetingExport;
import client.openapi.model.MeetingResponse;
import client.openapi.model.MeetingUpdateRequest;
import client.openapi.model.TimeSlotRequest;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-15T07:59:45.588840900+02:00[Europe/Vienna]", comments = "Generator version: 7.5.0")
public class DefaultApi extends BaseApi {

    public DefaultApi() {
        super(new ApiClient());
    }

    public DefaultApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Add time slots to a meeting poll
     * 
     * <p><b>200</b> - Time slots added successfully
     * @param meetingId  (required)
     * @param timeSlotRequest  (required)
     * @return Meeting
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Meeting addTimeSlots(String meetingId, TimeSlotRequest timeSlotRequest) throws RestClientException {
        return addTimeSlotsWithHttpInfo(meetingId, timeSlotRequest).getBody();
    }

    /**
     * Add time slots to a meeting poll
     * 
     * <p><b>200</b> - Time slots added successfully
     * @param meetingId  (required)
     * @param timeSlotRequest  (required)
     * @return ResponseEntity&lt;Meeting&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Meeting> addTimeSlotsWithHttpInfo(String meetingId, TimeSlotRequest timeSlotRequest) throws RestClientException {
        Object localVarPostBody = timeSlotRequest;
        
        // verify the required parameter 'meetingId' is set
        if (meetingId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'meetingId' when calling addTimeSlots");
        }
        
        // verify the required parameter 'timeSlotRequest' is set
        if (timeSlotRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'timeSlotRequest' when calling addTimeSlots");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("meetingId", meetingId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Meeting> localReturnType = new ParameterizedTypeReference<Meeting>() {};
        return apiClient.invokeAPI("/meetings/{meetingId}/timeslots", HttpMethod.POST, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Create a new meeting poll
     * 
     * <p><b>201</b> - Meeting created successfully
     * @param meetingCreationRequest  (required)
     * @return Meeting
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Meeting createMeeting(MeetingCreationRequest meetingCreationRequest) throws RestClientException {
        return createMeetingWithHttpInfo(meetingCreationRequest).getBody();
    }

    /**
     * Create a new meeting poll
     * 
     * <p><b>201</b> - Meeting created successfully
     * @param meetingCreationRequest  (required)
     * @return ResponseEntity&lt;Meeting&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Meeting> createMeetingWithHttpInfo(MeetingCreationRequest meetingCreationRequest) throws RestClientException {
        Object localVarPostBody = meetingCreationRequest;
        
        // verify the required parameter 'meetingCreationRequest' is set
        if (meetingCreationRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'meetingCreationRequest' when calling createMeeting");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Meeting> localReturnType = new ParameterizedTypeReference<Meeting>() {};
        return apiClient.invokeAPI("/meetings", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete a meeting poll
     * 
     * <p><b>204</b> - Meeting deleted successfully
     * @param meetingId  (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteMeeting(String meetingId) throws RestClientException {
        deleteMeetingWithHttpInfo(meetingId);
    }

    /**
     * Delete a meeting poll
     * 
     * <p><b>204</b> - Meeting deleted successfully
     * @param meetingId  (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteMeetingWithHttpInfo(String meetingId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'meetingId' is set
        if (meetingId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'meetingId' when calling deleteMeeting");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("meetingId", meetingId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = {  };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/meetings/{meetingId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Export meeting responses
     * 
     * <p><b>200</b> - Meeting responses exported successfully
     * @param meetingId  (required)
     * @return MeetingExport
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public MeetingExport exportResponses(String meetingId) throws RestClientException {
        return exportResponsesWithHttpInfo(meetingId).getBody();
    }

    /**
     * Export meeting responses
     * 
     * <p><b>200</b> - Meeting responses exported successfully
     * @param meetingId  (required)
     * @return ResponseEntity&lt;MeetingExport&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<MeetingExport> exportResponsesWithHttpInfo(String meetingId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'meetingId' is set
        if (meetingId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'meetingId' when calling exportResponses");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("meetingId", meetingId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<MeetingExport> localReturnType = new ParameterizedTypeReference<MeetingExport>() {};
        return apiClient.invokeAPI("/meetings/{meetingId}/export", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get meeting details
     * 
     * <p><b>200</b> - Meeting details retrieved successfully
     * @param meetingId  (required)
     * @return Meeting
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Meeting getMeeting(String meetingId) throws RestClientException {
        return getMeetingWithHttpInfo(meetingId).getBody();
    }

    /**
     * Get meeting details
     * 
     * <p><b>200</b> - Meeting details retrieved successfully
     * @param meetingId  (required)
     * @return ResponseEntity&lt;Meeting&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Meeting> getMeetingWithHttpInfo(String meetingId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'meetingId' is set
        if (meetingId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'meetingId' when calling getMeeting");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("meetingId", meetingId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Meeting> localReturnType = new ParameterizedTypeReference<Meeting>() {};
        return apiClient.invokeAPI("/meetings/{meetingId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Publish a meeting poll
     * 
     * <p><b>200</b> - Meeting poll published successfully
     * @param meetingId  (required)
     * @return Meeting
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Meeting publishMeeting(String meetingId) throws RestClientException {
        return publishMeetingWithHttpInfo(meetingId).getBody();
    }

    /**
     * Publish a meeting poll
     * 
     * <p><b>200</b> - Meeting poll published successfully
     * @param meetingId  (required)
     * @return ResponseEntity&lt;Meeting&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Meeting> publishMeetingWithHttpInfo(String meetingId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'meetingId' is set
        if (meetingId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'meetingId' when calling publishMeeting");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("meetingId", meetingId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Meeting> localReturnType = new ParameterizedTypeReference<Meeting>() {};
        return apiClient.invokeAPI("/meetings/{meetingId}/publish", HttpMethod.POST, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Remove a time slot from a meeting poll
     * 
     * <p><b>204</b> - Time slot removed successfully
     * @param meetingId  (required)
     * @param timeSlotId  (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void removeTimeSlot(String meetingId, String timeSlotId) throws RestClientException {
        removeTimeSlotWithHttpInfo(meetingId, timeSlotId);
    }

    /**
     * Remove a time slot from a meeting poll
     * 
     * <p><b>204</b> - Time slot removed successfully
     * @param meetingId  (required)
     * @param timeSlotId  (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> removeTimeSlotWithHttpInfo(String meetingId, String timeSlotId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'meetingId' is set
        if (meetingId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'meetingId' when calling removeTimeSlot");
        }
        
        // verify the required parameter 'timeSlotId' is set
        if (timeSlotId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'timeSlotId' when calling removeTimeSlot");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("meetingId", meetingId);
        uriVariables.put("timeSlotId", timeSlotId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = {  };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/meetings/{meetingId}/timeslots/{timeSlotId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Submit responses to a meeting poll
     * 
     * <p><b>200</b> - Responses submitted successfully
     * @param meetingId  (required)
     * @param meetingResponse  (required)
     * @return Meeting
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Meeting submitResponses(String meetingId, MeetingResponse meetingResponse) throws RestClientException {
        return submitResponsesWithHttpInfo(meetingId, meetingResponse).getBody();
    }

    /**
     * Submit responses to a meeting poll
     * 
     * <p><b>200</b> - Responses submitted successfully
     * @param meetingId  (required)
     * @param meetingResponse  (required)
     * @return ResponseEntity&lt;Meeting&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Meeting> submitResponsesWithHttpInfo(String meetingId, MeetingResponse meetingResponse) throws RestClientException {
        Object localVarPostBody = meetingResponse;
        
        // verify the required parameter 'meetingId' is set
        if (meetingId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'meetingId' when calling submitResponses");
        }
        
        // verify the required parameter 'meetingResponse' is set
        if (meetingResponse == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'meetingResponse' when calling submitResponses");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("meetingId", meetingId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Meeting> localReturnType = new ParameterizedTypeReference<Meeting>() {};
        return apiClient.invokeAPI("/meetings/{meetingId}/responses", HttpMethod.POST, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update a meeting poll
     * 
     * <p><b>200</b> - Meeting updated successfully
     * @param meetingId  (required)
     * @param meetingUpdateRequest  (required)
     * @return Meeting
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Meeting updateMeeting(String meetingId, MeetingUpdateRequest meetingUpdateRequest) throws RestClientException {
        return updateMeetingWithHttpInfo(meetingId, meetingUpdateRequest).getBody();
    }

    /**
     * Update a meeting poll
     * 
     * <p><b>200</b> - Meeting updated successfully
     * @param meetingId  (required)
     * @param meetingUpdateRequest  (required)
     * @return ResponseEntity&lt;Meeting&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Meeting> updateMeetingWithHttpInfo(String meetingId, MeetingUpdateRequest meetingUpdateRequest) throws RestClientException {
        Object localVarPostBody = meetingUpdateRequest;
        
        // verify the required parameter 'meetingId' is set
        if (meetingId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'meetingId' when calling updateMeeting");
        }
        
        // verify the required parameter 'meetingUpdateRequest' is set
        if (meetingUpdateRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'meetingUpdateRequest' when calling updateMeeting");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("meetingId", meetingId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Meeting> localReturnType = new ParameterizedTypeReference<Meeting>() {};
        return apiClient.invokeAPI("/meetings/{meetingId}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    @Override
    public <T> ResponseEntity<T> invokeAPI(String url, HttpMethod method, Object request, ParameterizedTypeReference<T> returnType) throws RestClientException {
        String localVarPath = url.replace(apiClient.getBasePath(), "");
        Object localVarPostBody = request;

        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        return apiClient.invokeAPI(localVarPath, method, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, returnType);
    }
}
