package com.intuit.playerhub.playerapi;

import com.intuit.playerhub.playerapi.entities.Player;
import com.intuit.playerhub.playerapi.repository.PlayerRepository;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = { PlayerApiApplication.class, TestPlayerApiApplication.class })
public class PlayerRepositoryIntegrationTests {
  @Autowired
  PlayerRepository repository;

  @BeforeEach
  @AfterEach
  public void clearDb() {
    repository.deleteAll();
  }

  @Test
  void findPlayerById() {

    var player = new Player();
    String playerId = UUID.randomUUID().toString();
    player.setPlayerId(playerId);

   repository.save(player);

    var storedPlayer = repository.findById(playerId);

    Assertions.assertEquals(1, repository.count());
    Assertions.assertEquals(playerId, storedPlayer.get().getPlayerId());
  }
}
