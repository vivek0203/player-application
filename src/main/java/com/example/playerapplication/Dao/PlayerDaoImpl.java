package com.example.playerapplication.Dao;

import com.example.playerapplication.entity.Players;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("deprecation")
@Repository
public  class PlayerDaoImpl implements PlayersDao {
    private static final String SUCCESS_STATUS = "success";
    private static final String FAILURE_STATUS = "failure";
    RowMapper<Players> rowMapper =(rs, rowNum) -> {
        Players players = new Players();
        players.setId(rs.getInt("id"));
        players.setPlayer_name(rs.getString("player_name"));
        players.setAge(rs.getInt("age"));
        players.setSports_name(rs.getString("sports_name"));
        players.setMatches(rs.getInt("matches"));
        return players;

    };

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    private static final Logger log = LoggerFactory.getLogger(PlayerDaoImpl.class);
    @Override
    public List<Players> findALLPlayers() {
        log.info("Executing createOperation()..");
        String q = "Select * from players";
        log.debug(" Query : {} ",q);
        log.info("Players list is shown ");
        return jdbcTemplate.query(q,rowMapper);
    }
    @Override
    public Players createPlayers(Players players) {
        log.info("Executing createOperation()..");
        try {

            if (players.getId() != null && players.getPlayer_name() != null && players.getAge() != null && players.getSports_name() != null && players.getMatches() != null) {

                String query = "insert into players (id,player_name,age,sports_name,matches) values(?,?,?,?,?)";
                log.debug("Executing create Query : {} ", query);
                log.debug("Parameters : {id : {}, player_name : {}, age : {}, sorts_name : {} and matches : {} } ", players.getPlayer_name(), players.getAge(), players.getSports_name(), players.getMatches());
                jdbcTemplate.update
                        (query, players.getId(), players.getPlayer_name(), players.getAge(), players.getSports_name(), players.getMatches());
                log.info("Player " + players);
            } else {
                log.error("Required fields are be empty...");
                throw new IllegalArgumentException("Required fields are be empty...");
            }
            return players;
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Optional<Players> fetchPlayerById(Integer id) {
            log.info("Executing fetchPlayerById..");
            Players players  =null;
            try {
                if (id != null) {
                    String query = "Select * from players where id = ?";
                    log.debug(" Query : {} ", query);
                    log.debug("Parameters : { id : {} } ", id);
                    players = jdbcTemplate.queryForObject(query,new Object[]{id},rowMapper);
                } else {
                    log.error("Required arguments are empty...");
                    throw new IllegalArgumentException("Required arguments are empty...");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return Optional.ofNullable(players);
        }
    @Override
    public String updateSportsNameById(String newSportsName, Integer id) {
        log.info("Executing updateSportsNameById..");
        try {

                if (id != null) {
                    String query = "Update players set sports_name = ? where id = ?";
                    log.debug("Executing delete Query : {} ", query );
                    log.debug("Parameters : { id : {}, sports_name : {} } ",id,newSportsName);
                    this.jdbcTemplate.update(query, newSportsName, id);
                    return SUCCESS_STATUS;
                }else {
                    log.error("Required fields are be empty...");
                    return FAILURE_STATUS;
                }
    } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String deletePlayerById(Integer id) {
        log.info("Executing deleteOperation()..");
        try {
            if (id != null) {
                String query = "delete from players where id= ?";
                log.debug("Executing delete Query : {} ", query );
                log.debug("Parameters : { id : {} } ",id);
                this.jdbcTemplate.update(query, id);
                return SUCCESS_STATUS;
            } else {
                log.error("Required fields are be empty...");
                return FAILURE_STATUS;
            }
        } catch (DataAccessException e) {
            log.error("Error occurred while deleting data in dao.. ", e);
            throw new IllegalArgumentException("Error occurred while deleting data in dao.. ");
        }
    }
}
