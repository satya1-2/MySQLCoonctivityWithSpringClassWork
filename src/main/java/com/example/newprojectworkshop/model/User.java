package com.example.newprojectworkshop.model;

import com.example.newprojectworkshop.dto.UserDTO;
import jakarta.persistence.*;

import java.lang.annotation.Repeatable;
import java.time.LocalDate;

@Entity
@Table(name = "newProjectWorkshop")
public  class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String title;
    private String description;

    private LocalDate dueDate;
    private boolean completed;

    public User() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public User(UserDTO userDTO) {

        this.title = userDTO.title;
        this.description = userDTO.description;
        this.dueDate = userDTO.dueDate;

    }

//    public  User(UserDTO userDTO){
//        this.updateUser(userDTO);
//    }
//    public void updateUser(UserDTO userDTO) {
//        this.id = id;
//        this.title =userDTO.getTitle() ;
//        this.description = userDTO.getDescription();
//        this.dueDate = userDTO.getDueDate();
//        this.completed = userDTO.getCompleted();
//
//    }
}