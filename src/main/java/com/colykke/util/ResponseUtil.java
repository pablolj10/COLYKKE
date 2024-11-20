package com.colykke.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.colykke.dto.ApiResponse;

public class ResponseUtil {

	private static final String timestampFormat = "dd/MM/yyyy HH:mm:ss";
	 
    public static <T> ResponseEntity<ApiResponse<T>> response(T data, HttpStatus httpStatus, String message) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String formatTime = localDateTime.format(DateTimeFormatter.ofPattern(timestampFormat));
 
        ApiResponse<T> response =  ApiResponse.<T>builder()
                .timestamp(formatTime)
                .data(data)
                .message(message)
                .status(httpStatus)
                .build();
       return new ResponseEntity<>(response, httpStatus);
    }
}
