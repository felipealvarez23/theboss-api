package com.ez.theboss.exceptions.model;

import com.ez.theboss.exceptions.ClassRoomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ClassRoomException.class})
    public ResponseEntity<Object> handleClassRoomException(ClassRoomException e){
        log.error(e.getPrettyMessage(),e);
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(ErrorResponse.builder()
                .message(e.getPrettyMessage())
                .status(badRequest)
                .timestamp(ZonedDateTime.now(ZoneId.of("Z")))
                .build(), badRequest);
    }

}
