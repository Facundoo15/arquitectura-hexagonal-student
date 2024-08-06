package com.crymuzz.arquitecturahexsudent.infrastructure.adapter.output.persistence.mapper;

import com.crymuzz.arquitecturahexsudent.domain.model.Student;
import com.crymuzz.arquitecturahexsudent.infrastructure.adapter.output.persistence.entity.StudentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentPersistenceMapper {

    StudentEntity toStudentEntity(Student student);

    Student toStudent(StudentEntity studentEntity);

    List<Student> toStudents(List<StudentEntity> studentEntities);

}
