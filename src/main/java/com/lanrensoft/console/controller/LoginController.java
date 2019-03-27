package com.lanrensoft.console.controller;

import com.lanrensoft.console.model.LoginReqVO;
import com.lanrensoft.model.console.ConsoleRespVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/console/login/page")
    public String getLoginPage(){

        return "login";
    }

    @RequestMapping("/console/login")
    @ResponseBody
    public ConsoleRespVO doLogin(LoginReqVO loginReqVO){

        return ConsoleRespVO.buildSucc();
    }

}
