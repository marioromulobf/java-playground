package com.mariofernandes.javapoc.sep.dpk05;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class DPK05Impl9 {
    record Outcome(int p1Points, int p2Points, BiFunction<String, String, String> winnerFn) {}

    private int matchesPlayed;

    public static final String[] PLAYERS = {"John", "Paul", "George", "Ringo"};

    private static final Map<String, Integer> POWER = Map.of(
            "John", 100,
            "Paul", 90,
            "George", 80,
            "Ringo", 70
    );

    private static final Map<Integer, Outcome> RULES = Map.of(
            -1, new Outcome(-5, 10, (_, playerTwo) -> playerTwo),
            0, new Outcome(5, 5, (_, _) -> "It was a draw!"),
            1, new Outcome(10, -5, (playerOne, _) -> playerOne)
    );

    private final Map<String, Integer> leaderboard;

    public DPK05Impl9() {
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
        return getOrThrow(POWER, playerOne)
                .compareTo(getOrThrow(POWER, playerTwo));
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

    private void logMatch(String playerOne, String playerTwo, String winner) {
        System.out.printf("play(\"%s\", \"%s\") -> \"%s\"", playerOne, playerTwo, winner);
        System.out.println(formatLeaderboard());
    }

    private <K, V> V getOrThrow(Map<K, V> map, K key) {
        return Optional.ofNullable(map.get(key)).orElseThrow();
    }

    public String play(String playerOne, String playerTwo) {
        var resultMostPowerful = comparePower(playerOne, playerTwo);
        var outcome = getOrThrow(RULES, resultMostPowerful);

        applyPoints(playerOne, playerTwo, outcome);

        var winner = outcome.winnerFn().apply(playerOne, playerTwo);

        logMatch(playerOne, playerTwo, winner);

        matchesPlayed++;
        if (matchesPlayed > 2) {
            resetGame();
        }

        return winner;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 05 - Implementation 09 <--");
        DPK05Impl9 dpk05Impl9 = new DPK05Impl9();

        var winner1 = dpk05Impl9.play(DPK05Impl9.PLAYERS[0], DPK05Impl9.PLAYERS[1]);
        var winner2 = dpk05Impl9.play(DPK05Impl9.PLAYERS[2], DPK05Impl9.PLAYERS[3]);
        dpk05Impl9.play(winner1, winner2);
        dpk05Impl9.play(DPK05Impl9.PLAYERS[0], DPK05Impl9.PLAYERS[1]);
    }
}

