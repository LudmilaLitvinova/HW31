package com.example.hw31.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Liudmyla Litvinova on 11.02.23
 */
@Controller
@Slf4j
public class IndexController {

    @GetMapping("ping")
    public String handler() {
        return "ping";
    }

    @GetMapping("login")
    public String login() {
        log.info("Login page");
        return "login";
    }

    @GetMapping("403")
    public String error403() {
        log.info("Login page");
        return "403Error";
    }

}
