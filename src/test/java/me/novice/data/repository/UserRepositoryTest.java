package me.novice.data.repository;

import me.novice.config.RootConfig;
import me.novice.data.entity.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class UserRepositoryTest {
  @Autowired
  private UserRepository repository;

  @Test
  public void testQueryAll() throws Exception {
    List<UserEntity> users = repository.getAll();
    Assert.assertNotNull(users);
    Assert.assertEquals(5, users.size());
    for (UserEntity user : users) {
      System.out.println(user);
    }
  }

  @Test
  public void testQueryOne() throws Exception {
    UserEntity user = repository.getOne("D6066C51-2127-43A7-9C9D-2350C62AB51F");
    Assert.assertNotNull(user);
    System.out.println(user);
  }

  @Test
  public void testInsert() throws Exception {
    List<UserEntity> users = repository.add(new UserEntity("anthony", "anthony005"));
    Assert.assertNotNull(users);
    Assert.assertEquals(5, users.size());
    for (UserEntity user : users) {
      System.out.println(user);
    }
  }
}
