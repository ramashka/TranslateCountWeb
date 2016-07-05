package edu.rdragunov.count.translator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by roman.dragunov on 27-06-02016.
 */
@Controller
public class HelloController {
  @RequestMapping("/hello")
  @ResponseBody
  public String helloWorld(){
    return "HelloWorld)";
  }
}
