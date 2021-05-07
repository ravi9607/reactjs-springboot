package com.example.curebackend.Service;

import com.example.curebackend.Repo.MyRepo;
import com.example.curebackend.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyServices {

    @Autowired
    private MyRepo myRepo;

    public List<Course> getCourse(){
        return myRepo.findAll();
    }
    public Course addUser(Course course)  {
        myRepo.save(course);
        return course;
    }
    public Course getCourseById(long id){
        Course u = null;
        try {
            u= myRepo.findById(id).get();   // "getOne(id)" NOT WORK  use  "findById(id).get()"
        }catch (Exception e){
            e.printStackTrace();
        }
        return u;
    }
    public Course updateCourse(Course course){
        myRepo.save(course);
        return course;
    }

    public void deleteById(long id) {
        Course course = myRepo.findById(id).get();
        myRepo.delete(course);
    }

    public List<Course> getCourseByTitle(String title){
        return myRepo.findAllByTitle(title);
    }
}
