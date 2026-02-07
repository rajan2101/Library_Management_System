package com.lms.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "member")
public class Member {
    @Id
    @Column(name = "member_id")
    private String memberId;
    private String name;
    private String address;
    @Column(name = "member_type")
    private String memberType;
    @Column(name = "member_date")
    private Date memberDate;
    @Column(name = "expiry_date")
    private Date expiryDate;

    // Constructors, Getters, Setters
    public Member() {}
    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getMemberType() { return memberType; }
    public void setMemberType(String memberType) { this.memberType = memberType; }
    public Date getMemberDate() { return memberDate; }
    public void setMemberDate(Date memberDate) { this.memberDate = memberDate; }
    public Date getExpiryDate() { return expiryDate; }
    public void setExpiryDate(Date expiryDate) { this.expiryDate = expiryDate; }
}