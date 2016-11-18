package com.amiti.cloud.user.persistence.repository;

import com.amiti.cloud.user.persistence.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Ramakrishna Chalasani on 11/17/16.
 */
public interface UserRespository extends JpaRepository<User, Long> {
    Optional<User> findOneByLogonId(String logonId);
}
