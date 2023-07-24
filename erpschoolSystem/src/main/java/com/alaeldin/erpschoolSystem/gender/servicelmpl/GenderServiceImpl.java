package com.alaeldin.erpschoolSystem.gender.servicelmpl;

import com.alaeldin.erpschoolSystem.exception.resourcenotfound.ResourceNotFoundException;
import com.alaeldin.erpschoolSystem.gender.dto.GenderDto;
import com.alaeldin.erpschoolSystem.gender.entity.Gender;
import com.alaeldin.erpschoolSystem.gender.mapper.GenderMapper;
import com.alaeldin.erpschoolSystem.gender.repsitory.GenderRepository;
import com.alaeldin.erpschoolSystem.gender.service.GenderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GenderServiceImpl implements GenderService {
    private  GenderRepository genderRepository;
    @Override
    public Iterable<GenderDto> saveAll(List<GenderDto> genderDto) {
        List<Gender> genderList = genderDto.stream().map(GenderMapper::toGender).toList();
        List<Gender> saveGenderList = genderRepository.saveAll(genderList);
        return saveGenderList.stream().map(GenderMapper::toGenderDto).toList();
    }

    @Override
    public Page<GenderDto> getAllGender(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<Gender> genderPage = genderRepository.findAll(pageable);
        return genderPage.map(GenderMapper::toGenderDto);
    }

    @Override
    public GenderDto getGenderById(long id) {
        Gender gender = genderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Gender","id",(int)id));
        return GenderMapper.toGenderDto(gender);
    }

    @Override
    public GenderDto getGenderByName(String name) {
        Gender gender = genderRepository.findByName(name).orElseThrow();
        return GenderMapper.toGenderDto(gender);
    }

    @Override
    public GenderDto updateGender(GenderDto genderDto) {
        Gender existGender = genderRepository.findById(genderDto.getId())
                .orElseThrow(()->new ResourceNotFoundException("Gender","id",(int)genderDto.getId()));
        existGender.setId(genderDto.getId());
        existGender.setName(genderDto.getName());
        existGender.setName2(genderDto.getName2());
        GenderDto genderSaveDto = GenderMapper.toGenderDto(existGender);
        return genderSaveDto;
    }

    @Override
    public void deleteGender(long id) {
      Gender existGender = genderRepository.findById(id).orElseThrow(()
              ->new ResourceNotFoundException("Gender","id",(int)id));
      genderRepository.delete(existGender);
    }
}
