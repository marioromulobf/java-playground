package com.mariofernandes.javapoc.sep.dpk14;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DPK14Impl10 {

    private static final String EMPTY = "";
    private static final Map<String, Movement> MOVEMENTS = Map.of(
        "up", p -> new GridPosition(p.row() - 1, p.col()),
        "down", p -> new GridPosition(p.row() + 1, p.col()),
        "left", p -> new GridPosition(p.row(), p.col() - 1),
        "right", p -> new GridPosition(p.row(), p.col() + 1)
    );

    public interface Movement {
        GridPosition move(GridPosition position);
    }

    public record GridPosition(int row, int col) {}

    public List<String> move(String[][] grid, int[] initialPosition, String[] moves) {
        validate(grid, initialPosition, moves);

        var result = new ArrayList<String>();
        int maxCol = grid[0].length - 1;
        int maxRow = grid.length - 1;

        String fighter = grid[initialPosition[0]][initialPosition[1]];
        var position = new GridPosition(initialPosition[0], initialPosition[1]);

        for (String currentMove : moves) {
            grid[position.row()][position.col()] = EMPTY;

            var movement = MOVEMENTS.get(currentMove);
            if  (movement != null) {
                position = movement.move(position);
                position = wrap(position, maxRow, maxCol);
            }

            addDefeated(result, grid[position.row()][position.col()]);

            grid[position.row()][position.col()] = fighter;
        }

        return result;
    }

    private void validate(String[][] grid, int[] initialPosition, String[] moves) {
        if (null == grid || null == initialPosition || null == moves){
            throw new IllegalArgumentException();
        }

        if (initialPosition.length != 2) {
            throw new IllegalArgumentException();
        }

        if (initialPosition[0] >= grid.length || initialPosition[1] >= grid[0].length) {
            throw new IllegalArgumentException();
        }

        if (initialPosition[0] < 0 || initialPosition[1] < 0) {
            throw new IllegalArgumentException();
        }
    }

    private void addDefeated(List<String> result, String defeatedFighter) {
        if (!EMPTY.equals(defeatedFighter)) {
            result.add(defeatedFighter);
        }
    }

    private int wrap(int value, int maxValue) {
        if (0 > value) {
            return maxValue;
        }

        if (maxValue < value) {
            return 0;
        }

        return value;
    }

    private GridPosition wrap(GridPosition position, int maxRow, int maxCol) {
        return new GridPosition(
                wrap(position.row(), maxRow),
                wrap(position.col(), maxCol)
        );
    }

    public static void printGrid(String[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (String[] strings : grid) {
            sb.append("[");
            for (int j = 0; j < strings.length; j++) {
                if (j > 0) {
                    sb.append(", ");
                }
                sb.append(strings[j]);
            }
            sb.append("]\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 14 - Implementation 10 <--");
        DPK14Impl10 dpk14Impl10 = new DPK14Impl10();

        var grid = new String[][]{
                { "Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega" },
                { "Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison" }
        };
        var initialPosition = new int[]{0, 0};
        var moves = new String[]{"up", "left", "down", "right"};

        printGrid(grid);
        var result = dpk14Impl10.move(grid, initialPosition, moves);
        System.out.println("move(grid, [0,0], [\"up\", \"left\", \"down\", \"right\"]) -> " + result + "\n");
        printGrid(grid);
    }
}

