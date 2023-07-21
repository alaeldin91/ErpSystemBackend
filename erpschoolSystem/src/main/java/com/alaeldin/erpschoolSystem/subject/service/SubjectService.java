package com.alaeldin.erpschoolSystem.subject.service;

import com.alaeldin.erpschoolSystem.subject.dto.SubjectDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SubjectService {
    SubjectDto saveSubjectDto(SubjectDto subjectDto);
    Page<SubjectDto> getAllSubject(int pageNumber,int pageSize);
    SubjectDto getSubjectById(long id);
    SubjectDto getSubjectByName(String name);
    SubjectDto updateSubject(SubjectDto subjectDto);
    void deleteSubject(long id);
    SubjectDto getSubjectBySubjectId(int subjectId);

}
