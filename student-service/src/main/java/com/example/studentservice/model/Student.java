package com.example.studentservice.model;

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
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(generator = "random_id_generator")
    @GenericGenerator(name = "random_id_generator", strategy = "com.example.studentservice.util.RandomIdGenerator")
    private Long id;

    private String firstName;

    private String lastName;

    private String schoolNumber;

    private String identityNumber;

    private boolean active;



}
