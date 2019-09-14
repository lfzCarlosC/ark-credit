package com.cryptal.ark.arkcreditservice.user.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class User implements Serializable {

    @Id
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    private String tel;

    private String address;

    //后期要加入头像 profilePicture bankcards

    /**
     * 邀请用户(一级)
     */
    private Long inviteUserId1;

    /**
     * 邀请用户(二级)
     */
    private Long inviteUserId2;

    /**
     * 邀请用户(三级)
     */
    private Long inviteUserId3;

    /**
     * 等级ID
     */
    private Long rankId;

    /**
     * 积分
     */
    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInviteUserId1() {
        return inviteUserId1;
    }

    public void setInviteUserId1(Long inviteUserId1) {
        this.inviteUserId1 = inviteUserId1;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
        this.rankId = rankId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getInviteUserId2() {
        return inviteUserId2;
    }

    public void setInviteUserId2(Long inviteUserId2) {
        this.inviteUserId2 = inviteUserId2;
    }

    public Long getInviteUserId3() {
        return inviteUserId3;
    }

    public void setInviteUserId3(Long inviteUserId3) {
        this.inviteUserId3 = inviteUserId3;
    }
}
