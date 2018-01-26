/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.op.sb.dto;

public class UserDetailDTO {
    
    private int userID;
    private String name;
    private int age;
    private String homeAddress;
    private String officeAddress;
    private String mobile;
    private String phone;
    private String email;

    public UserDetailDTO() {
    }

    public UserDetailDTO(int userID, String name, int age, String homeAddress, String officeAddress, String mobile, String phone, String email) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.homeAddress = homeAddress;
        this.officeAddress = officeAddress;
        this.mobile = mobile;
        this.phone = phone;
        this.email = email;
    }
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
