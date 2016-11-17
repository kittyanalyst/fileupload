package com.amiti.cloud.user.persistence.repository;

import com.amiti.cloud.user.persistence.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ramakrishna Chalasani on 11/17/16.
 */
public interface UserRespository extends JpaRepository<User, Long> {

}
