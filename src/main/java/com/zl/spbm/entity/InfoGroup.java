package com.zl.spbm.entity;

import java.time.LocalDate;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:03
 */
public class InfoGroup {
    /**
    * 用户组ID
    */
    private Long usgId;

    /**
    * 用户组代码
    */
    private String usgCode;

    /**
    * 用户组名称
    */
    private String usgName;

    /**
    * 创建时间
    */
    private LocalDate creTime;

    /**
    * 创建人
    */
    private String creUsr;

    /**
    * 修改人
    */
    private String updUsr;

    /**
    * 修改时间
    */
    private LocalDate updTime;

    /**
    * 状态标示
    */
    private Integer status;

    public Long getUsgId() {
        return usgId;
    }

    public void setUsgId(Long usgId) {
        this.usgId = usgId;
    }

    public String getUsgCode() {
        return usgCode;
    }

    public void setUsgCode(String usgCode) {
        this.usgCode = usgCode;
    }

    public String getUsgName() {
        return usgName;
    }

    public void setUsgName(String usgName) {
        this.usgName = usgName;
    }

    public LocalDate getCreTime() {
        return creTime;
    }

    public void setCreTime(LocalDate creTime) {
        this.creTime = creTime;
    }

    public String getCreUsr() {
        return creUsr;
    }

    public void setCreUsr(String creUsr) {
        this.creUsr = creUsr;
    }

    public String getUpdUsr() {
        return updUsr;
    }

    public void setUpdUsr(String updUsr) {
        this.updUsr = updUsr;
    }

    public LocalDate getUpdTime() {
        return updTime;
    }

    public void setUpdTime(LocalDate updTime) {
        this.updTime = updTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}