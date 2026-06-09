package com.mariofernandes.javapoc.sep.dpk14;

import java.util.ArrayList;
import java.util.List;

public class DPK14Impl2 {
    public List<String> move(String[][] grid, int[] initialPosition, String[] moves) {
        var result = new ArrayList<String>();
        int maxCol = grid[0].length - 1;
        int maxRow = grid.length - 1;

        String fighter = grid[initialPosition[0]][initialPosition[1]];
        int[] currentPosition = initialPosition;
        for (String currentMove : moves) {
            grid[currentPosition[0]][currentPosition[1]] = "";

            currentPosition = getNewPosition(currentPosition[0], currentPosition[1], maxCol, maxRow, currentMove);
            if (grid[currentPosition[0]][currentPosition[1]] != "") {
                result.add(grid[currentPosition[0]][currentPosition[1]]);
            }

            grid[currentPosition[0]][currentPosition[1]] = fighter;
        }

        return result;
    }

    private int[] getNewPosition(int row, int col, int maxCol, int maxRow, String move) {
        if ("up".equals(move)) {
            row--;
        } else if ("down".equals(move)) {
            row++;
        } else if ("left".equals(move)) {
            col--;
        } else if ("right".equals(move)) {
            col++;
        }

        row = wrap(row, maxRow);
        col = wrap(col, maxCol);

        return new int[]{row, col};
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
        System.out.println("--> DPK 14 - Implementation 02 <--");
        DPK14Impl2 dpk14Impl2 = new DPK14Impl2();

        var grid = new String[][]{
                { "Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega" },
                { "Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison" }
        };
        var initialPosition = new int[]{0, 0};
        var moves = new String[]{"up", "left", "down", "right"};

        printGrid(grid);
        var result = dpk14Impl2.move(grid, initialPosition, moves);
        System.out.println("move(grid, [0,0], [\"up\", \"left\", \"down\", \"right\"]) -> " + result + "\n");
        printGrid(grid);
    }
}

