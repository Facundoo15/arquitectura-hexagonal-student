package com.crymuzz.arquitecturahexsudent.infrastructure.adapter.input.rest.adapter;

import com.crymuzz.arquitecturahexsudent.application.ports.input.StudentServicePort;
import com.crymuzz.arquitecturahexsudent.domain.model.Student;
import com.crymuzz.arquitecturahexsudent.infrastructure.adapter.input.rest.mapper.StudentRestMapper;
import com.crymuzz.arquitecturahexsudent.infrastructure.adapter.input.rest.model.request.StudentCreateRequest;
import com.crymuzz.arquitecturahexsudent.infrastructure.adapter.input.rest.model.response.StudentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentRestAdapter {

    private final StudentServicePort studentService;

    @GetMapping("/v1/api")
    public List<StudentResponse> findAll() {
        return StudentRestMapper.INSTANCE.toStudentResponseList(studentService.findAll());
    }
    @GetMapping("/v1/api/{id}")
    public StudentResponse findAll(@PathVariable Long id) {
        return StudentRestMapper.INSTANCE.toStudentResponse(studentService.findById(id));
    }

    @PostMapping("v1/api")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse save(@Valid @RequestBody StudentCreateRequest student) {
        System.out.println(student.toString());
        System.out.println(StudentRestMapper.INSTANCE.toStudent(student));
        Student studentMap = StudentRestMapper.INSTANCE.toStudent(student);
        System.out.println(StudentRestMapper.INSTANCE.toStudentResponse(studentMap));
        System.out.println(studentService.save(StudentRestMapper.INSTANCE.toStudent(student)));
        //---
        System.out.println(StudentRestMapper.INSTANCE.toStudentResponse(studentService.save(StudentRestMapper.INSTANCE.toStudent(student))));
        return StudentRestMapper.INSTANCE.toStudentResponse(studentService.save(StudentRestMapper.INSTANCE.toStudent(student)));
    }

    @PutMapping("/v1/api/{id}")
    public StudentResponse update(@PathVariable Long id, @Valid @RequestBody StudentCreateRequest student) {
        return StudentRestMapper.INSTANCE.toStudentResponse(studentService.update(id, StudentRestMapper.INSTANCE.toStudent(student)));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        studentService.deleteById(id);
    }


}
