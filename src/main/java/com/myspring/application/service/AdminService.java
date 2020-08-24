package com.myspring.application.service;

import com.myspring.application.model.AdminEntity;
import com.myspring.application.repository.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author emininal
 * @since 24.08.2020
 */

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public AdminService() {
    }

    public List<AdminEntity> getAll() {
        try {
            List<AdminEntity> entities = new ArrayList();
            Iterator<AdminEntity> iterator = adminRepository.findAll().iterator();
            while( iterator.hasNext()) {
                entities.add(iterator.next());
            }
            return entities;
        } catch (Exception ex) {
            logger.error("Exception occurred while getting admin by id from database. " + ex.getMessage());
            return null;
        }
    }

    public AdminEntity getById(long id) {
        try {
            return adminRepository.findById(id).get();
        } catch (Exception ex) {
            logger.error("Exception occurred while getting admin by id from database. " + ex.getMessage());
            return null;
        }
    }

    public AdminEntity saveEntityItem(AdminEntity adminEntity) {
        try {
            return adminRepository.save(adminEntity);
        } catch (Exception ex) {
            logger.error("Exception occurred while saving default admin to database. " + ex.getMessage());
            return null;
        }
    }
}
