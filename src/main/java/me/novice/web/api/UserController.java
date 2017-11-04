package me.novice.web.api;

import me.novice.data.entity.UserEntity;
import me.novice.data.repository.UserRepository;
import me.novice.web.Error;
import me.novice.web.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
  private final UserRepository repository;

  @Autowired
  public UserController(UserRepository repository) {
    this.repository = repository;
  }

  @ExceptionHandler(UserNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public Error userNotFound(UserNotFoundException e) {
    String userId = e.getUserId();
    return new Error(40201, "User with id " + userId + " not found");
  }

  @RequestMapping(value = "/user", produces = "application/json")
  @Transactional
  public List<UserEntity> getAll() {
    LOGGER.info("Fetching all users");
    return repository.getAll();
  }

  @RequestMapping(value = "/user/{id}", produces = "application/json")
  @Transactional
  public UserEntity getOne(@PathVariable String id) {
    LOGGER.info("Fetching user with id {}", id);
    UserEntity user = null;
    try {
      user = repository.getOne(id);
    } catch (Exception e) {
      LOGGER.warn("User with id {} not found", id);
      throw new UserNotFoundException(id);
    }
    return user;
  }

  @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
  @Transactional
  public ResponseEntity<List<UserEntity>> add(@RequestBody UserEntity user, UriComponentsBuilder uriComponentsBuilder) {
    LOGGER.info("Creating new user with id {}", user.getId());
    List<UserEntity> users = repository.add(user);
    HttpHeaders headers = generateLocationHeader(generateLocationUri(uriComponentsBuilder, "/api/user/", user.getId()));
    return new ResponseEntity<List<UserEntity>>(users, headers, HttpStatus.CREATED);
  }

  private HttpHeaders generateLocationHeader(URI locationUri) {
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(locationUri);
    return headers;
  }

  private URI generateLocationUri(UriComponentsBuilder builder, String... paths) {
    for (String path : paths) {
      builder.path(path);
    }
    return builder.build().toUri();
  }
}
