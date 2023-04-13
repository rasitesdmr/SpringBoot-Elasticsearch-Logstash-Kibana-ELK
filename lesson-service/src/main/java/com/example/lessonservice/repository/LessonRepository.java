package com.example.lessonservice.repository;

import com.example.lessonservice.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Long> {

    boolean existsByCode(String code);

    boolean existsById(long lessonId);
}
