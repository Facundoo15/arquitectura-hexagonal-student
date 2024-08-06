package com.crymuzz.arquitecturahexsudent.infrastructure.adapter.output.persistence;

import com.crymuzz.arquitecturahexsudent.application.ports.output.StudentPersistencePort;
import com.crymuzz.arquitecturahexsudent.domain.model.Student;
import com.crymuzz.arquitecturahexsudent.infrastructure.adapter.output.persistence.mapper.StudentPersistenceMapper;
import com.crymuzz.arquitecturahexsudent.infrastructure.adapter.output.persistence.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements StudentPersistencePort {

    private final StudentRepository studentRepository;
    private final StudentPersistenceMapper mapper;

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id).map(mapper::toStudent);
    }

    @Override
    public List<Student> findAll() {
        return mapper.toStudents(studentRepository.findAll());
    }

    @Override
    public Student save(Student student) {
        return mapper.toStudent(studentRepository.save(mapper.toStudentEntity(student)));
    }

    @Override
    public Student update(Student student) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
