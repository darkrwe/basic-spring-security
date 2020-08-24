package com.myspring.application.repository;

import com.myspring.application.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Page<UserEntity> findAllByNameContains(String name, Pageable pageable);
}
