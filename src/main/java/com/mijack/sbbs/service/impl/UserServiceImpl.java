package com.mijack.sbbs.service.impl;

import com.mijack.sbbs.exceptions.IllegalPasswordException;
import com.mijack.sbbs.exceptions.UserNotFoundException;
import com.mijack.sbbs.model.User;
import com.mijack.sbbs.repository.UserRepository;
import com.mijack.sbbs.service.UserService;
import com.mijack.sbbs.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException(String.format("邮箱为%s的用户不存在", email));
        }
        if (!Utils.isEquals(password, user.getPassword())) {
            throw new IllegalPasswordException();
        }
        return user;
    }
}
