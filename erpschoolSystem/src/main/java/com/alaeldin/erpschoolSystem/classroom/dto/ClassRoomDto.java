package com.alaeldin.erpschoolSystem.classroom.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoomDto {
    private long id;
    @NotEmpty(message = "please Enter Class Name")
    private String name;
    @NotEmpty(message = "please Enter Class Id")
    private String classId;

}
