package com.Project_practice.demo_Practice.controler;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Project_practice.demo_Practice.Exceptions.UserNotFoundException;
import com.Project_practice.demo_Practice.dto.ProfileResponce;
import com.Project_practice.demo_Practice.model.Student;
import com.Project_practice.demo_Practice.repository.StudentRepository;
import com.Project_practice.demo_Practice.service.StudentService;



@RestController
@RequestMapping("/api/student")
public class StudentControler {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public Student studentregester(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deletallStudents(@PathVariable Integer id) {

        if (!studentRepository.existsById(id)) {
            return "Student with id " + id + " does not exist.";
        }

        studentRepository.deleteById(id);
        return "Student with id " + id + " deleted successfully.";
    }

    //Delete with name

     @DeleteMapping("/deleteName/{name}")
     public String deleteByName(@PathVariable String name){
        Student student=studentRepository.findByName(name).orElseThrow(()-> new UserNotFoundException("Student with name " + name + " not found"));
     
       studentRepository.delete(student);
       return  "name of studentd is  deleted";
     }

    @GetMapping("/get/{gender}")
    public ResponseEntity<List<Student>> getFemaleStudents(@PathVariable String gender) {
        return ResponseEntity.ok(studentRepository.findByGender(gender));
    }

    @GetMapping("/getenrollStudents/{enroll}")
    public List<Student> getEnrollStudent(@PathVariable boolean enroll) {
        return studentRepository.findByEnroll(enroll);
    }

    @GetMapping("/getName/{name}")
    public boolean getStudentName(@PathVariable String name) {
        return studentRepository.existsByName(name);
    }

    @GetMapping("/findName")
    public Optional<Student> findName(@RequestParam String name) {
        return studentRepository.findByName(name);
    }

    @GetMapping("/postrollno/{rollno}")
    public boolean posrollno(@PathVariable String rollno) {
        return studentRepository.existsByRollno(rollno);
    }

    @GetMapping("/findrollno")
    public Student findRollnoStudent(@RequestParam String rollno) {
        return studentRepository.findByRollno(rollno);
    }

    @PostMapping("/postMail")
    public ResponseEntity<?> postMail(@RequestBody Student student) {

        if (studentRepository.existsByEmail(student.getEmail())) {
            return ResponseEntity.badRequest().body("Email already exists");
        }

        return ResponseEntity.ok(studentRepository.save(student));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateAll(@PathVariable int id, @RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateAllDetailStudent(id, student));
    }

    @PatchMapping("/updatebyEmail/{id}")
    public ResponseEntity<Student> UpdateStudentEmail(@PathVariable long id,@RequestBody Map<String,String> emailMap) throws Exception{
        String email=emailMap.get("email");
        String age=emailMap.get("age");
        return ResponseEntity.ok(studentService.UpdateStudentEmail(id,email,age));
    }


    //dto 
    @GetMapping("Profile/{id}")
    public ProfileResponce getProfile(@PathVariable Integer id) {
        return studentService.getProfile(id);
    }

    //Validation

    
    
}
