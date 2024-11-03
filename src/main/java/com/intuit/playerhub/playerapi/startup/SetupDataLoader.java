package com.intuit.playerhub.playerapi.startup;

import com.intuit.playerhub.playerapi.entities.Player;
import com.intuit.playerhub.playerapi.repository.PlayerRepository;
import java.io.FileReader;
import java.io.Reader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class is responsible for initializing the database with players from CSV file on application startup
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
  private final PlayerRepository playerRepository;
  private boolean alreadySetup = false;

  @Override
  @Transactional
  public void onApplicationEvent(ContextRefreshedEvent event) {
    if (alreadySetup || playerRepository.findAll().iterator().hasNext()) {
      return;
    }
    insertPlayersFromCSV();
    alreadySetup = true;
  }

  private void insertPlayersFromCSV() {
    try (Reader in = new FileReader(new ClassPathResource("player.csv").getFile())) {
      CSVFormat.RFC4180.builder()
          .setAllowMissingColumnNames(true).setHeader("playerID", "birthYear", "birthMonth", "birthDay",
              "birthCountry", "birthState", "birthCity", "deathYear", "deathMonth", "deathDay",
              "deathCountry", "deathState", "deathCity", "nameFirst", "nameLast", "nameGiven", "weight", "height",
              "bats", "throws", "debut", "finalGame", "retroID", "bbrefID")
          .setSkipHeaderRecord(true).build().parse(in).forEach(csvRecord -> {
            Player player = new Player();
            player.setPlayerId(csvRecord.get("playerID"));

            player.setBirthYear(NumberUtils.toInt(csvRecord.get("birthYear")));
            player.setDeathYear(NumberUtils.toInt(csvRecord.get("deathYear")));
            player.setBirthMonth(NumberUtils.toInt(csvRecord.get("birthMonth")));
            player.setDeathMonth(NumberUtils.toInt(csvRecord.get("deathMonth")));
            player.setBirthDay(NumberUtils.toInt(csvRecord.get("birthDay")));
            player.setDeathDay(NumberUtils.toInt(csvRecord.get("deathDay")));

            player.setBirthCountry(csvRecord.get("birthCountry"));
            player.setDeathCountry(csvRecord.get("deathCountry"));
            player.setBirthState(csvRecord.get("birthState"));
            player.setDeathState(csvRecord.get("deathState"));
            player.setBirthCity(csvRecord.get("birthCity"));
            player.setDeathCity(csvRecord.get("deathCity"));

            player.setNameFirst(csvRecord.get("nameFirst"));
            player.setNameLast(csvRecord.get("nameLast"));
            player.setNameGiven(csvRecord.get("nameGiven"));

            player.setWeight(NumberUtils.toInt(csvRecord.get("weight")));
            player.setWeight(NumberUtils.toInt(csvRecord.get("height")));

            player.setBats(csvRecord.get("bats"));
            player.setThrowing(csvRecord.get("throws"));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String debut = csvRecord.get("debut");
            player.setDebut(StringUtils.isNotBlank(debut) ? LocalDate.parse(debut, formatter) : null);
            String finalGame = csvRecord.get("finalGame");
            player.setFinalGame(StringUtils.isNotBlank(finalGame) ? LocalDate.parse(finalGame, formatter) : null);

            player.setRetroID(csvRecord.get("retroID"));
            player.setBbrefID(csvRecord.get("bbrefID"));


            playerRepository.save(player);
            log.info("Loaded player: {}", player);
          });
    } catch (Exception e) {
      log.error("Unable to read CSV file", e);
    }
  }
}