package com.zl.spbm.entity;

import java.time.LocalDateTime;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:03
 */
public class InfoPosition {
    private Long postId;

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
    private String comId;

    /**
    * 职位A8Id
    */
    private Long postA8id;

    /**
    * 职位编码
    */
    private String postCode;

    /**
    * 职位描述
    */
    private String postDescription;

    /**
    * 职位名称
    */
    private String postName;

    /**
    * 职位类别
    */
    private String postType;

    /**
    * 同步时间
    */
    private LocalDateTime synTime;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
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

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public Long getPostA8id() {
        return postA8id;
    }

    public void setPostA8id(Long postA8id) {
        this.postA8id = postA8id;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public LocalDateTime getSynTime() {
        return synTime;
    }

    public void setSynTime(LocalDateTime synTime) {
        this.synTime = synTime;
    }
}