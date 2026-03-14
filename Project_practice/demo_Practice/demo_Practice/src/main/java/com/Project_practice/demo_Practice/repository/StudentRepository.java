package com.Project_practice.demo_Practice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project_practice.demo_Practice.model.Student;
import java.util.List;
import java.util.Optional;



@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    void deleteById(Integer id);

    boolean existsById(Integer id);

    List<Student> findByGender(String gender);

    

    List<Student> findByEnroll(boolean enroll );
    
   

    boolean existsByName( String name);

    Optional<Student> findByName(String name);
    //delete with name
    //void deleteByName(Student student);

    boolean existsByRollno(String rollno);
    Student findByRollno(String rollno);
    
    boolean existsByEmail(String email);

   
}
