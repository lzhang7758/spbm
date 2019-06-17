package com.zl.spbm.entity;

import java.time.LocalDateTime;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:03
 */
public class InfoLevel {
    private Long lvId;

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
    * 职级A8Id
    */
    private Long lvA8id;

    /**
    * 职级编码
    */
    private String lvCode;

    /**
    * 职级描述
    */
    private String lvDescription;

    /**
    * 职级名称
    */
    private String lvName;

    /**
    * 职级号码
    */
    private String lvNo;

    /**
    * 同步时间
    */
    private LocalDateTime synTime;

    public Long getLvId() {
        return lvId;
    }

    public void setLvId(Long lvId) {
        this.lvId = lvId;
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

    public Long getLvA8id() {
        return lvA8id;
    }

    public void setLvA8id(Long lvA8id) {
        this.lvA8id = lvA8id;
    }

    public String getLvCode() {
        return lvCode;
    }

    public void setLvCode(String lvCode) {
        this.lvCode = lvCode;
    }

    public String getLvDescription() {
        return lvDescription;
    }

    public void setLvDescription(String lvDescription) {
        this.lvDescription = lvDescription;
    }

    public String getLvName() {
        return lvName;
    }

    public void setLvName(String lvName) {
        this.lvName = lvName;
    }

    public String getLvNo() {
        return lvNo;
    }

    public void setLvNo(String lvNo) {
        this.lvNo = lvNo;
    }

    public LocalDateTime getSynTime() {
        return synTime;
    }

    public void setSynTime(LocalDateTime synTime) {
        this.synTime = synTime;
    }
}