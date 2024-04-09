package com.example.validator.controller;

import com.example.validator.pojo.Result;
import com.example.validator.pojo.User;
import com.example.validator.service.ValidatorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
//@Validated
public class ValidatorController {
    @Autowired
    private ValidatorService service;

    @GetMapping("/")
    public Result<String> hello() {
        return new Result<String>(1, "hello");
    }

    @PostMapping("/insert")
    public Result<User> insert(@RequestBody @Valid User user) {
        return new Result<User>(1, "新增成功", service.insert(user));
    }

    @PatchMapping("/update")
    public Result<String> update(String name) {
        //更新，
        User user =new User();
        user.setUsername(name);
        //使用Bean Validation進行驗證
        service.insert(user);
        return new Result<String>(1, "成功");
    }

}
