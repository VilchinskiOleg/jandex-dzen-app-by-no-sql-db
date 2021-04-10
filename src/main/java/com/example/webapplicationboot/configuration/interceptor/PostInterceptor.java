package com.example.webapplicationboot.configuration.interceptor;

import com.example.webapplicationboot.rest.model.post.PostRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Reader;

@Slf4j
public class PostInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        var postRequest = readRequestBody(request.getReader());
        return true;
    }

    private PostRequest readRequestBody(Reader bodyReader) {
        try {
            ObjectMapper jsonMapper = new ObjectMapper();
            return jsonMapper.readValue(bodyReader, PostRequest.class);
        } catch (Exception e) {
            log.error("Can not read post request body. Case:{}; details: {}.", e.getCause(), e.getMessage());
            return null;
        }
    }
}
