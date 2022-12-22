package com.example.playerapplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.playerapplication.Dao.PlayersDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlayerApplication {
	private static final Logger log = LoggerFactory.getLogger(PlayerApplication.class);
	private static PlayersDao playersDao;

	public PlayerApplication(PlayersDao playersDao) {
		this.playersDao = playersDao;
	}

	public static void main(String[] args) {

		//ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
	//	PlayersDao playersDao = context.getBean("playersDao", PlayersDao.class);
		SpringApplication.run(PlayerApplication.class, args);


		/*log.info("/n List of all players --------");
		List<Players> playersList = playersDao.findALLPlayers();
		playersList.forEach(System.out::println);

		System.out.println("/n Create players------------ ");
		Players players = new Players(1, "Viart kohli", 37, "Tennis", 189);
		int result = playersDao.createPlayers(players);
		log.info("player added " + result);


		System.out.println("/n One player where id = 1-------------");
		Optional<Players> onePlayer = playersDao.fetchPlayerById(1);
		log.info("Player is fetched--" + onePlayer);

		System.out.println("/n Sports name of player is updated where id = 4--------------");
		playersDao.updateSportsNameById("Cricket", 4);

		players.setPlayer_name("KL Rahul");
		players.setAge(29);
		players.setSports_name("Cricket");
		players.setMatches(85);
		playersDao.updatePlayersById(players, 4);

		playersDao.deletePlayerById(1);

		System.out.println("/n List of all players --------");
		List<Players> playersList1 = playersDao.findALLPlayers();
		playersList1.forEach(System.out::println);
*/
	}
}


