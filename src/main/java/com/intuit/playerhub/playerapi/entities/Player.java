package com.intuit.playerhub.playerapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Player {
  @Id
  private String playerId;

  private int birthYear;
  private int birthMonth;
  private int birthDay;
  private int deathYear;
  private int deathMonth;
  private int deathDay;
  private int weight;
  private int height;
  private String birthCountry;
  private String birthState;
  private String birthCity;
  private String deathCountry;
  private String deathState;
  private String deathCity;
  private String nameFirst;
  private String nameLast;
  private String nameGiven;
  private LocalDate debut;
  private LocalDate finalGame;
  private String retroID;
  private String bbrefID;
  private String bats;
  @Column(name = "throws")
  private String throwing;



}
