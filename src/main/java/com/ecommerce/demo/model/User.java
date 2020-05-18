package com.ecommerce.demo.model;

import com.ecommerce.demo.Repository.AutoIncKey;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @描述 : 用户扩展信息
 * @创建者：程新状
 * @创建时间： 2020/4/26
 *
 */
@Document(collection = "user")
public class User {

    /** ID **/
    @AutoIncKey
    private long UUID;
    /** 所在学校 **/
    private String school;
    /** 住址 **/
    //private String address;
    /** 身份证 **/
    //private String codeNum;
    /** 手机号 **/
    //private String phone;

    /** 用户名 **/
    private String userName;
    /** 密码 **/
    private String passWord;
    /** 姓名 **/
    private String name;
    /** 年龄 **/
    private String age;
    /** 性别 **/
    private String gender;

    public User() {}

    public User(String userName, String passWord, String name, String gender, String age, String school) {
        this.userName = userName;
        this.name = name;
        this.passWord = passWord;
        this.gender = gender;
        this.age = age;
        this.school = school;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public long getUUID() {
        return UUID;
    }

    public void setUUID(long UUID) {
        this.UUID = UUID;
    }


    /*public String getAddress() {
        return address;
    }

    //public void setAddress(String address) {
        this.address = address;
    }

    public String getCodeNum() {
        return codeNum;
    }

    public void setCodeNum(String codeNum) {
        this.codeNum = codeNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }*/

}