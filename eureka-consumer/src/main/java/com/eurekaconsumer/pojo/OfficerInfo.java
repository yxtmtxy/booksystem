package com.eurekaconsumer.pojo;

import java.io.Serializable;

public class OfficerInfo implements Serializable {

  private Integer offId;
  private String username;
  private String password;
  private String offName;
  private String offSex;
  private String offPost;
  private String offPhone;
  private static final long serialVersionUID = 1L;

  public Integer getOffId() {
    return offId;
  }

  public void setOffId(Integer offId) {
    this.offId = offId;
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

  public String getOffName() {
    return offName;
  }

  public void setOffName(String offName) {
    this.offName = offName;
  }


  public String getOffSex() {
    return offSex;
  }

  public void setOffSex(String offSex) {
    this.offSex = offSex;
  }


  public String getOffPost() {
    return offPost;
  }

  public void setOffPost(String offPost) {
    this.offPost = offPost;
  }


  public String getOffPhone() {
    return offPhone;
  }

  public void setOffPhone(String offPhone) {
    this.offPhone = offPhone;
  }

}
