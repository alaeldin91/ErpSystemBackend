package com.alaeldin.erpschoolSystem.schoolgrade.servieImpl;

import com.alaeldin.erpschoolSystem.exception.resourcenotfound.ResourceNotFoundException;
import com.alaeldin.erpschoolSystem.schoolgrade.dto.SchoolGradeDto;
import com.alaeldin.erpschoolSystem.schoolgrade.entity.SchoolGrade;
import com.alaeldin.erpschoolSystem.schoolgrade.mapper.MapperSchoolGrade;
import com.alaeldin.erpschoolSystem.schoolgrade.repository.SchoolGradeRepository;
import com.alaeldin.erpschoolSystem.schoolgrade.service.SchoolGradeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SchoolGradeServiceImpl implements SchoolGradeService {
    private SchoolGradeRepository schoolGradeRepository;
    @Override
    public Page<SchoolGradeDto> getAllSchoolGradeService(int pageNumber,int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);

        Page<SchoolGrade> schoolGradeList = schoolGradeRepository.findAll(pageable);

        return schoolGradeList.map(MapperSchoolGrade::toSchoolGradeDto);
    }

    @Override
    public Iterable<SchoolGradeDto> saveAllGradeService(List<SchoolGradeDto> schoolGradeDtoList) {
        List<SchoolGrade>schoolGradeList = schoolGradeDtoList.stream().map(MapperSchoolGrade::toSchoolGrade).toList();
        List<SchoolGrade> saveSchoolGrade = schoolGradeRepository.saveAll(schoolGradeList);
        return saveSchoolGrade.stream().map(MapperSchoolGrade::toSchoolGradeDto).toList();
    }

    @Override
    public SchoolGradeDto updateGradeService(SchoolGradeDto schoolGradeDto) {
        SchoolGrade existschoolGrade = schoolGradeRepository.findById(schoolGradeDto.getId()).orElseThrow(()->
                new ResourceNotFoundException("schoolGrade","id",(int)schoolGradeDto.getId()));
        existschoolGrade.setId(schoolGradeDto.getId());
        existschoolGrade.setName(schoolGradeDto.getName());
        SchoolGrade saveSchoolGrade = schoolGradeRepository.save(existschoolGrade);
        return MapperSchoolGrade.toSchoolGradeDto(saveSchoolGrade);
    }

    @Override
    public void deleteSchoolGardeService(long id) {
     SchoolGrade existSchoolGrade = schoolGradeRepository.findById(id).orElseThrow(()
             ->new ResourceNotFoundException("SchoolGrade","id",(int)id));
        schoolGradeRepository.delete(existSchoolGrade);
    }

    @Override
    public SchoolGradeDto getSchoolGradeByName(String name) {
        SchoolGrade schoolGrade = schoolGradeRepository.findByName(name).orElseThrow();
        return MapperSchoolGrade.toSchoolGradeDto(schoolGrade);
    }

    @Override
    public SchoolGradeDto getSchoolGardeById(long id) {
        SchoolGrade schoolGrade = schoolGradeRepository.findById(id).orElseThrow(()
                ->new ResourceNotFoundException("School Grade","id",(int)id));
        return MapperSchoolGrade.toSchoolGradeDto(schoolGrade);
    }
}
