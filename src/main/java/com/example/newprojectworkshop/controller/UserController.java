package com.example.newprojectworkshop.controller;

import com.example.newprojectworkshop.dto.ResponseDTO;
import com.example.newprojectworkshop.dto.UserDTO;
import com.example.newprojectworkshop.model.User;
import com.example.newprojectworkshop.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")

public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addUser(@Valid @RequestBody UserDTO userDTO) {
        User user = userService.addUser(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data added Successfully", user);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);


    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateUser(@PathVariable long id, @Valid @RequestBody UserDTO userDTO) {

        User user = userService.updateUser(id, userDTO);

        ResponseDTO responseDTO = new ResponseDTO("Data updated Successfully", user);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        ResponseDTO responseDTO = new ResponseDTO("Data deleted successfully", null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @DeleteMapping("/delete/all")
    public ResponseEntity<ResponseDTO> deleteAllUser() {
        userService.deleteAllUser();
        ResponseDTO responseDTO = new ResponseDTO("All data deleted successfully", null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getUserById(@PathVariable long id) {
        User user = userService.getUserById(id);
        ResponseDTO responseDTO;
        HttpStatus status;
        if (user != null) {
            responseDTO = new ResponseDTO("User found", user);
            status = HttpStatus.OK;
        } else {
            responseDTO = new ResponseDTO("User not found", null);
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(responseDTO, status);
    }


    @GetMapping("/all")
    public ResponseEntity<ResponseDTO> getAllUser() {
        List<User> user = userService.getAllUser();
        ResponseDTO responseDTO;
        HttpStatus status;
        if (!user.isEmpty()) {
            responseDTO = new ResponseDTO("Employees found", user);
            status = HttpStatus.OK;
        } else {
            responseDTO = new ResponseDTO("No employees found", null);
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(responseDTO, status);
    }
}







