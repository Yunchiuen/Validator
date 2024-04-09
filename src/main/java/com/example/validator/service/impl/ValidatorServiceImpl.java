package com.example.validator.service.impl;


import com.example.validator.pojo.User;
import com.example.validator.repository.ValidatorRepository;
import com.example.validator.service.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidatorServiceImpl implements ValidatorService {
    @Autowired
    private ValidatorRepository repository;

    @Override
    public User insert(User user) {
        return repository.save(user);
    }
}
