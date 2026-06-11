package com.mariofernandes.javapoc.sep.dpk14;

import java.util.ArrayList;
import java.util.List;

public class DPK14Impl5 {
    public List<String> move(String[][] grid, int[] initialPosition, String[] moves) {
        validate(grid, initialPosition, moves);

        var result = new ArrayList<String>();
        int maxCol = grid[0].length - 1;
        int maxRow = grid.length - 1;

        String fighter = grid[initialPosition[0]][initialPosition[1]];
        int row = initialPosition[0];
        int col = initialPosition[1];
        for (String currentMove : moves) {
            grid[row][col] = "";

            if ("up".equals(currentMove)) {
                row--;
            } else if ("down".equals(currentMove)) {
                row++;
            } else if ("left".equals(currentMove)) {
                col--;
            } else if ("right".equals(currentMove)) {
                col++;
            }

            row = wrap(row, maxRow);
            col = wrap(col, maxCol);

            String opponent = grid[row][col];
            if (!"".equals(opponent)) {
                result.add(opponent);
            }
            grid[row][col] = fighter;
        }

        return result;
    }

    private void validate(String[][] grid, int[] initialPosition, String[] moves) {
        if (null == grid || null == initialPosition || null == moves){
            throw new IllegalArgumentException();
        }

        if (initialPosition.length != grid.length) {
            throw new IllegalArgumentException();
        }

        if (grid.length == 0 || grid[0].length == 0 || moves.length == 0) {
            throw new IllegalArgumentException();
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
        System.out.println("--> DPK 14 - Implementation 05 <--");
        DPK14Impl5 dpk14Impl5 = new DPK14Impl5();

        var grid = new String[][]{
                { "Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega" },
                { "Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison" }
        };
        var initialPosition = new int[]{0, 0};
        var moves = new String[]{"up", "left", "down", "right"};

        printGrid(grid);
        var result = dpk14Impl5.move(grid, initialPosition, moves);
        System.out.println("move(grid, [0,0], [\"up\", \"left\", \"down\", \"right\"]) -> " + result + "\n");
        printGrid(grid);
    }
}

