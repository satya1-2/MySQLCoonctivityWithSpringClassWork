package com.example.newprojectworkshop.services;

import com.example.newprojectworkshop.dto.UserDTO;
import com.example.newprojectworkshop.exception.UserCustomException;
import com.example.newprojectworkshop.model.User;
import com.example.newprojectworkshop.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


    @Service
    public class UserService  {

        @Autowired
        private UserRepo userRepo;

        public User addUser(UserDTO userDTO) {
            User userData = new User(userDTO);
            return userRepo.save(userData);


        }


        public User updateUser(long id, UserDTO userDTO) {
            User userData = getUserById(id);
            if (userData == null) {
                throw new IllegalArgumentException("User not found with ID: " + id);
            }
            userData.setTitle(userDTO.title);
            userData.setDescription(userDTO.description);
            userData.setDueDate(userDTO.dueDate);
          //  userData.setCompleted(userDTO.getCompleted());
            return userRepo.save(userData);
        }

        public void deleteUser(long id) {
            User userData = getUserById(id);
            if (userData == null) {
                throw new IllegalArgumentException("User not found with ID: " + id);
            }

            userRepo.deleteById(id);
        }

        public void deleteAllUser() {

            userRepo.deleteAll();
        }

        public User getUserById(long id) {

            return userRepo.findById(id).orElseThrow(()->new UserCustomException("employee with id: "+id+"not present"));
        }


        public List<User> getAllUser() {

            return userRepo.findAll();
        }

    }


