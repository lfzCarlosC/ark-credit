package com.cryptal.ark.arkcreditservice.user.controller;

import com.cryptal.ark.arkcreditservice.user.request.RegisterUserRequest;
import com.cryptal.ark.arkcreditservice.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ApiOperation(value = "注册用户")
    public ResponseEntity register(@RequestBody RegisterUserRequest request) {
        userService.register(request);
        return ResponseEntity.ok("success");
    }

}
