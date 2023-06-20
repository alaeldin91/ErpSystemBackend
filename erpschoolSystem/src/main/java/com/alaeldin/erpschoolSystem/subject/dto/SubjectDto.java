package com.alaeldin.erpschoolSystem.subject.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDto {

    private long id;
    @NotEmpty(message = "please Enter Subject Id")
    private int subjectId;
    @NotEmpty(message = "please Enter Subject Name")
    private String subjectName;
}
