package me.novice.data.repository;

import me.novice.data.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepository {
  private final List<UserEntity> users;

  public UserRepositoryImp() {
    users = new ArrayList<>();
    users.add(new UserEntity("USR001", "james", "james001", "king"));
    users.add(new UserEntity("USR002", "embid", "james002", "empire"));
    users.add(new UserEntity("USR003", "curry", "james003", "kid"));
    users.add(new UserEntity("USR004", "westbrook", "westbrook004", "turtle"));
  }

  public List<UserEntity> getAll() {
    return users;
  }

  public UserEntity getOne(String id) {
    for (UserEntity user : users) {
      if (user.getId().equals(id)) {
        return user;
      }
    }
    return null;
  }

  public List<UserEntity> add(UserEntity user) {
    users.add(user);
    return users;
  }
}
