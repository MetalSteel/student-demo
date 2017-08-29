package com.lanlinker.study.rest;

import com.lanlinker.study.entity.Msg;
import com.lanlinker.study.entity.Student;
import com.lanlinker.study.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by MetalSteel on 2017/8/29.
 */
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/getAllStudents")
    public List<Student> findAllStudents(){
        return studentService.findAllStudents();
    }

    @PostMapping("/addStudent")
    public Msg addStudent(@Valid Student student, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new Msg(500,bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        Student stuTmp = studentService.addStudent(student);
        if(stuTmp!=null){
            return new Msg(200,"学生添加成功");
        }
        return new Msg(500,"学生信息添加失败");
    }

    @DeleteMapping("/deleteStudent/{id}")
    public Msg deleteStudent(@PathVariable("id") Integer id){
        studentService.deleteStudent(id);
        return new Msg(200,"删除成功");
    }
}
