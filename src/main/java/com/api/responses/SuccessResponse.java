package com.api.responses;

import lombok.AllArgsConstructor;
import lombok.Data;


public class SuccessResponse<T> extends Response<T> {

    public SuccessResponse(T data) {
        super(true, "Success", data);
    }


}
