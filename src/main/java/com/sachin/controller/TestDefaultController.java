package com.sachin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/users")
public class TestDefaultController {


  @GetMapping(value = "/testUsers", params = {"page"})
  public ResponseEntity<String> getUsers(@RequestParam(defaultValue = "10") int page) {
    return new ResponseEntity<String>("Its working fine", HttpStatus.OK);

  }

  @GetMapping
  public ResponseEntity<String> test() {
    return new ResponseEntity<String>("Its working without fine", HttpStatus.OK);

  }

}
