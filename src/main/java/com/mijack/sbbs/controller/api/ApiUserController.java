package com.mijack.sbbs.controller.api;

import com.mijack.sbbs.model.User;
import com.mijack.sbbs.service.UserService;
import com.mijack.sbbs.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class ApiUserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Response<User> login(
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
        User user = userService.login(email, password);
        return Response.ok(user).msg("登录成功");
    }
}
