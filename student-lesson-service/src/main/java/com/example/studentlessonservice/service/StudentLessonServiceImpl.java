package com.example.studentlessonservice.service;

import com.example.studentlessonservice.dto.request.StudentLessonRequest;
import com.example.studentlessonservice.dto.response.LessonIdResponse;
import com.example.studentlessonservice.dto.response.StudentIdResponse;
import com.example.studentlessonservice.dto.response.StudentLessonResponse;
import com.example.studentlessonservice.exception.NotAvailableException;
import com.example.studentlessonservice.feign.LessonFeignClient;
import com.example.studentlessonservice.feign.StudentFeignClient;
import com.example.studentlessonservice.model.StudentLesson;
import com.example.studentlessonservice.repository.StudentLessonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentLessonServiceImpl implements StudentLessonService {

    private final StudentLessonRepository studentLessonRepository;

    private final StudentFeignClient studentFeignClient;

    private final LessonFeignClient lessonFeignClient;

    @Override
    public StudentLessonResponse studentLessonMatch(StudentLessonRequest studentLessonRequest) {

        StudentIdResponse student = studentFeignClient.feignGetByStudentId(studentLessonRequest.getStudentId());
        LessonIdResponse lesson = lessonFeignClient.getByLessonId(studentLessonRequest.getLessonId());

        if (student == null) {
            log.error(studentLessonRequest.getStudentId() + " id ye sahip öğrenci mevcut değil!");
            throw new NotAvailableException(studentLessonRequest.getStudentId() + " id ye sahip öğrenci mevcut değil!");
        }

        if (lesson == null) {
            log.error(studentLessonRequest.getLessonId() + " id ye sahip ders mevcut değil !");
            throw new NotAvailableException(studentLessonRequest.getLessonId() + " id ye sahip ders mevcut değil !");
        }

        StudentLesson studentLesson = new StudentLesson();

        if (studentLessonRepository.findAll().stream().noneMatch(currentStudent -> currentStudent.getStudentId() == student.getId())
                && studentLessonRepository.findAll().stream().noneMatch(currentLesson -> currentLesson.getLessonId() == lesson.getId())) {
            studentLesson.setStudentId(studentLessonRequest.getStudentId());
            studentLesson.setLessonId(studentLessonRequest.getLessonId());
            studentLessonRepository.save(studentLesson);
        } else {
            log.error(studentLessonRequest.getStudentId() + " id ye sahip öğrenci ile " + studentLessonRequest.getLessonId() + " id ye sahip ders eşleştirilemedi !");
            throw new NotAvailableException(studentLessonRequest.getStudentId() + " id ye sahip öğrenci ile " + studentLessonRequest.getLessonId() + " id ye sahip ders eşleştirilemedi !");
        }

        StudentLessonResponse studentLessonResponse = new StudentLessonResponse();
        studentLessonResponse.setId(studentLesson.getId());
        studentLessonResponse.setStudentFullName(student.getFirstName() + " " + student.getLastName());
        studentLessonResponse.setLessonCode(lesson.getCode());

        return studentLessonResponse;
    }
}
