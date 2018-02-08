package com.zl.spbm.entity;

import java.io.Serializable;

public class SysUserRole implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 278215766210742006L;

	private Integer urId;

    private Integer roleId;

    private Integer uid;

    public Integer getUrId() {
        return urId;
    }

    public void setUrId(Integer urId) {
        this.urId = urId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}