package com.zl.spbm.entity;

import java.io.Serializable;
import java.util.List;

public class SysRole implements Serializable {
	private static final long serialVersionUID = 3393425121514207891L;

	private Integer roleId;

    private Boolean available;

    private String description;

    private String role;
    
    private List<SysPermission> permissions;//角色 -- 权限关系：多对多关系;
    
    private List<UserInfo> userInfos;// 一个角色对应多个用户

    public List<SysPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	}

	public List<UserInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}

	public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }
}