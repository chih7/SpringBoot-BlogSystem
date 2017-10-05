package com.mijack.sbbs.service.impl;

import com.mijack.sbbs.model.User;
import com.mijack.sbbs.repository.TokenRepository;
import com.mijack.sbbs.repository.UserRepository;
import com.mijack.sbbs.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class AuthServiceImpl implements AuthService {
    @Autowired
    TokenRepository tokenRepository;

    @Override
    public User findUserByToken(String token) {
        return tokenRepository.findByToken(token);
    }

    @Override
    public String createToken(User user) {
        // token 组成: base64(user_id:email:login_time)
        return null;
    }
}
