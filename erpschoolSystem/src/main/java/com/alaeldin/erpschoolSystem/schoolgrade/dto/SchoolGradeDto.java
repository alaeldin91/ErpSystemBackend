package com.alaeldin.erpschoolSystem.schoolgrade.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class SchoolGradeDto {
    private long id;
    @NotEmpty(message = "please Enter SchoolGrade")
    private String name;
}
