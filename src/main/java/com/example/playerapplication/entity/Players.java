package com.example.playerapplication.entity;


public class Players {
    private Integer id;
    private String player_name;
    private Integer age;
    private String sports_name;
    private Integer matches;

    public Players() {
        super();
    }

    public Players(String player_name, Integer age, String sports_name, Integer matches) {
        this.player_name = player_name;
        this.age = age;
        this.sports_name = sports_name;
        this.matches = matches;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSports_name() {
        return sports_name;
    }

    public void setSports_name(String sports_name) {
        this.sports_name = sports_name;
    }

    public Integer getMatches() {
        return matches;
    }

    public void setMatches(Integer matches) {
        this.matches = matches;
    }
    public Players(Integer id,String player_name, Integer age, String sports_name,Integer matches) {
        this.id = id;
        this.player_name = player_name;
        this.age = age;
        this.sports_name = sports_name;
        this.matches = matches;
    }
    @Override
    public String toString() {
        return "Players{" +
                "id=" + id +
                ", player_name='" + player_name + '\'' +
                ", age=" + age +
                ", sports_name='" + sports_name + '\'' +
                ", Matches='" + matches + '\'' +
                '}';
    }

}