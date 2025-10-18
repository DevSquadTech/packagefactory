package com.packagefactory.factory.exception;

import com.packagefactory.factory.core.constants.ErrorStatus;
import com.packagefactory.factory.core.response.ApiResponse;
import com.packagefactory.factory.core.utils.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleNotFound(NotFoundException ex) {
        ApiResponse<?> resp = ResponseUtil.error(ex.getMessage(), ErrorStatus.ENTRY_NOT_FOUND);
        return ResponseEntity.status(resp.getStatusCode()).body(resp);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<?>> handleBadRequest(IllegalArgumentException ex) {
        ApiResponse<?> resp = ResponseUtil.error(ex.getMessage(), ErrorStatus.BAD_REQUEST);
        return ResponseEntity.status(resp.getStatusCode()).body(resp);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleValidation(MethodArgumentNotValidException ex) {
        String details = ex.getBindingResult().getFieldErrors().stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .reduce((a,b)->a + "; " + b).orElse(ex.getMessage());
        ApiResponse<?> resp = ResponseUtil.error(details, ErrorStatus.BAD_REQUEST);
        return ResponseEntity.status(resp.getStatusCode()).body(resp);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleAll(Exception ex) {
        ApiResponse<?> resp = ResponseUtil.error(ex.getMessage(), ErrorStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(resp.getStatusCode()).body(resp);
    }
}
