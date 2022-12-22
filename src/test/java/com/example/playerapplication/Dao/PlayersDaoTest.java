package com.example.playerapplication.Dao;

import com.example.playerapplication.PlayerApplication;
import com.example.playerapplication.entity.Players;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = PlayerApplication.class)
public class PlayersDaoTest {
    private static final Logger log = LoggerFactory.getLogger(com.example.playerapplication.Dao.PlayersDaoTest.class);
    private ClassPathXmlApplicationContext context;
    private PlayersDao playersDao;

   @BeforeTest
    public void initialize() {
        log.debug("Initializing Test class..");
        context = new ClassPathXmlApplicationContext("context.xml");
        playersDao  = context.getBean("playersDao",PlayersDao.class);
        this.playersDao = context.getBean(PlayersDao.class);
    }
    @AfterTest
    public void close() {
        if (context != null) {
            context.close();
        }
    }

    @Test
    public void givenPlayersObj_whenListPlayers_shouldReturnPlayersList(){
        log.info("executing test givenPlayersObj_whenListPlayers_shouldReturnPlayersList()...");
        List<Players> playersList = playersDao.findALLPlayers();
        assertThat(playersList).isNotNull();
        assertThat(playersList.size()).isEqualTo(3);
    }
    @Test
    public void givenPlayersObj_whenCreatePlayers_shouldReturnCrated(){
        log.info("Executing test givenPlayersObj_whenCreatePlayers_shouldReturnCrated()... ");
        Players savePlayer = playersDao.createPlayers(new Players("Shreyash Iyer",26,"Cricket",86));
        assertThat(savePlayer).isNotNull();
        assertThat(savePlayer.getPlayer_name()).isEqualTo("Shreyash Iyer");
        assertThat(savePlayer.getMatches()).isEqualTo(86);
        assertThat(savePlayer.getSports_name()).isEqualTo("Cricket");
        assertThat(savePlayer.getAge()).isEqualTo(26);


    }
    @Test
    public void givenPlayersObj_whenFetchPlayerById_shouldReturnPlayer(){
        log.info("Executing test givenPlayersObj_whenFetchPlayerById_shouldReturnPlayer()... ");
        Players playerById = playersDao.fetchPlayerById(2).get();
        assertThat(playerById).isNotNull();
        assertThat(playerById.getId()).isEqualTo(2);
        assertThat(playerById.getMatches()).isEqualTo(215);

    }
    @Test
    public void givenPlayersObj_whenUpdateSportsNameById_thenShouldReturnUpdatedPlayer() {
        log.info("Executing test givenPlayersObj_whenUpdateSportsNameById_thenShouldReturnUpdatedPlayer()...");
        String updateSportsName = playersDao.updateSportsNameById("TableTennis", 1);
        assertThat(updateSportsName).isNotNull();
        assertThat(updateSportsName).isEqualTo(1);
    }
    @Test
    public void givenPlayersObj_whenDeletePlayer_thenRemovePlayer(){
        log.info("Executing test givenPlayersObj_whenDeletePlayer_thenRemovePlayer()...");
        playersDao.deletePlayerById(3);
        Optional<Players> optionalPlayers = playersDao.fetchPlayerById(3);
        assertThat(optionalPlayers).isEmpty();

    }

}
