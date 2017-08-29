package com.lanlinker.study.repository;

import com.lanlinker.study.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by MetalSteel on 2017/8/29.
 */
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
