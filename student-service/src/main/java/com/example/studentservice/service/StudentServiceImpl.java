package com.example.studentservice.service;

import com.example.studentservice.dto.request.StudentCreateRequest;
import com.example.studentservice.dto.response.StudentCreateResponse;
import com.example.studentservice.dto.response.StudentIdResponse;
import com.example.studentservice.exception.AlreadyAvailableException;
import com.example.studentservice.exception.NotAvailableException;
import com.example.studentservice.model.Student;
import com.example.studentservice.repository.StudentRepository;
import com.example.studentservice.util.RegexUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public StudentCreateResponse createStudent(StudentCreateRequest studentCreateRequest) {

        var identityNumber = studentCreateRequest.getIdentityNumber();
        var schoolNumber = studentCreateRequest.getSchoolNumber();
        if (studentRepository.existsByIdentityNumber(identityNumber)) {
            log.error(identityNumber + " kimliğe sahip öğrenci zaten var!");
            throw new AlreadyAvailableException(identityNumber + " kimliğe sahip öğrenci zaten mevcut!");
        }
        if (studentRepository.existsBySchoolNumber(schoolNumber)) {
            log.error(schoolNumber + " numaralı öğrenci zaten mecvut!");
            throw new AlreadyAvailableException(schoolNumber + "numaralı öğrenci zaten mecvut!");
        }

        Student student = new Student();
        student.setFirstName(studentCreateRequest.getFirstName().toUpperCase());
        student.setLastName(studentCreateRequest.getLastName().toUpperCase());
        student.setSchoolNumber(RegexUtils.schoolNumberRegex(studentCreateRequest.getSchoolNumber()));
        student.setIdentityNumber(RegexUtils.schoolTcNo(studentCreateRequest.getIdentityNumber()));
        student.setActive(true);

        studentRepository.save(student);
        log.info(student.getIdentityNumber() + " numaralı öğrencinin kayıt işlemi tamamlandı.");

        StudentCreateResponse studentCreateResponse = new StudentCreateResponse();
        studentCreateResponse.setId(student.getId());
        studentCreateResponse.setFirstName(student.getFirstName());
        studentCreateResponse.setLastName(student.getLastName());
        studentCreateResponse.setIdentityNumber(student.getIdentityNumber());
        studentCreateResponse.setSchoolNumber(student.getSchoolNumber());
        studentCreateResponse.setActive(student.isActive());


        return studentCreateResponse;
    }

    @Override
    public StudentIdResponse getByStudentId(long studentId) {

        if (!studentRepository.existsById(studentId)){
            log.error(studentId + "id sahip öğrenci bulunamadı !");
            throw new NotAvailableException(studentId + "id sahip öğrenci bulunamadı !");
        }

        Student student =studentRepository.findById(studentId).get();

        StudentIdResponse studentIdResponse = new StudentIdResponse();
        studentIdResponse.setId(student.getId());
        studentIdResponse.setFirstName(student.getFirstName());
        studentIdResponse.setLastName(student.getLastName());
        studentIdResponse.setIdentityNumber(student.getIdentityNumber());
        studentIdResponse.setSchoolNumber(student.getSchoolNumber());
        studentIdResponse.setActive(student.isActive());

        return studentIdResponse;
    }
}
