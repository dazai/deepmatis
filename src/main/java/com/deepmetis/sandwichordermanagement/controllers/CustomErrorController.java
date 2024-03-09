package com.deepmetis.sandwichordermanagement.controllers;

import com.deepmetis.sandwichordermanagement.dto.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/error")
@RequiredArgsConstructor
public class CustomErrorController implements ErrorController {

    private final DefaultErrorAttributes errorAttributes;

    @RequestMapping("")
    public ResponseEntity<?> error(WebRequest webRequest) {
        Map<String, Object> attributes = errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE, ErrorAttributeOptions.Include.BINDING_ERRORS));
        return ResponseEntity.status(Integer.parseInt(String.valueOf(attributes.get("status")))).body(
                ErrorResponse.builder().timeStamp(LocalDateTime.now().toString()).status(Integer.parseInt(String.valueOf(attributes.get("status"))))
                        .error(String.valueOf(attributes.get("error"))).message(String.valueOf(attributes.get("message")))
                        .path(String.valueOf(attributes.get("path"))).build()
        );
    }

}