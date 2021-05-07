package com.example.curebackend.entities;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @Column(nullable = false)
    private long id;
    @Column(nullable = false,unique = true)
    private String title;
    @Column(nullable = false,unique = true)
    private String description;

    @Override
    public String toString() {
        return "courses{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
