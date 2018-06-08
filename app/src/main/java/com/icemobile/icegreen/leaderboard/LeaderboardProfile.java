package com.icemobile.icegreen.leaderboard;

/**
 * Created by andrew.cameron on 27/03/2018.
 */

public class LeaderboardProfile {
    private String username, firstName, lastName;
    private  Long numberOfLeaves;
    private Long monPresent, tuePresent, wedPresent, thuPresent, friPresent;


    public LeaderboardProfile() {

    }

    public LeaderboardProfile(String username, Long numberOfLeaves, String firstName, String lastName, Long monPresent, Long tuePresent, Long wedPresent, Long thuPresent, Long friPresent) {
        this.username = username;
        this.numberOfLeaves = numberOfLeaves;
        this.firstName = firstName;
        this.lastName = lastName;
        this.monPresent = monPresent;
        this.tuePresent = tuePresent;
        this.wedPresent = wedPresent;
        this.thuPresent = thuPresent;
        this.friPresent = friPresent;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getMonPresent() {
        return monPresent;
    }

    public void setMonPresent(Long monPresent) {
        this.monPresent = monPresent;
    }

    public Long getTuePresent() {
        return tuePresent;
    }

    public void setTuePresent(Long tuePresent) {
        this.tuePresent = tuePresent;
    }

    public Long getWedPresent() {
        return wedPresent;
    }

    public void setWedPresent(Long wedPresent) {
        this.wedPresent = wedPresent;
    }

    public Long getThuPresent() {
        return thuPresent;
    }

    public void setThuPresent(Long thuPresent) {
        this.thuPresent = thuPresent;
    }

    public Long getFriPresent() {
        return friPresent;
    }

    public void setFriPresent(Long friPresent) {
        this.friPresent = friPresent;
    }

}
