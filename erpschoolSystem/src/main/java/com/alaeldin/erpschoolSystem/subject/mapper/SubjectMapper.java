package com.alaeldin.erpschoolSystem.subject.mapper;

import com.alaeldin.erpschoolSystem.subject.dto.SubjectDto;
import com.alaeldin.erpschoolSystem.subject.entity.Subject;

public class SubjectMapper {

    public static SubjectDto toSubjectDto(Subject subject){
        SubjectDto subjectDto = new SubjectDto(subject.getId(), subject.getSubjectId(), subject.getSubjectName());
        return subjectDto;
    }

    public static Subject toSubject(SubjectDto subjectDto){
        Subject subject = new Subject(subjectDto.getId(),subjectDto.getSubjectId(),subjectDto.getSubjectName());
        return  subject;
    }
}
