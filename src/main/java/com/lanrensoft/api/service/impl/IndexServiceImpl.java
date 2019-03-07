package com.lanrensoft.api.service.impl;

import com.lanrensoft.api.service.IIndexService;
import com.lanrensoft.model.api.resp.ApiRespData;
import org.springframework.stereotype.Service;

/**
 * @author zhangqin
 * @description:
 * @date 2019/3/7 23:39
 */
@Service
public class IndexServiceImpl implements IIndexService {


    @Override
    public ApiRespData index() {
        return ApiRespData.buildSucc();
    }
}
