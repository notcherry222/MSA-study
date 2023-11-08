package com.playdata.repository;

import com.playdata.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUuid(String uuid);

    User findUserByUserId(String userId);
}
