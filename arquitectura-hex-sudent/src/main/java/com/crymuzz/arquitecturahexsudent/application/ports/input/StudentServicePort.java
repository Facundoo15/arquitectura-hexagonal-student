package com.crymuzz.arquitecturahexsudent.application.ports.input;

import com.crymuzz.arquitecturahexsudent.domain.model.Student;

import java.util.List;

public interface StudentServicePort {

    Student findById(Long id);

    List<Student> findAll();

    Student save(Student student);

    Student update(Long id, Student student);

    void deleteById(Long id);

}