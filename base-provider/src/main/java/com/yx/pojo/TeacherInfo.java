package com.yx.pojo;

import java.io.Serializable;

public class TeacherInfo implements Serializable {

  private Integer teaId;
  private String username;
  private String password;
  private String teaName;
  private String teaSex;
  private String teaFaculty;
  private String teaPhone;

  private static final long serialVersionUID = 1L;

  public Integer getTeaId() {
    return teaId;
  }

  public void setTeaId(Integer teaId) {
    this.teaId = teaId;
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

  public String getTeaName() {
    return teaName;
  }

  public void setTeaName(String teaName) {
    this.teaName = teaName;
  }

  public String getTeaSex() {
    return teaSex;
  }

  public void setTeaSex(String teaSex) {
    this.teaSex = teaSex;
  }


  public String getTeaFaculty() {
    return teaFaculty;
  }

  public void setTeaFaculty(String teaFaculty) {
    this.teaFaculty = teaFaculty;
  }


  public String getTeaPhone() {
    return teaPhone;
  }

  public void setTeaPhone(String teaPhone) {
    this.teaPhone = teaPhone;
  }

}
