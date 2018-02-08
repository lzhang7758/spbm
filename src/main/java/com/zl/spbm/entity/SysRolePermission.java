package com.zl.spbm.entity;

import java.io.Serializable;

public class SysRolePermission implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3653640063981773244L;

	private Integer rpId;

    private Integer permissionId;

    private Integer roleId;

    public Integer getRpId() {
        return rpId;
    }

    public void setRpId(Integer rpId) {
        this.rpId = rpId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}