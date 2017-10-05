package com.mijack.sbbs.controller.api;

import com.mijack.sbbs.service.AuthService;
import com.mijack.sbbs.service.UserService;
import com.mijack.sbbs.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class ApiUserController {
    @Autowired
    UserService userService;
    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public Response login(Authentication authentication) {
//        ApiAuthenticationToken token = (ApiAuthenticationToken) authentication;
//        if (!Utils.isEmail(token.getEmail())) {
//            return Response.ok(null).code(0).msg("邮箱格式错误");
//        }
//        // 登陆用户
//        User user = userService.login(token.getUsername(), token.getEmail(), token.getPassword());
//        // 更新token
//        if (user == null) {
        return Response.ok(null).code(0).msg("账号或者密码错误");
//        }
//        return Response.ok(token.getUser()).put("token", token.getToken())
//                .msg("登录成功");
    }
}
