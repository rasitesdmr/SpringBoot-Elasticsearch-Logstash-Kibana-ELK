package com.example.studentlessonservice.feign;

import com.example.studentlessonservice.dto.response.StudentIdResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "student-service", url = "http://localhost:1001/student")
public interface StudentFeignClient {

    @GetMapping("/getByStudentId")
    StudentIdResponse feignGetByStudentId (@RequestParam(name = "studentId") long studentId);

}
