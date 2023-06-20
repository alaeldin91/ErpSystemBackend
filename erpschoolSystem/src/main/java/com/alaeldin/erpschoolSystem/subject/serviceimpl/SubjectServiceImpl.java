package com.alaeldin.erpschoolSystem.subject.serviceimpl;

import com.alaeldin.erpschoolSystem.classroom.entity.ClassRoom;
import com.alaeldin.erpschoolSystem.exception.resourcenotfound.ResourceNotFoundException;
import com.alaeldin.erpschoolSystem.subject.dto.SubjectDto;
import com.alaeldin.erpschoolSystem.subject.entity.Subject;
import com.alaeldin.erpschoolSystem.subject.mapper.SubjectMapper;
import com.alaeldin.erpschoolSystem.subject.repository.RepositorySubject;
import com.alaeldin.erpschoolSystem.subject.service.SubjectService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private  RepositorySubject repositorySubject;


    @Override
    public SubjectDto saveSubjectDto(SubjectDto subjectDto) {
        Subject subject = SubjectMapper.toSubject(subjectDto);
        Subject saveSubject = repositorySubject.save(subject);
        SubjectDto saveSubjectDto = SubjectMapper.toSubjectDto(saveSubject);
        return saveSubjectDto;
    }

    @Override
    public List<SubjectDto> getAllSubject() {
        List<Subject> subjectList = repositorySubject.findAll();
        List<SubjectDto> subjectDtoList = subjectList.stream().map(SubjectMapper::toSubjectDto).toList();
        return subjectDtoList;
    }

    @Override
    public SubjectDto getSubjectById(long id) {
        Subject subject = repositorySubject
                .findById(id).orElseThrow(()->new ResourceNotFoundException("subject","id",(int)id));
        SubjectDto subjectDto = SubjectMapper.toSubjectDto(subject);
        return subjectDto;
    }

    @Override
    public SubjectDto getSubjectByName(String name) {
        Subject subjectByName = repositorySubject.findBySubjectName(name).orElseThrow();
        SubjectDto subjectDtoByName = SubjectMapper.toSubjectDto(subjectByName);
        return subjectDtoByName;
    }

    @Override
    public SubjectDto updateSubject(SubjectDto subjectDto) {
        Subject existSubject = repositorySubject.findById(subjectDto.getId())
                .orElseThrow(()-> new ResourceNotFoundException("Subject","subject",subjectDto.getSubjectId()));
          existSubject.setId(subjectDto.getId());
          existSubject.setSubjectId(subjectDto.getSubjectId());
          existSubject.setSubjectName(subjectDto.getSubjectName());
          Subject saveSubjectDto = repositorySubject.save(existSubject);

          return SubjectMapper.toSubjectDto(saveSubjectDto);
    }
    @Override
    public void deleteSubject(long id) {
        Subject existSubject = repositorySubject.findById(id).orElseThrow(()
                ->new ResourceNotFoundException("subject","id",(int)id));
            repositorySubject.delete(existSubject);
    }

    @Override
    public SubjectDto getSubjectBySubjectId(int subjectId) {
     Subject subject = repositorySubject.findBySubjectId(subjectId).orElseThrow(()->new ResourceNotFoundException(
             "subject","id",subjectId
     ));
     SubjectDto subjectDto = SubjectMapper.toSubjectDto(subject);

        return subjectDto;
    }
}
