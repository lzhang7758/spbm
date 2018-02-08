package com.zl.spbm.entity;

import java.io.Serializable;
import java.util.Date;

public class InfoEmployee implements Serializable{
	
	private static final long serialVersionUID = -8398794408504881678L;

	private Long empId;

    private Date creTime;

    private Long creUsr;

    private Integer status;

    private Date updTime;

    private Long updUsr;

    private String algEdition;

    private String authority;

    private String calid;

    private String cardNum;

    private String checkType;

    private Long comA8id;

    private Long comId;

    private Long depA8id;

    private Long empA8id;

    private String empAccount;

    private String empName;

    private String empNo;

    private Long lvA8id;

    private String opendoorType;

    private Long postA8id;

    private String sn;

    private Date synTime;

    private Long timeStep;

    private Long depId;

    private Long lvId;

    private Long postId;

    private String empEmail;

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Date getCreTime() {
        return creTime;
    }

    public void setCreTime(Date creTime) {
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

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Long getUpdUsr() {
        return updUsr;
    }

    public void setUpdUsr(Long updUsr) {
        this.updUsr = updUsr;
    }

    public String getAlgEdition() {
        return algEdition;
    }

    public void setAlgEdition(String algEdition) {
        this.algEdition = algEdition == null ? null : algEdition.trim();
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority == null ? null : authority.trim();
    }

    public String getCalid() {
        return calid;
    }

    public void setCalid(String calid) {
        this.calid = calid == null ? null : calid.trim();
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum == null ? null : cardNum.trim();
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType == null ? null : checkType.trim();
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

    public Long getEmpA8id() {
        return empA8id;
    }

    public void setEmpA8id(Long empA8id) {
        this.empA8id = empA8id;
    }

    public String getEmpAccount() {
        return empAccount;
    }

    public void setEmpAccount(String empAccount) {
        this.empAccount = empAccount == null ? null : empAccount.trim();
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo == null ? null : empNo.trim();
    }

    public Long getLvA8id() {
        return lvA8id;
    }

    public void setLvA8id(Long lvA8id) {
        this.lvA8id = lvA8id;
    }

    public String getOpendoorType() {
        return opendoorType;
    }

    public void setOpendoorType(String opendoorType) {
        this.opendoorType = opendoorType == null ? null : opendoorType.trim();
    }

    public Long getPostA8id() {
        return postA8id;
    }

    public void setPostA8id(Long postA8id) {
        this.postA8id = postA8id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public Date getSynTime() {
        return synTime;
    }

    public void setSynTime(Date synTime) {
        this.synTime = synTime;
    }

    public Long getTimeStep() {
        return timeStep;
    }

    public void setTimeStep(Long timeStep) {
        this.timeStep = timeStep;
    }

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    public Long getLvId() {
        return lvId;
    }

    public void setLvId(Long lvId) {
        this.lvId = lvId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail == null ? null : empEmail.trim();
    }
}