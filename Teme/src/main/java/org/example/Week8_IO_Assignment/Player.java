package org.example.Week8_IO_Assignment;

public class Player {
    public String name;
    public int number;
    public String country;
    public String time;
    public String shootsR1;
    public String shootsR2;
    public String shootsR3;
    public int countMissedShots;
    String finalTime;

    public Player(String name, String number, String country, String time, String shootsR1, String shootsR2, String shootsR3) {
        this.name = name;
        this.number = Integer.parseInt(number);
        this.country = country;
        this.time = time;
        this.shootsR1 = shootsR1;
        this.shootsR2 = shootsR2;
        this.shootsR3 = shootsR3;
        this.countMissedShots = missedShotsInSeconds();
    }

    public int getCountMissedShots(String shots) {
        return (int) shots.chars().filter(ch -> ch == 'o').count();
    }


    public int missedShotsInSeconds() {
        return (getCountMissedShots(shootsR1) + getCountMissedShots(shootsR2) + getCountMissedShots(shootsR3)) * 10;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getCountry() {
        return country;
    }

    public String getTime() {
        return time;
    }

    public String getShootsR1() {
        return shootsR1;
    }

    public String getShootsR2() {
        return shootsR2;
    }

    public String getShootsR3() {
        return shootsR3;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", country='" + country + '\'' +
                ", time='" + time + '\'' +
                ", shootsR1='" + shootsR1 + '\'' +
                ", shootsR2='" + shootsR2 + '\'' +
                ", shootsR3='" + shootsR3 + '\'' +
                '}';
    }

    public void setTime(String time) {
        this.time = time;
    }
}
