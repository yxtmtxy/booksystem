package com.eurekaconsumer.pojo;

import java.io.Serializable;

public class StudentInfo implements Serializable {

  private Integer stuId;
  private String username;
  private String password;
  private String stuName;
  private String stuSex;
  private String stuFaculty;
  private String stuMajor;
  private String stuClass;
  private String stuPhone;

  private static final long serialVersionUID = 1L;


  public Integer getStuId() {
    return stuId;
  }

  public void setStuId(Integer stuId) {
    this.stuId = stuId;
  }

  public String getUsername() { return username; }

  public void setUsername(String username) {
    this.username = username == null ? null : username.trim();
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password == null ? null : password.trim();
  }

  public String getStuName() {
    return stuName;
  }

  public void setStuName(String stuName) {
    this.stuName = stuName;
  }


  public String getStuSex() {
    return stuSex;
  }

  public void setStuSex(String stuSex) {
    this.stuSex = stuSex;
  }


  public String getStuFaculty() {
    return stuFaculty;
  }

  public void setStuFaculty(String stuFaculty) {
    this.stuFaculty = stuFaculty;
  }


  public String getStuMajor() {
    return stuMajor;
  }

  public void setStuMajor(String stuMajor) {
    this.stuMajor = stuMajor;
  }


  public String getStuClass() {
    return stuClass;
  }

  public void setStuClass(String stuClass) {
    this.stuClass = stuClass;
  }


  public String getStuPhone() {
    return stuPhone;
  }

  public void setStuPhone(String stuPhone) {
    this.stuPhone = stuPhone;
  }

}
