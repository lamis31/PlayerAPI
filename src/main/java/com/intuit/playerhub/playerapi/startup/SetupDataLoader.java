package com.intuit.playerhub.playerapi.startup;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class is responsible for initializing the database with players from CSV file on application startup
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {


  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {

  }
}