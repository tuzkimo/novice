package me.novice.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
  private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

  @RequestMapping("/")
  public String hello() {
    LOGGER.info("Entered hello()");
    return "Hello World";
  }
}
