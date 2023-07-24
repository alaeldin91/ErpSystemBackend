package com.alaeldin.erpschoolSystem;

import com.alaeldin.erpschoolSystem.classroom.dto.ClassRoomDto;
import com.alaeldin.erpschoolSystem.classroom.entity.ClassRoom;
import com.alaeldin.erpschoolSystem.classroom.mapper.ClassMapper;
import com.alaeldin.erpschoolSystem.classroom.serviceimpl.ClassRoomServiceImpl;
import com.alaeldin.erpschoolSystem.country.country.Service.CountryServiceImpl;
import com.alaeldin.erpschoolSystem.country.country.entity.Country;
import com.alaeldin.erpschoolSystem.country.town.entity.City;
import com.alaeldin.erpschoolSystem.country.town.service.impl.TownServiceImpl;
import com.alaeldin.erpschoolSystem.gender.dto.GenderDto;
import com.alaeldin.erpschoolSystem.gender.entity.Gender;
import com.alaeldin.erpschoolSystem.gender.mapper.GenderMapper;
import com.alaeldin.erpschoolSystem.gender.servicelmpl.GenderServiceImpl;
import com.alaeldin.erpschoolSystem.schoolgrade.dto.SchoolGradeDto;
import com.alaeldin.erpschoolSystem.schoolgrade.entity.SchoolGrade;
import com.alaeldin.erpschoolSystem.schoolgrade.mapper.MapperSchoolGrade;
import com.alaeldin.erpschoolSystem.schoolgrade.servieImpl.SchoolGradeServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.io.IOException;
import org.apache.logging.log4j.LogManager;
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

	@Bean
	CommandLineRunner runnerCountry(CountryServiceImpl countryServiceImpl){
		org.apache.logging.log4j.Logger logger = LogManager.getLogger(ErpschoolSystemApplication.class);
		return 	args-> {
			ObjectMapper objectMapper = new ObjectMapper();
			TypeReference<List<Country>> typeReference = new TypeReference<>() {};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/fixture/countries.json");
			try {
				List<Country> countries = objectMapper.readValue(inputStream, typeReference);
				countryServiceImpl.listCountryDao(countries);
				System.out.println("Countries Saved");


			} catch (java.io.IOException e) {
				System.out.println("Unable to save Countries: " + e.getMessage());
			}
		};
	}

	@Bean
	CommandLineRunner runnerGender(GenderServiceImpl genderService){
		org.apache.logging.log4j.Logger logger = LogManager.getLogger(ErpschoolSystemApplication.class);
		return args -> {
			ObjectMapper objectMapper = new ObjectMapper();
			TypeReference<List<Gender>> typeReference = new TypeReference<>() {};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/fixture/gender.json");
			try {
				List<Gender> genders = objectMapper.readValue(inputStream,typeReference);
				List<GenderDto> genderDto = genders.stream().map(gender -> GenderMapper.toGenderDto(gender)).toList();
				logger.info(genderDto);
				genderService.saveAll(genderDto);
				System.out.println("Gender Saved");

			}
			catch (IOException e){
				System.out.println("Unable to save Gender: " + e.getMessage());

			}
		};
	}
	@Bean
	CommandLineRunner runnerTown( TownServiceImpl townService){
		org.apache.logging.log4j.Logger logger = LogManager.getLogger(ErpschoolSystemApplication.class);

		return 	args-> {
			ObjectMapper objectMapper = new ObjectMapper();

			TypeReference<List<City>> typeReference = new TypeReference<>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/fixture/cities.json");
			try {
				List<City> cities =  objectMapper.readValue(inputStream, typeReference);
				logger.info(cities);
				townService.saveAllCities(cities);

				System.out.println("Cities Saved");

			} catch (java.io.IOException e) {
				System.out.println("Unable to save Cities: " + e.getMessage());
			}
		};
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
