package com.demo.reactbackend.dto;

import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GenericResponseDto<T> {
    private String message = "Success";
    private Integer statusCode;
    private String api;
    private T response;

    public GenericResponseDto(){this.statusCode = HttpStatus.OK.value();}

    public GenericResponseDto(GenericResponseDtoBuilder<T> builder) {
        this.statusCode = HttpStatus.OK.value();
        this.message = builder.message;
        this.statusCode = builder.statusCode;
        this.api = builder.api;
        this.response = builder.response;
    }

    public GenericResponseDto(T t,HttpServletRequest request) {
        this.statusCode = HttpStatus.OK.value();
        this.response = t ;
        this.api = request.getRequestURI();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "GenericResponseDto{" +
                "message='" + message + '\'' +
                ", statusCode=" + statusCode +
                ", api='" + api + '\'' +
                ", response=" + response +
                '}';
    }

    public static class GenericResponseDtoBuilder<T>{
        private String message="Success";
        private Integer statusCode;
        private String api;
        private T response;


        public GenericResponseDtoBuilder(){

        }

        public GenericResponseDtoBuilder(T response){
            this.response = response;
        }

        public GenericResponseDtoBuilder(String message , Integer statusCode , T response){
            this.message = message;
            this.statusCode = statusCode;
            this.api = api;
            this.response = response;
        }


        public GenericResponseDtoBuilder(String message , HttpServletRequest request , T response){
            this.message=message;
            this.response=response;
            this.api=request.getRequestURI();
        }

        public GenericResponseDtoBuilder(String message , HttpServletRequest request , T response, HttpServletResponse servletResponse,HttpStatus status){
            this.message = message;
            this.api = request.getRequestURI();
            this.response = response;
            servletResponse.setStatus(status.value());
        }

        public GenericResponseDtoBuilder(HttpServletRequest request, T response){

            this.api = request.getRequestURI();
            this.response = response;
            this.statusCode = HttpStatus.OK.value();
            this.message = "Success";
        }


        public GenericResponseDtoBuilder<T> message(String message){
            this.message = "Success";
            return this;
        }

        public GenericResponseDtoBuilder<T> statusCode(Integer statusCode){
            this.statusCode = statusCode;
            return this;
        }

        public GenericResponseDtoBuilder<T> api(String api){
            this.api = api;
            return this;
        }

        public GenericResponseDtoBuilder<T> response(T response){
            this.api = api;
            return this;
        }

        public GenericResponseDto<T> build() {
            return new GenericResponseDto<>(this);
        }
    }

}
