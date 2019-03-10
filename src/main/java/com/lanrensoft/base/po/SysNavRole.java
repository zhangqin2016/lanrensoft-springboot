package com.lanrensoft.base.po;

public class SysNavRole {
    private String snrId;

    private String navId;

    private String roleId;

    public String getSnrId() {
        return snrId;
    }

    public void setSnrId(String snrId) {
        this.snrId = snrId == null ? null : snrId.trim();
    }

    public String getNavId() {
        return navId;
    }

    public void setNavId(String navId) {
        this.navId = navId == null ? null : navId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}