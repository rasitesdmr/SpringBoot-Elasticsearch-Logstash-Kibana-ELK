package com.example.client.feign;

import com.example.client.config.RetreiveMessageErrorDecoder;
import com.example.client.dto.request.StudentCreateRequest;
import com.example.client.dto.response.StudentCreateResponse;
import com.example.client.exception.ServiceUnavailableException;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "student-service", url = "http://localhost:1001/student")
public interface StudentFeignClient {
    @PostMapping(value = "/createStudent", consumes = MediaType.APPLICATION_JSON_VALUE)
    StudentCreateResponse feignCreateStudent(@RequestBody StudentCreateRequest studentCreateRequest);

}
