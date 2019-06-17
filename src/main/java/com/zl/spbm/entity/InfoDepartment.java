package com.zl.spbm.entity;

import java.time.LocalDateTime;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:03
 */
public class InfoDepartment {
    private Long depId;

    /**
    * 创建时间
    */
    private LocalDateTime creTime;

    /**
    * 创建人
    */
    private Long creUsr;

    /**
    * 状态
    */
    private Integer status;

    /**
    * 更新时间
    */
    private LocalDateTime updTime;

    /**
    * 更新人
    */
    private Long updUsr;

    /**
    * 公司A8Id
    */
    private Long comA8id;

    /**
    * 公司Id
    */
    private Long comId;

    /**
    * 部门A8Id
    */
    private Long depA8id;

    /**
    * 部门编号
    */
    private String depCode;

    /**
    * 部门描述
    */
    private String depDescription;

    /**
    * 部门名称
    */
    private String depName;

    /**
    * 部门路径
    */
    private String depPath;

    /**
    * 父部门Id
    */
    private Long depPid;

    /**
    * 部门简称
    */
    private String depShortName;

    /**
    * 同步时间
    */
    private LocalDateTime synTime;

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    public LocalDateTime getCreTime() {
        return creTime;
    }

    public void setCreTime(LocalDateTime creTime) {
        this.creTime = creTime;
    }

    public Long getCreUsr() {
        return creUsr;
    }

    public void setCreUsr(Long creUsr) {
        this.creUsr = creUsr;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getUpdTime() {
        return updTime;
    }

    public void setUpdTime(LocalDateTime updTime) {
        this.updTime = updTime;
    }

    public Long getUpdUsr() {
        return updUsr;
    }

    public void setUpdUsr(Long updUsr) {
        this.updUsr = updUsr;
    }

    public Long getComA8id() {
        return comA8id;
    }

    public void setComA8id(Long comA8id) {
        this.comA8id = comA8id;
    }

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public Long getDepA8id() {
        return depA8id;
    }

    public void setDepA8id(Long depA8id) {
        this.depA8id = depA8id;
    }

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getDepDescription() {
        return depDescription;
    }

    public void setDepDescription(String depDescription) {
        this.depDescription = depDescription;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepPath() {
        return depPath;
    }

    public void setDepPath(String depPath) {
        this.depPath = depPath;
    }

    public Long getDepPid() {
        return depPid;
    }

    public void setDepPid(Long depPid) {
        this.depPid = depPid;
    }

    public String getDepShortName() {
        return depShortName;
    }

    public void setDepShortName(String depShortName) {
        this.depShortName = depShortName;
    }

    public LocalDateTime getSynTime() {
        return synTime;
    }

    public void setSynTime(LocalDateTime synTime) {
        this.synTime = synTime;
    }
}