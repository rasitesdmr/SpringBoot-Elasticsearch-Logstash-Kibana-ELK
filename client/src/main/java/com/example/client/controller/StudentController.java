package com.example.client.controller;

import com.example.client.dto.request.StudentCreateRequest;
import com.example.client.dto.response.StudentCreateResponse;
import com.example.client.feign.StudentFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentFeignClient studentFeignClient;

    @PostMapping("/createStudent")
    public ResponseEntity<StudentCreateResponse> createStudent (@RequestBody StudentCreateRequest studentCreateRequest){
        log.info(studentCreateRequest.getIdentityNumber() + " numaralı öğrencinin kayıt işlemi başladı...");
        return new ResponseEntity<>(studentFeignClient.feignCreateStudent(studentCreateRequest), HttpStatus.CREATED);
    }
}
