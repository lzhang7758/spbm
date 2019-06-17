package com.zl.spbm.entity;

import java.time.LocalDateTime;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:03
 */
public class InfoEmployee {
    private static final long serialVersionUID = -8398794408504881678L;
    private Long empId;

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
     * 算法版本
     */
    private String algEdition;

    /**
     * 权限
     */
    private String authority;

    private String calid;

    /**
     * 卡号
     */
    private String cardNum;

    /**
     * 考勤类型
     */
    private String checkType;

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
     * 员工A8Id
     */
    private Long empA8id;

    /**
     * 登陆名
     */
    private String empAccount;

    /**
     * 员工姓名
     */
    private String empName;

    /**
     * 员工编号
     */
    private String empNo;

    /**
     * 职级A8Id
     */
    private Long lvA8id;

    /**
     * 开门类型
     */
    private String opendoorType;

    /**
     * 职位A8Id
     */
    private Long postA8id;

    /**
     * 设备序列号
     */
    private String sn;

    /**
     * 同步时间
     */
    private LocalDateTime synTime;

    /**
     * 更新时间戳
     */
    private Long timeStep;

    /**
     * 部门Id
     */
    private Long depId;

    /**
     * 职级Id
     */
    private Long lvId;

    /**
     * 职位Id
     */
    private Long postId;

    /**
     * 邮箱地址
     */
    private String empEmail;

    /**
     * 邮箱密码
     */
    private String empEmailPwd;

    /**
     * 邮箱修改操作时间
     */
    private LocalDateTime optemailTime;

    /**
     * 邮箱修改操作人
     */
    private Long optemailUsrid;

    /**
     * 岗位Code
     */
    private String positioncode;

    /**
     * 专业Code
     */
    private String majorcode;

    /**
     * 手机号
     */
    private String tel;

    /**
     * 租户ID
     */
    private Integer tenantid;

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
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

    public String getAlgEdition() {
        return algEdition;
    }

    public void setAlgEdition(String algEdition) {
        this.algEdition = algEdition;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getCalid() {
        return calid;
    }

    public void setCalid(String calid) {
        this.calid = calid;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
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
        this.empAccount = empAccount;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
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
        this.opendoorType = opendoorType;
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
        this.sn = sn;
    }

    public LocalDateTime getSynTime() {
        return synTime;
    }

    public void setSynTime(LocalDateTime synTime) {
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
        this.empEmail = empEmail;
    }

    public String getEmpEmailPwd() {
        return empEmailPwd;
    }

    public void setEmpEmailPwd(String empEmailPwd) {
        this.empEmailPwd = empEmailPwd;
    }

    public LocalDateTime getOptemailTime() {
        return optemailTime;
    }

    public void setOptemailTime(LocalDateTime optemailTime) {
        this.optemailTime = optemailTime;
    }

    public Long getOptemailUsrid() {
        return optemailUsrid;
    }

    public void setOptemailUsrid(Long optemailUsrid) {
        this.optemailUsrid = optemailUsrid;
    }

    public String getPositioncode() {
        return positioncode;
    }

    public void setPositioncode(String positioncode) {
        this.positioncode = positioncode;
    }

    public String getMajorcode() {
        return majorcode;
    }

    public void setMajorcode(String majorcode) {
        this.majorcode = majorcode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getTenantid() {
        return tenantid;
    }

    public void setTenantid(Integer tenantid) {
        this.tenantid = tenantid;
    }
}