package com.mariofernandes.javapoc.sep.dpk05;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DPK05Impl7 {
    record Outcome(int p1Points, int p2Points, String winnerMessage) {}

    private int matchesPlayed;

    public static final String[] PLAYERS = {"John", "Paul", "George", "Ringo"};

    private static final Map<String, Integer> POWER = Map.of(
            "John", 100,
            "Paul", 90,
            "George", 80,
            "Ringo", 70
    );

    private static final Map<Integer, Outcome> RULES = Map.of(
            -1, new Outcome(-5, 10, "P2"),
            0, new Outcome(5, 5, "DRAW"),
            1, new Outcome(10, -5, "P1")
    );

    private final Map<String, Integer> leaderboard;

    public DPK05Impl7() {
        matchesPlayed = 0;
        leaderboard = new HashMap<>(Map.of(
                "John", 0,
                "Paul", 0,
                "George", 0,
                "Ringo", 0
        ));
    }

    private void resetGame() {
        System.out.println("Game finished, resetting leaderboard and matchesPlayed.\n\n");
        matchesPlayed = 0;
        leaderboard.replaceAll((_, _) -> 0);
    }

    private int comparePower(String playerOne, String playerTwo) {
        return POWER.get(playerOne).compareTo(POWER.get(playerTwo));
    }

    private String resolveWinner(Outcome outcome, String playerOne, String playerTwo) {
        return Map.of(
                "P1", playerOne,
                "P2", playerTwo,
                "DRAW", "It was a draw!"
        ).get(outcome.winnerMessage());
    }

    private void applyPoints(String playerOne, String playerTwo, Outcome outcome) {
        leaderboard.compute(playerOne, (_, currentValue) -> currentValue + outcome.p1Points());
        leaderboard.compute(playerTwo, (_, currentValue) -> currentValue + outcome.p2Points());
    }

    private String formatLeaderboard() {
        return leaderboard.entrySet().stream()
                .map(entry -> "\t" + entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(",\n", "leaderboard -> {\n", "\n}"));
    }

    public String play(String playerOne, String playerTwo) {
        var resultMostPowerful = comparePower(playerOne, playerTwo);
        var outcome = RULES.get(resultMostPowerful);

        applyPoints(playerOne, playerTwo, outcome);

        var winner = resolveWinner(outcome, playerOne, playerTwo);

        System.out.println("play(\"" + playerOne + "\", \"" + playerTwo + "\") -> \"" + winner + "\"");
        System.out.println(formatLeaderboard());

        Optional.of(++matchesPlayed)
                .filter(mp -> mp > 2)
                .ifPresent(_ -> resetGame());

        return winner;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 05 - Implementation 07 <--");
        DPK05Impl7 dpk05Impl7 = new DPK05Impl7();

        var winner1 = dpk05Impl7.play(DPK05Impl7.PLAYERS[0], DPK05Impl7.PLAYERS[1]);
        var winner2 = dpk05Impl7.play(DPK05Impl7.PLAYERS[2], DPK05Impl7.PLAYERS[3]);
        dpk05Impl7.play(winner1, winner2);
        dpk05Impl7.play(DPK05Impl7.PLAYERS[0], DPK05Impl7.PLAYERS[1]);
    }
}

