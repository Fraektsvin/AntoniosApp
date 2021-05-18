package com.example.dannyappPokemonApp.Request.Response;

import java.io.IOException;

import retrofit2.Response;

public class ApiResponseGeneric<T> {
    //
    public ApiResponseGeneric<T> Create(Throwable error) {
        return new ErrorResponse<>(error.getMessage().equals("")? error.getMessage(): "not known error/check your network");
    }
    public ApiResponseGeneric<T> Create(Response<T> response) {
        if(response.isSuccessful()) {
            T body = response.body();

            if(body == null || response.code() == 204) { // no content
                return new ApisuccessfuullEmpty<>();
            }
            else {
                return new Apisuccesfullresponse<>(body);
            }
        }
        else {
            String errormessage = "";
            try {
                errormessage = response.errorBody().string();
            } catch (IOException e) {
                e.printStackTrace();
                errormessage = response.message();
            }
            return new ErrorResponse<>(errormessage);
        }
    }
    public class Apisuccesfullresponse<T> extends ApiResponseGeneric  {
    private T body;



        public Apisuccesfullresponse(T body) {
            this.body = body;
        }

        public T getBody() {
            return body;
        }

    }
    public class ErrorResponse<T> extends ApiResponseGeneric{
        private String Errormessage;

        public ErrorResponse(String errormessage) {
            Errormessage = errormessage;
        }

        public String getErrormessage() {
            return Errormessage;
        }
    }
    public class ApisuccessfuullEmpty<T> extends ApiResponseGeneric {

    }
}
