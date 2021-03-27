package com.example.webapplicationboot.rest.model.post;

import com.example.webapplicationboot.rest.model.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponse extends BaseResponse {

    private String message;
}
