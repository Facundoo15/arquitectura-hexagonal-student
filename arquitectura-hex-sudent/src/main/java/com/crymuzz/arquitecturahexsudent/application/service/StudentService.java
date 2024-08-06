package com.crymuzz.arquitecturahexsudent.application.service;

import com.crymuzz.arquitecturahexsudent.application.ports.input.StudentServicePort;
import com.crymuzz.arquitecturahexsudent.application.ports.output.StudentPersistencePort;
import com.crymuzz.arquitecturahexsudent.domain.exception.StudentNotFoundException;
import com.crymuzz.arquitecturahexsudent.domain.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Component
public class StudentService implements StudentServicePort {

    private final StudentPersistencePort persistencePort;

    @Override
    public Student findById(Long id) {
        return persistencePort.findById(id).orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public List<Student> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public Student save(Student student) {
        return persistencePort.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        return persistencePort.findById(id).map(persistencePort::save).orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        persistencePort.findById(id)
                .ifPresentOrElse(
                        student -> persistencePort.deleteById(id),
                        () -> {
                            throw new StudentNotFoundException();
                        }
                );
    }
}
