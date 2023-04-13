package com.example.studentlessonservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.example.studentlessonservice.feign")
public class StudentLessonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentLessonServiceApplication.class, args);
    }

}
