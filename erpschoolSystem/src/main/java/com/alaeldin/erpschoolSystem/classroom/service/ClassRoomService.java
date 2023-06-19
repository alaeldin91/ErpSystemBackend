package com.alaeldin.erpschoolSystem.classroom.service;

import com.alaeldin.erpschoolSystem.classroom.dto.ClassRoomDto;

import java.util.List;

public interface ClassRoomService {
    /**SaveAll Class Room   **/

    Iterable<ClassRoomDto> SaveAllClassRoom(List<ClassRoomDto> listClassRoomDto);
   /** get All Class Room **/
  List<ClassRoomDto> getClassRoom();

  /** get Class Room By Name **/
  ClassRoomDto getClassRoomByName(String NameClassRoom);

  /**get Class Room By Id **/

  ClassRoomDto getClassById(long classRoomId);

  /** Update ClassRoom **/
   ClassRoomDto updateClassRoom(ClassRoomDto classRoomDto);

   /**Delete Class Room By Id **/
 void deleteClassRoom(long id);
}
