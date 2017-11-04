package me.novice.data.entity;

import java.util.Date;

public class UserEntity {
  private String id;
  private String username;
  private String password;
  private Date createDate;
  private Boolean isBlocked;

  public UserEntity() {
  }

  public UserEntity(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public UserEntity(String id, String username, String password, Date createDate, Boolean isBlocked) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.createDate = createDate;
    this.isBlocked = isBlocked;
  }

  public String getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public Boolean getBlocked() {
    return isBlocked;
  }

  @Override
  public String toString() {
    return "UserEntity{" +
        "id='" + id + '\'' +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", createDate=" + createDate +
        ", isBlocked=" + isBlocked +
        '}';
  }
}
