package com.Project_practice.demo_Practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project_practice.demo_Practice.Exceptions.UserNotFoundException;
import com.Project_practice.demo_Practice.dto.ProfileRequest;
import com.Project_practice.demo_Practice.dto.ProfileResponce;
import com.Project_practice.demo_Practice.model.Student;
import com.Project_practice.demo_Practice.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student updateAllDetailStudent(int id, Student student) {

        Student exists = studentRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Student not found with id: " + id));

        exists.setName(student.getName());
        exists.setEmail(student.getEmail());
        exists.setRollno(student.getRollno());
        exists.setGender(student.getGender());
        exists.setCourse(student.getCourse());
        exists.setAge(student.getAge());
        exists.setEnroll(student.isEnroll());

        return studentRepository.save(exists);
    }

    public Student UpdateStudentEmail(long id,String email,String age) throws Exception  {
        Student existingStudent=studentRepository.findById((int)id)
            .orElseThrow(() -> new Exception("Student id not exists" + id));
        existingStudent.setEmail(email);
        existingStudent.setAge(Integer.parseInt(age));
        
        return studentRepository.save(existingStudent);
       
            
        
    }

    
    // dto means data transfer object to show only selected data hide senstive data
    
    public ProfileResponce getProfile(Integer id){
        Student student=studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student profile not find"));
        return new ProfileResponce(student.getId(),student.getName(),student.getGender(),student.getRollno());
    }


    // //Validation
    // public ProfileRequest addPrfile(Integer id){
    //     Student student=studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Profile not valid"));
        
    // }
}

