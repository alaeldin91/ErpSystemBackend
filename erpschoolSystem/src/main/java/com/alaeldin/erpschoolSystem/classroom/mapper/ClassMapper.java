package com.alaeldin.erpschoolSystem.classroom.mapper;

import com.alaeldin.erpschoolSystem.classroom.dto.ClassRoomDto;
import com.alaeldin.erpschoolSystem.classroom.entity.ClassRoom;

public class ClassMapper {
    /** function convert classRoomDto To classRoom **/
    public static ClassRoom toClassRoom(ClassRoomDto classRoomDto){
        ClassRoom classRoom = new ClassRoom();
        classRoom.setId(classRoomDto.getId());
                classRoom.setName(classRoomDto.getName());
        classRoom.setClassId(classRoomDto.getClassId());
    return classRoom;
    }

    /**function convert classRoom To classRoomDto **/

    public static ClassRoomDto toClassRoomDto(ClassRoom classRoom){

        ClassRoomDto classRoomDto = new ClassRoomDto(classRoom.getId()
                ,classRoom.getName()
                ,classRoom.getClassId());
        return classRoomDto;

    }
}
