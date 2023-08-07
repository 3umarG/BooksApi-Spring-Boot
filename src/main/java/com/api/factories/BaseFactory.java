package com.api.factories;

import com.api.responses.Response;

public abstract class BaseFactory<T> {

    abstract public Response<T> createResponse();
}
