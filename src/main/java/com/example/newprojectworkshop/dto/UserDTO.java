package com.example.newprojectworkshop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class UserDTO {


    @Pattern(regexp = "^[A-Z]{1}[A-Za-z\\s]{2,}$", message = "User title invalid")
    public String title;

    @NotEmpty
    public String description;


    public LocalDate dueDate;


}


