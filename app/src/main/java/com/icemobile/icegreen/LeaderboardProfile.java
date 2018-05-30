package com.icemobile.icegreen;

/**
 * Created by andrew.cameron on 27/03/2018.
 */

public class LeaderboardProfile {
    private String username;
    private  Long numberOfLeaves;
    private int iD;

    public LeaderboardProfile() {

    }

    public LeaderboardProfile(int iD, String username, Long numberOfLeaves) {
        this.username = username;
        this.numberOfLeaves = numberOfLeaves;
        this.iD = iD;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getNumberOfLeaves() {
        return numberOfLeaves;
    }

    public void setNumberOfLeaves(Long numberOfLeaves) {
        this.numberOfLeaves = numberOfLeaves;
    }

    public int getiD() {
        return iD;
    }
}
