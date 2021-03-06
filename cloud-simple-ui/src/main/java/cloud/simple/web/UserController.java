/*
 * Copyright 2012-2020 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * @author lzhoumail@126.com/zhouli
 * Git http://git.oschina.net/zhou666/spring-cloud-7simple
 */
package cloud.simple.web;

import cloud.simple.model.User;
import cloud.simple.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/users")
    public ResponseEntity<List<User>> readUserInfo() {
        List<User> users = userService.readUserInfo();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public Object test() {
        String SERVICE_NAME = "cloud-simple-service";
        return restTemplate.getForObject("http://" + SERVICE_NAME + "/user", String.class);
    }
}
