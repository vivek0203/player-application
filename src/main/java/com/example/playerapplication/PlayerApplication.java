package com.example.playerapplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.playerapplication.Dao.PlayersDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class PlayerApplication {
	private static final Logger log = LoggerFactory.getLogger(PlayerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(PlayerApplication.class, args);

	}
}


