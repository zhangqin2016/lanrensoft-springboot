package com.lanrensoft.api.controller;

import com.lanrensoft.api.service.IIndexService;
import com.lanrensoft.model.api.resp.ApiRespData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhangqin
 * @description:
 * @date 2019/3/7 23:40
 */
@RestController
public class IndexController {

    @Resource
    private IIndexService indexService;

    @RequestMapping("/")
    public ApiRespData index(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return indexService.index();
    }
}
