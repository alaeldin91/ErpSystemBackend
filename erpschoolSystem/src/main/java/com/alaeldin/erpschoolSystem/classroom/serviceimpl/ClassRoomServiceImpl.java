package com.alaeldin.erpschoolSystem.classroom.serviceimpl;

import com.alaeldin.erpschoolSystem.classroom.dto.ClassRoomDto;
import com.alaeldin.erpschoolSystem.classroom.entity.ClassRoom;
import com.alaeldin.erpschoolSystem.classroom.mapper.ClassMapper;
import com.alaeldin.erpschoolSystem.classroom.repository.ClassRoomRepository;
import com.alaeldin.erpschoolSystem.classroom.service.ClassRoomService;
import com.alaeldin.erpschoolSystem.exception.resourcenotfound.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service

public class ClassRoomServiceImpl implements ClassRoomService {
    private ClassRoomRepository classRoomRepository;
    @Override
    public Iterable<ClassRoomDto> SaveAllClassRoom(List<ClassRoomDto> listClassRoomDto) {
        List<ClassRoom> listClassRoom = listClassRoomDto.stream().map(classRoomDto ->
                ClassMapper.toClassRoom(classRoomDto)).toList();
        List<ClassRoom> saveListClassRoom = classRoomRepository.saveAll(listClassRoom);
        List<ClassRoomDto> saveListClassRoomDto = saveListClassRoom.stream().map(classRoom ->
                ClassMapper.toClassRoomDto(classRoom)).toList();
        return saveListClassRoomDto;
    }

    @Override
    public List<ClassRoomDto> getClassRoom() {
        List<ClassRoom> classRoomList = classRoomRepository.findAll();
        List<ClassRoomDto> classRoomDtoList = classRoomList.stream().map(classRoom -> ClassMapper.toClassRoomDto(classRoom)).toList();
        return classRoomDtoList;
    }

    @Override
    public ClassRoomDto getClassRoomByName(String nameClassRoom) {
        ClassRoom classRoom = classRoomRepository.findByName(nameClassRoom).orElseThrow();
        ClassRoomDto classRoomDto =  ClassMapper.toClassRoomDto(classRoom);
        return classRoomDto;
    }

    @Override
    public ClassRoomDto getClassById(long classRoomId) {
     ClassRoom classRoom = classRoomRepository.findById(classRoomId).orElseThrow(()
             ->new ResourceNotFoundException("classRoom","id", (int) classRoomId));
     ClassRoomDto classRoomDto = ClassMapper.toClassRoomDto(classRoom);
        return classRoomDto;
    }

    @Override
    public ClassRoomDto updateClassRoom(ClassRoomDto classRoomDto) {
        return null;
    }

    @Override
    public void deleteClassRoom(long id) {

    }
}
