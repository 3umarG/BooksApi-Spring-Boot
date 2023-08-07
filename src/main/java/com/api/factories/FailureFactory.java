package com.api.factories;

import com.api.responses.FailureResponse;
import com.api.responses.Response;
import lombok.AllArgsConstructor;

public class FailureFactory extends BaseFactory<Object> {

    private final String message;

    public FailureFactory(String message) {
        this.message = message;
    }

    @Override
    public Response<Object> createResponse() {
        return new FailureResponse(message);
    }
}
