package com.lanrensoft.base.mapper;

import com.lanrensoft.base.po.SysNavRole;
import com.lanrensoft.base.po.SysNavRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNavRoleMapper {
    long countByExample(SysNavRoleExample example);

    int deleteByExample(SysNavRoleExample example);

    int deleteByPrimaryKey(String snrId);

    int insert(SysNavRole record);

    int insertSelective(SysNavRole record);

    List<SysNavRole> selectByExample(SysNavRoleExample example);

    SysNavRole selectByPrimaryKey(String snrId);

    int updateByExampleSelective(@Param("record") SysNavRole record, @Param("example") SysNavRoleExample example);

    int updateByExample(@Param("record") SysNavRole record, @Param("example") SysNavRoleExample example);

    int updateByPrimaryKeySelective(SysNavRole record);

    int updateByPrimaryKey(SysNavRole record);
}