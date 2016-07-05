package edu.rdragunov.count.translator.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * Created by roman.dragunov on 09-06-02016.
 */
@SpringBootApplication
@Configuration
@Import(edu.rdragunov.count.translator.config.MysqlConfig.class)

public class Main {
  public static void main(String[] args) {
    ApplicationContext ctx= SpringApplication.run(Main.class);
  }
}
