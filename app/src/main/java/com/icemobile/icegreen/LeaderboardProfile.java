package com.icemobile.icegreen;

/**
 * Created by andrew.cameron on 27/03/2018.
 */

public class LeaderboardProfile {
    private String username, numberOfLeaves, ranking;

    public LeaderboardProfile() {

    }

    public LeaderboardProfile(String username, String numberOfLeaves, String ranking) {
        this.username = username;
        this.numberOfLeaves = numberOfLeaves;
        this.ranking = ranking;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNumberOfLeaves() {
        return numberOfLeaves;
    }

    public void setNumberOfLeaves(String numberOfLeaves) {
        this.numberOfLeaves = numberOfLeaves;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }
}
