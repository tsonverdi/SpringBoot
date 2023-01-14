package com.tpe.service;

import com.tpe.domain.Student;
import com.tpe.exception.ConflictException;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;//injection


    public List<Student> getAll() {
        return studentRepository.findAll();//otomatik implement edilen bir method reponun parentlardan.
    }

    public void createStudent(Student student) {
        if(studentRepository.existsByEmail(student.getEmail())){
            //boolean deger oldugu icin ifin icine aldik
            throw new ConflictException("Same email adress is already registered, please try with different email adress");
        }
        studentRepository.save(student);//entity aliyor.
    }

    public Student findStudent(Long id) {
       return studentRepository.findById(id).orElseThrow(()->//Eger id yoksa kismini dusunuyoruz. Exception kafasinda dusunmek onemli
                new ResourceNotFoundException("Student not found with id : " + id));
    }
}
