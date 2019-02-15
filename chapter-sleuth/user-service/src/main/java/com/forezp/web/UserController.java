package com.forezp.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fangzhipeng on 2017/8/2.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hi")
    public String hi(){
        return port;
    }
}
