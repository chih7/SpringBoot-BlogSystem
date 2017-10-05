package com.mijack.sbbs.service;

import com.mijack.sbbs.model.User;

public interface AuthService {
    User findUserByToken(String token);


    String createToken(User user);
}
