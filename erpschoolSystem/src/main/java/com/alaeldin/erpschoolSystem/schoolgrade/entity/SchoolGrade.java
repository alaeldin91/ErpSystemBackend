package com.alaeldin.erpschoolSystem.schoolgrade.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "school_grade")
public class SchoolGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
}
