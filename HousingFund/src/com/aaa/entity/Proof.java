package com.aaa.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Proof entity. @author MyEclipse Persistence Tools
 */
   //权属证明表
public class Proof  implements java.io.Serializable {


    // Fields    

     private Integer ownershipId;
     private String person;//所属人
     private String address;//地址
     private String issuedName;//颁发单位
     private Timestamp issuesDate;//颁发时间
     private Set collateralinfos = new HashSet(0);


    // Constructors

    /** default constructor */
    public Proof() {
    }

    
    /** full constructor */
    public Proof(String person, String address, String issuedName, Timestamp issuesDate, Set collateralinfos) {
        this.person = person;
        this.address = address;
        this.issuedName = issuedName;
        this.issuesDate = issuesDate;
        this.collateralinfos = collateralinfos;
    }

   
    // Property accessors

    public Integer getOwnershipId() {
        return this.ownershipId;
    }
    
    public void setOwnershipId(Integer ownershipId) {
        this.ownershipId = ownershipId;
    }

    public String getPerson() {
        return this.person;
    }
    
    public void setPerson(String person) {
        this.person = person;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getIssuedName() {
        return this.issuedName;
    }
    
    public void setIssuedName(String issuedName) {
        this.issuedName = issuedName;
    }

    public Timestamp getIssuesDate() {
        return this.issuesDate;
    }
    
    public void setIssuesDate(Timestamp issuesDate) {
        this.issuesDate = issuesDate;
    }

    public Set getCollateralinfos() {
        return this.collateralinfos;
    }
    
    public void setCollateralinfos(Set collateralinfos) {
        this.collateralinfos = collateralinfos;
    }
   








}