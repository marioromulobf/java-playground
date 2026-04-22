package com.mariofernandes.javapoc.sep.dpk05;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DPK05Impl1 {
    Map<String, Integer> power = Map.of(
            "John", 100,
            "Paul", 90,
            "George", 80,
            "Ringo", 70
    );

    Map<String, Integer> leaderboard = new HashMap<>(Map.of(
            "John", 0,
            "Paul", 0,
            "George", 0,
            "Ringo", 0
    ));

    public Integer lookupPower(String name) {
        return power.get(name);
    }

    public String getMostPowerful(String playerOne, String playerTwo) {
        var result = lookupPower(playerOne).compareTo(lookupPower(playerTwo));
        return result == 0 ? "-" : (result > 0 ? playerOne : playerTwo);
    }

    public String play(String playerOne, String playerTwo) {
        var winner = getMostPowerful(playerOne, playerTwo);
        var pointsP1 = leaderboard.get(playerOne);
        var pointsP2 = leaderboard.get(playerTwo);

        if (winner.equals("-")) {
            winner = "It was a draw!";
            pointsP1 += 5;
            pointsP2 += 5;
        } else if (winner.equals(playerOne)) {
            pointsP1 += 10;
            pointsP2 -= 5;
        } else {
            pointsP1 -= 5;
            pointsP2 += 10;
        }
        System.out.println("play(\"" + playerOne + "\", \"" + playerTwo + "\") -> \"" + winner + "\"");

        leaderboard.put(playerOne, pointsP1);
        leaderboard.put(playerTwo, pointsP2);

        var log = leaderboard.entrySet().stream()
                .map(entry -> "\t" + entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(",\n", "leaderboard -> {\n", "\n}"));

        System.out.println(log);

        return winner;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 05 - Implementation 01 <--");
        DPK05Impl1 dkp05Impl1 = new DPK05Impl1();

        var result = dkp05Impl1.play("John", "Paul");
        dkp05Impl1.play("John", "Ringo");
    }
}

