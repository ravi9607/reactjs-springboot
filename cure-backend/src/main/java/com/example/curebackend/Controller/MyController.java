package com.example.curebackend.Controller;

import com.example.curebackend.Service.MyServices;
import com.example.curebackend.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MyController {

    @Autowired
    private MyServices myServices;

    @GetMapping("/course")
    public List<Course> getAllCourse(){
        return this.myServices.getCourse();
    }
    @PostMapping("/course")
    public Course addCourses(@RequestBody Course course){
        return this.myServices.addUser(course);
    }
    @GetMapping("/course/id/{id}")
    public Course getCourseById(@PathVariable("id") long id){
        return myServices.getCourseById(id);
    }
    @PutMapping("/course")
    public  Course updateCourse(@RequestBody Course course){
        return myServices.updateCourse(course);
    }
    @DeleteMapping("/course/{id}")
    public ResponseEntity<?> deletCourse(@PathVariable String id){

        try{
            this.myServices.deleteById(Long.parseLong(id));
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/course/title/{title}")
    public List<Course> findbyTitle(@PathVariable("title") String title){
        return myServices.getCourseByTitle(title);
    }
}
