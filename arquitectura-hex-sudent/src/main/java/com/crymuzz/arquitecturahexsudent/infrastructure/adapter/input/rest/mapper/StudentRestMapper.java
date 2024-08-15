package com.crymuzz.arquitecturahexsudent.infrastructure.adapter.input.rest.mapper;

import com.crymuzz.arquitecturahexsudent.domain.model.Student;
import com.crymuzz.arquitecturahexsudent.infrastructure.adapter.input.rest.model.request.StudentCreateRequest;
import com.crymuzz.arquitecturahexsudent.infrastructure.adapter.input.rest.model.response.StudentResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentRestMapper {

    StudentRestMapper INSTANCE = Mappers.getMapper(StudentRestMapper.class);

    Student toStudent(StudentCreateRequest request);

    StudentResponse toStudentResponse(Student student);


    List<StudentResponse> toStudentResponseList(List<Student> students);

}
