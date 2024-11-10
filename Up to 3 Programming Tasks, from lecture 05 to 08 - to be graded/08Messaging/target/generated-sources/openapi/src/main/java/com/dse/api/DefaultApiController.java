package com.dse.api;

import com.dse.model.MeetingPoll;
import com.dse.model.Submission;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-26T19:25:32.516232100+02:00[Europe/Vienna]", comments = "Generator version: 7.5.0")
@Controller
@RequestMapping("${openapi.meetingScheduler.base-path:/rest/pt6}")
public class DefaultApiController implements DefaultApi {

    private final DefaultApiDelegate delegate;

    public DefaultApiController(@Autowired(required = false) DefaultApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new DefaultApiDelegate() {});
    }

    @Override
    public DefaultApiDelegate getDelegate() {
        return delegate;
    }

}
