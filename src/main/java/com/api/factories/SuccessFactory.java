package com.api.factories;

import com.api.responses.Response;
import com.api.responses.SuccessResponse;

public class SuccessFactory<T> extends BaseFactory<T> {

    private final T data;

    public SuccessFactory(T data) {
        this.data = data;
    }

    @Override
    public Response<T> createResponse() {
        return new SuccessResponse<T>(data);
    }
}
