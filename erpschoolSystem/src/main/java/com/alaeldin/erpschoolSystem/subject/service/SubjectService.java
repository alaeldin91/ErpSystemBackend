package com.alaeldin.erpschoolSystem.subject.service;

import com.alaeldin.erpschoolSystem.subject.dto.SubjectDto;

import java.util.List;

public interface SubjectService {
    SubjectDto saveSubjectDto(SubjectDto subjectDto);
    List<SubjectDto> getAllSubject();
    SubjectDto getSubjectById(long id);
    SubjectDto getSubjectByName(String name);
    SubjectDto updateSubject(SubjectDto subjectDto);
    void deleteSubject(long id);
    SubjectDto getSubjectBySubjectId(int subjectId);

}
