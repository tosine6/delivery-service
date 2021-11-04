package com.diplomaticdelivery.diplomatic.response;

import com.diplomaticdelivery.diplomatic.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Setter
@Getter
@Accessors(chain = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse<T> {

    private Status status;
    private T payload;
    private Object errors;
    private Object metaData;

    public static <T> ApiResponse<T> badRequest(){
        ApiResponse<T> response = new ApiResponse<>();
        response.setStatus(Status.FAILED);
        return response;
    }

    public static <T> ApiResponse<T> unAuthorized(){
        ApiResponse<T> response = new ApiResponse<>();
        response.setStatus(Status.UNAUTHORIZED);
        return response;
    }

    public static <T> ApiResponse<T> notFound(){
        ApiResponse<T> response = new ApiResponse<>();
        response.setStatus(Status.NOT_FOUND);
        return response;
    }

    public void responseErrorMsg(String errorMsg, Exception ex){
        ApiResponseError error = new ApiResponseError()
                .setDetails(errorMsg)
                .setMessage(ex.getMessage())
                .setTimeStamp(LocalDateTime.now());
    }

    @Getter
    @Accessors(chain = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PageMetaData{

        private int size;
        private long totalElements;
        private int totalPages;
        private int number;

        public PageMetaData(int size, long totalElements, int totalPages, int number) {
            this.size = size;
            this.totalElements = totalElements;
            this.totalPages = totalPages;
            this.number = number;
        }
    }
}
