package com.ez.theboss.exceptions.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@Builder
public class ErrorResponse {

    private final HttpStatus status;

    private final ZonedDateTime timestamp;

    private final String message;

    public ErrorResponse(HttpStatus status, ZonedDateTime timestamp,
                         String message) {
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
    }
}
