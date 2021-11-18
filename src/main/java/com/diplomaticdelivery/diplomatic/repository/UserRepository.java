package com.diplomaticdelivery.diplomatic.repository;

import com.diplomaticdelivery.diplomatic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByName(String name);
    User findByUserName(String userName);
    User findByEmailAddress(String email);
}
