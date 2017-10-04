package com.mijack.sbbs.service;

import com.mijack.sbbs.model.User;

public interface UserService {
    User login(String email, String password);
}
