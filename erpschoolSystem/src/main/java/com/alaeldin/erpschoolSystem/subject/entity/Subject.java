package com.alaeldin.erpschoolSystem.subject.entity;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "subject_id",nullable = false)
    private int subjectId;
    @Column(name = "name",nullable = false)
    private String subjectName;
}
