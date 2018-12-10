package com.changhr.cloud.provider.user.controller;

import com.changhr.cloud.provider.user.dao.UserRepository;
import com.changhr.cloud.provider.user.entity.User;
import com.changhr.cloud.provider.user.exception.ParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author changhr
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        if (id == null){
            throw new ParameterException();
        }
        User findOne = this.userRepository.findOne(id);
        return findOne;
    }

}
