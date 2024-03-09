package com.deepmetis.sandwichordermanagement.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    @JsonProperty("time_stamp")
    private String timeStamp;

    private int status;

    private String error;

    private String message;

    private String path;

}
