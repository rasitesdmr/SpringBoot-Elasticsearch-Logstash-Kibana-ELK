package com.example.client.feign;

import com.example.client.dto.request.LessonCreateRequest;
import com.example.client.dto.response.LessonCreateResponse;
import com.example.client.exception.ServiceUnavailableException;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "lesson-service", url = "http://localhost:1002/lesson")
public interface LessonFeignClient {



    @PostMapping(value = "/createLesson", consumes = MediaType.APPLICATION_JSON_VALUE)
    LessonCreateResponse feignCreateLesson(@RequestBody LessonCreateRequest lessonCreateRequest);
    

//    default LessonCreateResponse feignCreateLesson(Exception exception) {
//        if (exception instanceof FeignException feignException) {
//            int status = feignException.status();
//            if (status == -1) {
//
//                throw new ServiceUnavailableException("İstek attığınız servis şuan hizmette değil!");
//            }
//        }
//        return new LessonCreateResponse();
//    }
}
