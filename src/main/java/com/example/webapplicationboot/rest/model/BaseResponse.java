package com.example.webapplicationboot.rest.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseResponse {

    private Error error;
}
