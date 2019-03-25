package com.lanrensoft.console.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/console/login/page")
    public String getLoginPage(){

        return "login";
    }
}
