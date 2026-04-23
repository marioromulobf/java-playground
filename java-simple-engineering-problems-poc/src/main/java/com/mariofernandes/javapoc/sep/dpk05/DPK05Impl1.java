package com.mariofernandes.javapoc.sep.dpk05;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DPK05Impl1 {

    private int matchesPlayed;

    public DPK05Impl1() {
        matchesPlayed = 0;
    }

    public static final String[] PLAYERS = {"John", "Paul", "George", "Ringo"};
    Map<String, Integer> power = Map.of(
            "John", 100,
            "Paul", 90,
            "George", 80,
            "Ringo", 70
    );

    Map<Integer, int[]> points = Map.of(
            -1, new int[]{-5, 10},
            0, new int[]{5, 5},
            1, new int[]{10, -5}
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

    public int getMostPowerful(String playerOne, String playerTwo) {
        return lookupPower(playerOne).compareTo(lookupPower(playerTwo));
    }

    public String play(String playerOne, String playerTwo) {
        var resultMostPowerful = getMostPowerful(playerOne, playerTwo);
        var finalPoints = points.get(resultMostPowerful);
        var pointsP1 = leaderboard.get(playerOne) + finalPoints[0];
        var pointsP2 = leaderboard.get(playerTwo) + finalPoints[1];
        var options = Map.of(
                -1, playerTwo,
                0, "It was a draw!",
                1, playerOne
        );

        var winner = options.get(resultMostPowerful);
        System.out.println("play(\"" + playerOne + "\", \"" + playerTwo + "\") -> \"" + winner + "\"");

        leaderboard.put(playerOne, pointsP1);
        leaderboard.put(playerTwo, pointsP2);

        var log = leaderboard.entrySet().stream()
                .map(entry -> "\t" + entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(",\n", "leaderboard -> {\n", "\n}"));

        System.out.println(log);

        matchesPlayed++;

        if (matchesPlayed > 2) {
            matchesPlayed = 0;
            leaderboard.replaceAll((k, v) -> 0);
        }

        return winner;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 05 - Implementation 01 <--");
        DPK05Impl1 dkp05Impl1 = new DPK05Impl1();

        var winner1 = dkp05Impl1.play(DPK05Impl1.PLAYERS[0], DPK05Impl1.PLAYERS[1]);
        var winner2 = dkp05Impl1.play(DPK05Impl1.PLAYERS[2], DPK05Impl1.PLAYERS[3]);
        var finalWinner = dkp05Impl1.play(winner1, winner2);
    }
}

