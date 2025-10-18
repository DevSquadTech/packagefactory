package com.packagefactory.factory.core.utils;



import com.packagefactory.factory.core.constants.ErrorStatus;
import com.packagefactory.factory.core.constants.SuccessStatus;
import com.packagefactory.factory.core.response.ApiError;
import com.packagefactory.factory.core.response.ApiResponse;
import org.springframework.http.HttpStatus;


import java.util.EnumMap;
import java.util.Map;

public class ResponseUtil {

    private static final Map<ErrorStatus, HttpStatus> errorStatusMap = new EnumMap<>(ErrorStatus.class){{
        put(ErrorStatus.ENTRY_NOT_FOUND, HttpStatus.NOT_FOUND);
        put(ErrorStatus.ENTRY_ALREADY_EXISTS, HttpStatus.CONFLICT);
        put(ErrorStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST);
        put(ErrorStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
    }};

    private static final Map<SuccessStatus, HttpStatus> successStatusMap = new EnumMap<>(SuccessStatus.class) {{
        put(SuccessStatus.ENTRY_CREATED, HttpStatus.CREATED);
        put(SuccessStatus.ENTRY_UPDATED, HttpStatus.OK);
        put(SuccessStatus.ENTRY_DELETED, HttpStatus.OK);
        put(SuccessStatus.ENTRY_FOUND, HttpStatus.OK);
    }};

    public static <T> ApiResponse<T> success(T data, SuccessStatus status, String message) {
        HttpStatus httpStatus = successStatusMap.getOrDefault(status, HttpStatus.OK);
        return ApiResponse.<T>builder()
                .statusCode(httpStatus.value())
                .message(message)
                .data(data)
                .error(null)
                .build();
    }

    public static <T> ApiResponse<T> error(String details, ErrorStatus status) {
        HttpStatus httpStatus = errorStatusMap.getOrDefault(status, HttpStatus.INTERNAL_SERVER_ERROR);
        return ApiResponse.<T>builder()
                .statusCode(httpStatus.value())
                .data(null)
                .error(ApiError.builder().details(details).build())
                .build();
    }
}
