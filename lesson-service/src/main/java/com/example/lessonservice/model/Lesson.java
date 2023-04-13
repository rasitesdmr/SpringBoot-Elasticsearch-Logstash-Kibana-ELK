package com.example.lessonservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(generator = "random_id_generator")
    @GenericGenerator(name = "random_id_generator", strategy = "com.example.lessonservice.util.RandomIdGenerator")
    private Long id;

    private String name;

    private String code;

    private boolean active;

}
