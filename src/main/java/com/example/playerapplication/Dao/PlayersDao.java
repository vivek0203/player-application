package com.example.playerapplication.Dao;

import com.example.playerapplication.entity.Players;


import java.util.List;
import java.util.Optional;

public interface PlayersDao {

    List<Players> findALLPlayers();

    Players createPlayers(Players players);

    Optional<Players> fetchPlayerById(Integer id);

    String updateSportsNameById(String newSportsName , Integer id);


    String deletePlayerById(Integer id);





}
