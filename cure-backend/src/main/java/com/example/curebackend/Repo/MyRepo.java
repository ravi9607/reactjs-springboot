package com.example.curebackend.Repo;

import com.example.curebackend.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyRepo extends JpaRepository<Course,Long> {
    List<Course> findAllByTitle(String title);
}
