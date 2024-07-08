package com.RestServices.RestServices.Controllers;

import com.RestServices.RestServices.ExceptionHandling.StudentErrorResponse;
import com.RestServices.RestServices.ExceptionHandling.StudentNotFoundException;
import com.RestServices.RestServices.Pojos.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> studentList;

    @PostConstruct
    public void initializeStudentS(){
        studentList=new ArrayList<>();
        studentList.add(new Student("Suvendu","Hatua","Kharagpur"));
        studentList.add(new Student("Akash","Samanta","Kolkata"));
        studentList.add(new Student("Sonali","Hatua","Medinipur"));
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentList;
    }

    @GetMapping("/students/{studentID}")
    public Student getStudentById(@PathVariable int studentID) throws StudentNotFoundException {
        if(studentID>=studentList.size()||studentID<0){
            throw new StudentNotFoundException("Student not Found! - "+studentID);
        }
        return studentList.get(studentID);
    }


}
