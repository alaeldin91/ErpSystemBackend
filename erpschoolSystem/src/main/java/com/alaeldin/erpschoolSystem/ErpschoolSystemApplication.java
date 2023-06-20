package com.alaeldin.erpschoolSystem;

import com.alaeldin.erpschoolSystem.classroom.dto.ClassRoomDto;
import com.alaeldin.erpschoolSystem.classroom.entity.ClassRoom;
import com.alaeldin.erpschoolSystem.classroom.mapper.ClassMapper;
import com.alaeldin.erpschoolSystem.classroom.serviceimpl.ClassRoomServiceImpl;
import com.alaeldin.erpschoolSystem.schoolgrade.dto.SchoolGradeDto;
import com.alaeldin.erpschoolSystem.schoolgrade.entity.SchoolGrade;
import com.alaeldin.erpschoolSystem.schoolgrade.mapper.MapperSchoolGrade;
import com.alaeldin.erpschoolSystem.schoolgrade.servieImpl.SchoolGradeServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication

public class ErpschoolSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpschoolSystemApplication.class, args);
	}


	/**Runner Class Room **/

	@Bean
	CommandLineRunner runnerClassRoom(ClassRoomServiceImpl classRoomServiceImpl){
		Logger LOGGER = LoggerFactory.getLogger(ErpschoolSystemApplication.class);
		return args -> {
			ObjectMapper objectMapper = new ObjectMapper();
			TypeReference<List<ClassRoom>> typeReference = new TypeReference<>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/fixture/classRoomSchool.json");

			try{
				List<ClassRoom> classRoomList = objectMapper.readValue(inputStream,typeReference);
				List<ClassRoomDto> classRoomDtoList  = classRoomList.stream().map(ClassMapper::toClassRoomDto).toList();
				LOGGER.info("THIS IS CLASS rOOM "+"  "+classRoomDtoList);
				classRoomServiceImpl.SaveAllClassRoom(classRoomDtoList);
			}
			catch(IOException e){
				System.out.println("Unable to save Class Room: " + e.getMessage());
			}
		};
	}

	@Bean
	CommandLineRunner runnerSchoolGrade(SchoolGradeServiceImpl schoolGradeService){
		Logger LOGGER = LoggerFactory.getLogger(ErpschoolSystemApplication.class);
		return args -> {
		ObjectMapper objectMapper = new ObjectMapper();
		TypeReference<List<SchoolGrade>> typeReference = new TypeReference<>() {};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/fixture/schoolGrade.json");
		try{
              List<SchoolGrade>schoolGradeList = objectMapper.readValue(inputStream,typeReference);
			  List<SchoolGradeDto> schoolGradeDtoList = schoolGradeList.stream()
					  .map(MapperSchoolGrade::toSchoolGradeDto).toList();
			LOGGER.info("THIS IS CLASS rOOM "+"  "+schoolGradeDtoList);
			schoolGradeService.saveAllGradeService(schoolGradeDtoList);

		}
		catch (IOException e){
			System.out.println("Unable to save Class Room: " + e.getMessage());
		}
		};

	}
}
