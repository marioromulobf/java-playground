package com.mariofernandes.javapoc.sep.dpk05;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DPK05Impl5 {
    private int matchesPlayed;
    private final Map<String, Integer> power;
    private final Map<Integer, int[]> points;
    private final Map<String, Integer> leaderboard;

    public DPK05Impl5() {
        matchesPlayed = 0;
        power = Map.of(
                "John", 100,
                "Paul", 90,
                "George", 80,
                "Ringo", 70
        );
        points = Map.of(
                -1, new int[]{-5, 10},
                0, new int[]{5, 5},
                1, new int[]{10, -5}
        );
        leaderboard = new HashMap<>(Map.of(
                "John", 0,
                "Paul", 0,
                "George", 0,
                "Ringo", 0
        ));
    }

    public static final String[] PLAYERS = {"John", "Paul", "George", "Ringo"};

    private void resetGame() {
        System.out.println("Game finished, resetting leaderboard and matchesPlayed.\n\n");
        matchesPlayed = 0;
        leaderboard.replaceAll((_, _) -> 0);
    }

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
        Optional.of(matchesPlayed)
                .filter(mp -> mp > 2)
                .ifPresent(_ -> resetGame());

        return winner;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 05 - Implementation 05 <--");
        DPK05Impl5 dpk05Impl5 = new DPK05Impl5();

        var winner1 = dpk05Impl5.play(DPK05Impl5.PLAYERS[0], DPK05Impl5.PLAYERS[1]);
        var winner2 = dpk05Impl5.play(DPK05Impl5.PLAYERS[2], DPK05Impl5.PLAYERS[3]);
        dpk05Impl5.play(winner1, winner2);
        dpk05Impl5.play(DPK05Impl5.PLAYERS[0], DPK05Impl5.PLAYERS[1]);
    }
}

