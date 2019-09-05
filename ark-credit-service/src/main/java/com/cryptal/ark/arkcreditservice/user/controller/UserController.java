package com.cryptal.ark.arkcreditservice.user.controller;

import com.cryptal.ark.arkcreditservice.user.request.RegisterUserRequest;
import com.cryptal.ark.arkcreditservice.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/{id}/getUserInfo",  method = RequestMethod.GET)
    @ApiOperation(value = "获取用户信息")
    public @ResponseBody ResponseEntity getUserInfoById(
            @PathVariable("id") @ApiParam(value = "USER ID", required = true)
            final Long id) {
        return new ResponseEntity(userService.getUserInforById(id), HttpStatus.OK);
    }
}
