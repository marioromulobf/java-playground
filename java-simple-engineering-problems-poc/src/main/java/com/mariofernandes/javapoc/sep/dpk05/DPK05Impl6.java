package com.mariofernandes.javapoc.sep.dpk05;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DPK05Impl6 {
    private int matchesPlayed;
    private final Map<String, Integer> power;
    private final Map<Integer, int[]> points;
    private final Map<String, Integer> leaderboard;

    public DPK05Impl6() {
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

    private int comparePower(String playerOne, String playerTwo) {
        return power.get(playerOne).compareTo(power.get(playerTwo));
    }

    private String resolveWinner(int result, String playerOne, String playerTwo) {
        return switch (result) {
            case -1 -> playerTwo;
            case 1 -> playerOne;
            default -> "It was a draw!";
        };
    }

    private void applyPoints(String playerOne, String playerTwo, int[] points) {
        leaderboard.compute(playerOne, (_, currentValue) -> currentValue + points[0]);
        leaderboard.compute(playerTwo, (_, currentValue) -> currentValue + points[1]);
    }

    private String formatLeaderboard() {
        return leaderboard.entrySet().stream()
                .map(entry -> "\t" + entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(",\n", "leaderboard -> {\n", "\n}"));
    }

    public String play(String playerOne, String playerTwo) {
        var resultMostPowerful = comparePower(playerOne, playerTwo);
        var finalPoints = points.get(resultMostPowerful);

        applyPoints(playerOne, playerTwo, finalPoints);

        var winner = resolveWinner(resultMostPowerful, playerOne, playerTwo);

        System.out.println("play(\"" + playerOne + "\", \"" + playerTwo + "\") -> \"" + winner + "\"");
        System.out.println(formatLeaderboard());

        Optional.of(++matchesPlayed)
                .filter(mp -> mp > 2)
                .ifPresent(_ -> resetGame());

        return winner;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 05 - Implementation 06 <--");
        DPK05Impl6 dpk05Impl6 = new DPK05Impl6();

        var winner1 = dpk05Impl6.play(DPK05Impl6.PLAYERS[0], DPK05Impl6.PLAYERS[1]);
        var winner2 = dpk05Impl6.play(DPK05Impl6.PLAYERS[2], DPK05Impl6.PLAYERS[3]);
        dpk05Impl6.play(winner1, winner2);
        dpk05Impl6.play(DPK05Impl6.PLAYERS[0], DPK05Impl6.PLAYERS[1]);
    }
}

