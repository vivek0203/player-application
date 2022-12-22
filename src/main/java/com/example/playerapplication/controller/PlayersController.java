package com.example.playerapplication.controller;

import com.example.playerapplication.Dao.PlayersDao;
import com.example.playerapplication.entity.Players;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PlayersController {
    @Autowired
     PlayersDao playersDao;

    @GetMapping("/players")
    public List<Players> findALLPlayers(){
        return playersDao.findALLPlayers();
    }
    @PostMapping("/players")
    public Players createPlayers(@RequestBody Players players){
        return playersDao.createPlayers(players);
    }
    @GetMapping("player")
    public Optional<Players> fetchPlayerById(@RequestParam("id") Integer id){
        return playersDao.fetchPlayerById(id);
    }
    @PutMapping("/players/{id}")
    public String updateSportsNameById(@RequestParam String newSportsName , @PathVariable Integer id){
        return playersDao.updateSportsNameById(newSportsName,id);

    }
    @DeleteMapping("/player")
    public void deletePlayerById(@RequestParam Integer id){

        playersDao.deletePlayerById(id);
    }



}
