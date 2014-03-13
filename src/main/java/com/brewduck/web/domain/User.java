package com.brewduck.web.domain;

import java.io.Serializable;

//import org.hibernate.validator.constraints.NotEmpty;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

    //유저 정보 카운트
    private int userCnt;

    private String name;

    //유저 ID
    private int id;

    //계정 ID
    private int accountId;

    //성별
    private int gender;

    //키
    private int height;

    //몸무게
    private int weight;

    //혈액형
    private int bloodType;

    //주소 ID
    private int addressId;

    //생년월일
    private String birthDate;

    //생년
    private String birthYear;

    //생월
    private String birthMonth;

    //생일
    private String birthDay;

    //가족관계 ID
    private int familyRelationId;

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserCnt() {
        return userCnt;
    }

    public void setUserCnt(int userCnt) {
        this.userCnt = userCnt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setBloodType(int bloodType) {
        this.bloodType = bloodType;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }



    public void setFamilyRelationId(int familyRelationId) {
        this.familyRelationId = familyRelationId;
    }

    public int getId() {
        return id;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getGender() {
        return gender;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getBloodType() {
        return bloodType;
    }

    public int getAddressId() {
        return addressId;
    }



    public int getFamilyRelationId() {
        return familyRelationId;
    }
}
