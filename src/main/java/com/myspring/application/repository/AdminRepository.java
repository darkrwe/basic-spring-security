package com.myspring.application.repository;

import com.myspring.application.model.AdminEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author emininal
 * @since 24.08.2020
 */

@Repository
public interface AdminRepository extends CrudRepository<AdminEntity, Long> {

}
