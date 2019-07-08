package com.zl.spbm.entity;

import java.time.LocalDateTime;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:03
 */
public class InfoCompany {
    private Long comId;

    private LocalDateTime creTime;

    private Long creUsr;

    private Integer status;

    private LocalDateTime updTime;

    private Long updUsr;

    private String code;

    private Long comA8id;

    private String comName;

    private LocalDateTime synTime;



    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getComA8id() {
        return comA8id;
    }

    public void setComA8id(Long comA8id) {
        this.comA8id = comA8id;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public LocalDateTime getSynTime() {
        return synTime;
    }

    public void setSynTime(LocalDateTime synTime) {
        this.synTime = synTime;
    }
}