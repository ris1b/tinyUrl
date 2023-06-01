package com.tinyurl.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeaderResponse {

    private HttpStatus statusCode;
    private String statusMessage;

}
