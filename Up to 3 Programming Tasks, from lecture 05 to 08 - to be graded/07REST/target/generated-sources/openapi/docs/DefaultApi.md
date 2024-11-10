# DefaultApi

All URIs are relative to *http://localhost:8080/rest/pt6*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addTimeSlots**](DefaultApi.md#addTimeSlots) | **POST** /meetings/{meetingId}/timeslots | Add time slots to a meeting poll |
| [**createMeeting**](DefaultApi.md#createMeeting) | **POST** /meetings | Create a new meeting poll |
| [**deleteMeeting**](DefaultApi.md#deleteMeeting) | **DELETE** /meetings/{meetingId} | Delete a meeting poll |
| [**exportResponses**](DefaultApi.md#exportResponses) | **GET** /meetings/{meetingId}/export | Export meeting responses |
| [**getMeeting**](DefaultApi.md#getMeeting) | **GET** /meetings/{meetingId} | Get meeting details |
| [**publishMeeting**](DefaultApi.md#publishMeeting) | **POST** /meetings/{meetingId}/publish | Publish a meeting poll |
| [**removeTimeSlot**](DefaultApi.md#removeTimeSlot) | **DELETE** /meetings/{meetingId}/timeslots/{timeSlotId} | Remove a time slot from a meeting poll |
| [**submitResponses**](DefaultApi.md#submitResponses) | **POST** /meetings/{meetingId}/responses | Submit responses to a meeting poll |
| [**updateMeeting**](DefaultApi.md#updateMeeting) | **PUT** /meetings/{meetingId} | Update a meeting poll |



## addTimeSlots

> Meeting addTimeSlots(meetingId, timeSlotRequest)

Add time slots to a meeting poll

### Example

```java
// Import classes:
import client.openapi.ApiClient;
import client.openapi.ApiException;
import client.openapi.Configuration;
import client.openapi.models.*;
import client.openapi.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080/rest/pt6");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        String meetingId = "meetingId_example"; // String | 
        TimeSlotRequest timeSlotRequest = new TimeSlotRequest(); // TimeSlotRequest | 
        try {
            Meeting result = apiInstance.addTimeSlots(meetingId, timeSlotRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#addTimeSlots");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **meetingId** | **String**|  | |
| **timeSlotRequest** | [**TimeSlotRequest**](TimeSlotRequest.md)|  | |

### Return type

[**Meeting**](Meeting.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Time slots added successfully |  -  |


## createMeeting

> Meeting createMeeting(meetingCreationRequest)

Create a new meeting poll

### Example

```java
// Import classes:
import client.openapi.ApiClient;
import client.openapi.ApiException;
import client.openapi.Configuration;
import client.openapi.models.*;
import client.openapi.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080/rest/pt6");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        MeetingCreationRequest meetingCreationRequest = new MeetingCreationRequest(); // MeetingCreationRequest | 
        try {
            Meeting result = apiInstance.createMeeting(meetingCreationRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#createMeeting");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **meetingCreationRequest** | [**MeetingCreationRequest**](MeetingCreationRequest.md)|  | |

### Return type

[**Meeting**](Meeting.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Meeting created successfully |  -  |


## deleteMeeting

> deleteMeeting(meetingId)

Delete a meeting poll

### Example

```java
// Import classes:
import client.openapi.ApiClient;
import client.openapi.ApiException;
import client.openapi.Configuration;
import client.openapi.models.*;
import client.openapi.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080/rest/pt6");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        String meetingId = "meetingId_example"; // String | 
        try {
            apiInstance.deleteMeeting(meetingId);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#deleteMeeting");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **meetingId** | **String**|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Meeting deleted successfully |  -  |


## exportResponses

> MeetingExport exportResponses(meetingId)

Export meeting responses

### Example

```java
// Import classes:
import client.openapi.ApiClient;
import client.openapi.ApiException;
import client.openapi.Configuration;
import client.openapi.models.*;
import client.openapi.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080/rest/pt6");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        String meetingId = "meetingId_example"; // String | 
        try {
            MeetingExport result = apiInstance.exportResponses(meetingId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#exportResponses");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **meetingId** | **String**|  | |

### Return type

[**MeetingExport**](MeetingExport.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Meeting responses exported successfully |  -  |


## getMeeting

> Meeting getMeeting(meetingId)

Get meeting details

### Example

```java
// Import classes:
import client.openapi.ApiClient;
import client.openapi.ApiException;
import client.openapi.Configuration;
import client.openapi.models.*;
import client.openapi.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080/rest/pt6");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        String meetingId = "meetingId_example"; // String | 
        try {
            Meeting result = apiInstance.getMeeting(meetingId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#getMeeting");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **meetingId** | **String**|  | |

### Return type

[**Meeting**](Meeting.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Meeting details retrieved successfully |  -  |


## publishMeeting

> Meeting publishMeeting(meetingId)

Publish a meeting poll

### Example

```java
// Import classes:
import client.openapi.ApiClient;
import client.openapi.ApiException;
import client.openapi.Configuration;
import client.openapi.models.*;
import client.openapi.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080/rest/pt6");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        String meetingId = "meetingId_example"; // String | 
        try {
            Meeting result = apiInstance.publishMeeting(meetingId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#publishMeeting");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **meetingId** | **String**|  | |

### Return type

[**Meeting**](Meeting.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Meeting poll published successfully |  -  |


## removeTimeSlot

> removeTimeSlot(meetingId, timeSlotId)

Remove a time slot from a meeting poll

### Example

```java
// Import classes:
import client.openapi.ApiClient;
import client.openapi.ApiException;
import client.openapi.Configuration;
import client.openapi.models.*;
import client.openapi.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080/rest/pt6");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        String meetingId = "meetingId_example"; // String | 
        String timeSlotId = "timeSlotId_example"; // String | 
        try {
            apiInstance.removeTimeSlot(meetingId, timeSlotId);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#removeTimeSlot");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **meetingId** | **String**|  | |
| **timeSlotId** | **String**|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Time slot removed successfully |  -  |


## submitResponses

> Meeting submitResponses(meetingId, meetingResponse)

Submit responses to a meeting poll

### Example

```java
// Import classes:
import client.openapi.ApiClient;
import client.openapi.ApiException;
import client.openapi.Configuration;
import client.openapi.models.*;
import client.openapi.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080/rest/pt6");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        String meetingId = "meetingId_example"; // String | 
        MeetingResponse meetingResponse = new MeetingResponse(); // MeetingResponse | 
        try {
            Meeting result = apiInstance.submitResponses(meetingId, meetingResponse);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#submitResponses");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **meetingId** | **String**|  | |
| **meetingResponse** | [**MeetingResponse**](MeetingResponse.md)|  | |

### Return type

[**Meeting**](Meeting.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Responses submitted successfully |  -  |


## updateMeeting

> Meeting updateMeeting(meetingId, meetingUpdateRequest)

Update a meeting poll

### Example

```java
// Import classes:
import client.openapi.ApiClient;
import client.openapi.ApiException;
import client.openapi.Configuration;
import client.openapi.models.*;
import client.openapi.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080/rest/pt6");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        String meetingId = "meetingId_example"; // String | 
        MeetingUpdateRequest meetingUpdateRequest = new MeetingUpdateRequest(); // MeetingUpdateRequest | 
        try {
            Meeting result = apiInstance.updateMeeting(meetingId, meetingUpdateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#updateMeeting");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **meetingId** | **String**|  | |
| **meetingUpdateRequest** | [**MeetingUpdateRequest**](MeetingUpdateRequest.md)|  | |

### Return type

[**Meeting**](Meeting.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Meeting updated successfully |  -  |

