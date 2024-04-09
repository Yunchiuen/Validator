package com.example.validator.repository;

import com.example.validator.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidatorRepository extends JpaRepository<User, Long> {

}
