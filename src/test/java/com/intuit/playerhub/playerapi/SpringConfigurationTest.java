package com.intuit.playerhub.playerapi;


import static org.assertj.core.api.Assertions.assertThat;

import com.intuit.playerhub.playerapi.entities.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.repository.support.Repositories;


@SpringBootTest
public class SpringConfigurationTest {
  @Autowired
  ApplicationContext context;


  @Test
  void repositoriesAreAssignedToAppropriateStores() {

    var repositories = new Repositories(context);

    assertThat(repositories.getEntityInformationFor(Player.class)).isInstanceOf(JpaEntityInformation.class);
  }
}
