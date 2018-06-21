package com.icemobile.icegreen.leaderboard;

/**
 * Created by andrew.cameron on 27/03/2018.
 */

public class LeaderboardProfile {
    private String email, password, name;
    private  Long numberOfLeaves;
    private Boolean monPresent, tuePresent, wedPresent, thuPresent, friPresent;

    public LeaderboardProfile(String email, Long numberOfLeaves, String name, Boolean monPresent, Boolean tuePresent, Boolean wedPresent, Boolean thuPresent, Boolean friPresent) {
        this.email = email;
        this.numberOfLeaves = numberOfLeaves;
        this.name = name;
        this.monPresent = monPresent;
        this.tuePresent = tuePresent;
        this.wedPresent = wedPresent;
        this.thuPresent = thuPresent;
        this.friPresent = friPresent;
    }

    public String getUsername() {
        return email;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    public Long getNumberOfLeaves() {
        return numberOfLeaves;
    }

    public void setNumberOfLeaves(Long numberOfLeaves) {
        this.numberOfLeaves = numberOfLeaves;
    }

    public String getName() {
        return name;
    }

    public void setName(String lastName) {
        this.name = lastName;
    }

    public Boolean getMonPresent() {
        return monPresent;
    }

    public void setMonPresent(Boolean monPresent) {
        this.monPresent = monPresent;
    }

    public Boolean getTuePresent() {
        return tuePresent;
    }

    public void setTuePresent(Boolean tuePresent) {
        this.tuePresent = tuePresent;
    }

    public Boolean getWedPresent() {
        return wedPresent;
    }

    public void setWedPresent(Boolean wedPresent) {
        this.wedPresent = wedPresent;
    }

    public Boolean getThuPresent() {
        return thuPresent;
    }

    public void setThuPresent(Boolean thuPresent) {
        this.thuPresent = thuPresent;
    }

    public Boolean getFriPresent() {
        return friPresent;
    }

    public void setFriPresent(Boolean friPresent) {
        this.friPresent = friPresent;
    }

}
