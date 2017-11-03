package me.novice.data.entity;

public class UserEntity {
  private String id;
  private String username;
  private String password;
  private String nickname;

  public UserEntity() {
  }

  public UserEntity(String id, String username, String password, String nickname) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.nickname = nickname;
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

  public String getNickname() {
    return nickname;
  }
}
