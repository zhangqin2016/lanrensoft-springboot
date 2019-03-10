package com.lanrensoft.base.po;

public class SysUserRole {
    private String snrId;

    private String suId;

    private String roleId;

    public String getSnrId() {
        return snrId;
    }

    public void setSnrId(String snrId) {
        this.snrId = snrId == null ? null : snrId.trim();
    }

    public String getSuId() {
        return suId;
    }

    public void setSuId(String suId) {
        this.suId = suId == null ? null : suId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}