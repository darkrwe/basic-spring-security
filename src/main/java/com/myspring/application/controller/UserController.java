package com.myspring.application.controller;


import com.myspring.application.model.UserEntity;
import com.myspring.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@PreAuthorize("has_role('ROLE_USER')")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAllEntityItems() {

        List<UserEntity> userEntities = userService.getAll();

        if (userEntities.isEmpty()) {
            return new ResponseEntity("Not Found any user entity Item.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(userEntities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getEntityItemById(@PathVariable("id") int id) {

        UserEntity userEntity = userService.getById(id);

        if (userEntity == null) {
            return new ResponseEntity("Not Found user entity Item.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(userEntity, HttpStatus.OK);
    }


    @PostMapping("/")
    public ResponseEntity<UserEntity> insertEntity(@RequestBody UserEntity defaultEntity) {

        if (defaultEntity != null) {
            UserEntity insertedUserEntity = userService.saveEntityItem(defaultEntity);
            return new ResponseEntity(insertedUserEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity("Invalid user entity item.", HttpStatus.BAD_REQUEST);
        }

    }

}
