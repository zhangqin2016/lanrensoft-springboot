package com.lanrensoft.api.controller;

import com.lanrensoft.api.service.IIndexService;
import com.lanrensoft.model.api.resp.ApiRespData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhangqin
 * @description:
 * @date 2019/3/7 23:40
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
