package com.example.entity;

import java.io.Serializable;

public class PlayerInfo implements Serializable {

    private Long id;
    /**
     * 昵称
     */
    private String playerName;
    /**
     * 等级
     */
    private Integer playerLevel;
    /**
     * 所在区
     */
    private String playerRegion;
    /**
     *  英雄数量
     */
    private Integer availableHeros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(Integer playerLevel) {
        this.playerLevel = playerLevel;
    }

    public String getPlayerRegion() {
        return playerRegion;
    }

    public void setPlayerRegion(String playerRegion) {
        this.playerRegion = playerRegion;
    }

    public Integer getAvailableHeros() {
        return availableHeros;
    }

    public void setAvailableHeros(Integer availableHeros) {
        this.availableHeros = availableHeros;
    }
}
