package com.intuit.playerhub.playerapi.repository;

import com.intuit.playerhub.playerapi.entities.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PlayerRepository extends PagingAndSortingRepository<Player, String>, CrudRepository<Player, String> {
}
