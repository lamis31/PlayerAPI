package com.intuit.playerhub.playerapi;

import org.springframework.boot.SpringApplication;

public class TestPlayerApiApplication {

  public static void main(String[] args) {
    SpringApplication.from(PlayerApiApplication::main).with(TestcontainersConfiguration.class).run(args);
  }

}
