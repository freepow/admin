package com.brewduck.web.domain;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;

//import org.hibernate.validator.constraints.NotEmpty;

public class Profile implements Serializable {

	private static final long serialVersionUID = 1L;

    //프로필 ID
    private int id;

	//@NotEmpty
    //계정 ID
	private int accountId;

    private String userName;

    private String userGender;

    //키
    private String userHeight;

    //몸무게
    private String userWeight;

    //생년
    private String userBirthYear;

    //생월
    private String userBirthMonth;

    //생일
    private String userBirthDay;

    //프로필 갯수
    private int profileCnt;

    public String getUserBirthYear() {
        return userBirthYear;
    }

    public void setUserBirthYear(String userBirthYear) {
        this.userBirthYear = userBirthYear;
    }

    public String getUserBirthMonth() {
        return userBirthMonth;
    }

    public void setUserBirthMonth(String userBirthMonth) {
        this.userBirthMonth = userBirthMonth;
    }

    public String getUserBirthDay() {
        return userBirthDay;
    }

    public void setUserBirthDay(String userBirthDay) {
        this.userBirthDay = userBirthDay;
    }

    public String getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(String userHeight) {
        this.userHeight = userHeight;
    }

    public String getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(String userWeight) {
        this.userWeight = userWeight;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
