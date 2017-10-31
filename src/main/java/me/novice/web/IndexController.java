package me.novice.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
  @RequestMapping("/")
  public String hello() {
    return "Hello World";
  }
}
