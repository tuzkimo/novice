package me.novice.data.repository;

import me.novice.data.entity.UserEntity;
import java.util.List;

public interface UserRepository {
  public List<UserEntity> getAll();

  public UserEntity getOne(String id);

  public List<UserEntity> add(UserEntity user);
}
