package com.intuit.playerhub.playerapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Player {
  @Id
  private String playerId;

  private int birthYear, birthMonth, birthDay, deathYear, deathMonth, deathDay;
  private String birthCountry, birthState, birthCity;
  private Date debut, finalGame;
  private String retroID, bbrefID;



}
