package com.alaeldin.erpschoolSystem.classroom.serviceimpl;

import com.alaeldin.erpschoolSystem.classroom.dto.ClassRoomDto;
import com.alaeldin.erpschoolSystem.classroom.entity.ClassRoom;
import com.alaeldin.erpschoolSystem.classroom.mapper.ClassMapper;
import com.alaeldin.erpschoolSystem.classroom.repository.ClassRoomRepository;
import com.alaeldin.erpschoolSystem.classroom.service.ClassRoomService;
import com.alaeldin.erpschoolSystem.exception.resourcenotfound.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service

public class ClassRoomServiceImpl implements ClassRoomService {
    private ClassRoomRepository classRoomRepository;
    @Override
    public Iterable<ClassRoomDto> SaveAllClassRoom(List<ClassRoomDto> listClassRoomDto) {
        List<ClassRoom> listClassRoom = listClassRoomDto.stream().map(ClassMapper::toClassRoom).toList();
        List<ClassRoom> saveListClassRoom = classRoomRepository.saveAll(listClassRoom);
        return saveListClassRoom.stream().map(ClassMapper::toClassRoomDto).toList();
    }

    @Override
    public Page<ClassRoomDto> getClassRoom(int pageNumber,int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<ClassRoom> classRoomPage = classRoomRepository.findAll(pageable);
        Page<ClassRoomDto>classRoomDto = classRoomPage.map(classRoom -> ClassMapper.toClassRoomDto(classRoom));;
        return classRoomDto;
    }

    @Override
    public ClassRoomDto getClassRoomByName(String nameClassRoom) {
        ClassRoom classRoom = classRoomRepository.findByName(nameClassRoom).orElseThrow();
        return ClassMapper.toClassRoomDto(classRoom);
    }

    @Override
    public ClassRoomDto getClassById(long classRoomId) {
     ClassRoom classRoom = classRoomRepository.findById(classRoomId).orElseThrow(()
             ->new ResourceNotFoundException("classRoom","id", (int) classRoomId));
        return ClassMapper.toClassRoomDto(classRoom);
    }

    @Override
    public ClassRoomDto updateClassRoom(ClassRoomDto classRoomDto) {
        ClassRoom classRoomExist = classRoomRepository.findById(classRoomDto.getId()).orElseThrow(()
                ->new ResourceNotFoundException("classRoom","id",(int)classRoomDto.getId()));
             classRoomExist.setClassId(classRoomDto.getClassId());
             classRoomExist.setName(classRoomDto.getName());
             ClassRoom saveClassRoom = classRoomRepository.save(classRoomExist);
             return ClassMapper.toClassRoomDto(saveClassRoom);

    }

    @Override
    public void deleteClassRoom(long id) {
        ClassRoom classRoomExist = classRoomRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("School Grade","id",(int)id));
        classRoomRepository.delete(classRoomExist);
    }
}
