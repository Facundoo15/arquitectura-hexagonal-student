package com.crymuzz.arquitecturahexsudent.application.ports.output;

import com.crymuzz.arquitecturahexsudent.domain.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentPersistencePort {
    Optional<Student> findById(Long id);
    List<Student> findAll();
    Student save(Student student);
    Student update(Student student);
    void deleteById(Long id);
}
