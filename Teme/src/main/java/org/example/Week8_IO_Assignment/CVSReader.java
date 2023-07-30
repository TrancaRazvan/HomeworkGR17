package org.example.Week8_IO_Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class CVSReader extends BufferedReader {
    public CVSReader(Reader in) {
        super(in);
    }

    public String readAthletes() throws IOException {
        String line = readLine();

        List<Player> playerList = new ArrayList<>();
        List<Player> playerListCopy = new ArrayList<>();
        List<List<Player>> lists = new ArrayList<>();


        String[] tokens;

        int timeInSeconds = 0;
        while (line != null) {
            tokens = line.split(",");
            playerList.add(new Player(tokens[1], tokens[0], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]));


            String time = tokens[3];
            String[] timeTokens = time.split(":");
            timeInSeconds = Integer.parseInt(timeTokens[0]) * 60 + Integer.parseInt(timeTokens[1]);


            String shootsRoundOne = tokens[4];
            char[] shootRoundOne = shootsRoundOne.toCharArray();
            int penalty = 0;
            for (char shoot : shootRoundOne) {
                if (shoot == 'o') {
                    penalty = penalty + 10;
                }
            }
            String shootsRoundTwo = tokens[5];
            char[] shootRoundTwo = shootsRoundTwo.toCharArray();
            for (char shoot : shootRoundTwo) {
                if (shoot == 'o') {
                    penalty = penalty + 10;
                }
            }
            String shootsRoundThree = tokens[6];
            char[] shootRoundThree = shootsRoundThree.toCharArray();
            for (char shoot : shootRoundThree) {
                if (shoot == 'o') {
                    penalty = penalty + 10;
                }
            }

            timeInSeconds += penalty;
            int minutes = timeInSeconds /60;
            int seconds = timeInSeconds%60;
            String timeBuilder = minutes + ":" + seconds;

            playerListCopy.add(new Player(tokens[1], tokens[0], tokens[2], timeBuilder, tokens[4], tokens[5], tokens[6]));
            lists.add(playerListCopy);
            lists.add(playerList);

            line = readLine();

        }


        Comparator<Player> timeComparator = Comparator.comparing(Player::getTime);
        Collections.sort(playerListCopy, timeComparator);

        Player winner = playerList.get(0);
        Player winnerCopy = playerListCopy.get(0);

        Player second = playerList.get(1);
        Player secondCopy = playerListCopy.get(1);

        Player third = playerList.get(2);
        Player thirdCopy = playerListCopy.get(2);


        return  "Winner - " + winnerCopy.getName() + " " +winnerCopy.getTime() + " (" + timeReturner(winnerCopy, winner, playerList) + " + " + winnerCopy.missedShotsInSeconds() + ")" + "\n" +
                "Runner-up - " + secondCopy.getName() + " " +secondCopy.getTime() + " (" + timeReturner(secondCopy, second, playerList) + " + " + secondCopy.missedShotsInSeconds() + ")" + "\n" +
                "Third Place - " + thirdCopy.getName() + " " +thirdCopy.getTime() + " (" + timeReturner(thirdCopy, third, playerList) + " + " + thirdCopy.missedShotsInSeconds() + ")";
    }
public String timeReturner(Player p1, Player p2, List<Player> playerList) {
    String timp = null;
    for (Player player : playerList) {
        if (p1.getName().equals(player.getName())) {
            timp = player.getTime();
            return timp;
        }
    }
    return timp;
}
}
