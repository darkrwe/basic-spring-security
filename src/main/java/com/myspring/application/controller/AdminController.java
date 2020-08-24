package com.myspring.application.controller;

import com.myspring.application.model.AdminEntity;
import com.myspring.application.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author emininal
 * @since 24.08.2020
 */

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("has_role('ROLE_ADMIN')")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public ResponseEntity<List<AdminEntity>> getAllEntityItems() {

        List<AdminEntity> adminEntities = adminService.getAll();

        if (adminEntities.isEmpty()) {
            return new ResponseEntity("Not Found any admin entity.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(adminEntities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminEntity> getEntityItemById(@PathVariable("id") int id) {

        AdminEntity adminEntity = adminService.getById(id);

        if (adminEntity == null) {
            return new ResponseEntity("Not Found admin entity Item.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(adminEntity, HttpStatus.OK);
    }


    @PostMapping("/")
    public ResponseEntity<AdminEntity> insertEntity(@Valid @RequestBody AdminEntity adminEntity) {

        if (adminEntity != null) {
            AdminEntity insertedAdminEntity = adminService.saveEntityItem(adminEntity);
            return new ResponseEntity(insertedAdminEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity("Invalid admin entity.", HttpStatus.BAD_REQUEST);
        }

    }

}
