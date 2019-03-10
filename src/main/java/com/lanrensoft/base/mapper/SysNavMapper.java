package com.lanrensoft.base.mapper;

import com.lanrensoft.base.po.SysNav;
import com.lanrensoft.base.po.SysNavExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNavMapper {
    long countByExample(SysNavExample example);

    int deleteByExample(SysNavExample example);

    int deleteByPrimaryKey(String navId);

    int insert(SysNav record);

    int insertSelective(SysNav record);

    List<SysNav> selectByExample(SysNavExample example);

    SysNav selectByPrimaryKey(String navId);

    int updateByExampleSelective(@Param("record") SysNav record, @Param("example") SysNavExample example);

    int updateByExample(@Param("record") SysNav record, @Param("example") SysNavExample example);

    int updateByPrimaryKeySelective(SysNav record);

    int updateByPrimaryKey(SysNav record);
}