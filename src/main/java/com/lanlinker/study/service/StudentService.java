package com.lanlinker.study.service;

import com.lanlinker.study.entity.Student;
import com.lanlinker.study.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MetalSteel on 2017/8/29.
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent(Integer id){
        studentRepository.delete(id);
    }
}
