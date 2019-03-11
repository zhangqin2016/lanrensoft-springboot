package com.lanrensoft.api.service.impl;

import com.lanrensoft.api.service.IIndexService;
import com.lanrensoft.base.mapper.SysUserMapper;
import com.lanrensoft.base.po.SysUserExample;
import com.lanrensoft.model.api.resp.ApiRespData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangqin
 * @description:
 * @date 2019/3/7 23:39
 */
@Service
public class IndexServiceImpl implements IIndexService {
     @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public ApiRespData index() {
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUserAccountEqualTo("admin");
        return ApiRespData.buildSucc(sysUserMapper.selectByExample(sysUserExample));
    }
}
