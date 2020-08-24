package com.myspring.application.service;

import com.myspring.application.model.UserEntity;
import com.myspring.application.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService() {
    }

    public List<UserEntity> getAll() {
        try {
            List<UserEntity> entities = new ArrayList();
            Iterator<UserEntity> iterator = userRepository.findAll().iterator();
            while( iterator.hasNext()) {
                entities.add(iterator.next());
            }
            return entities;
        } catch (Exception ex) {
            logger.error("Exception occurred while getting default item by id from database. " + ex.getMessage());
            return null;
        }
    }

    public UserEntity getById(long id) {
        try {
            return userRepository.findById(id).get();
        } catch (Exception ex) {
            logger.error("Exception occurred while getting default item by id from database. " + ex.getMessage());
            return null;
        }
    }

    public UserEntity saveEntityItem(UserEntity defaultEntity) {
        try {
            return userRepository.save(defaultEntity);
        } catch (Exception ex) {
            logger.error("Exception occurred while saving default item to database. " + ex.getMessage());
            return null;
        }
    }

    public Page<UserEntity> getByNamePaginated(String name, Pageable pageable){
        return userRepository.findAllByNameContains(name, pageable);
    }

}
