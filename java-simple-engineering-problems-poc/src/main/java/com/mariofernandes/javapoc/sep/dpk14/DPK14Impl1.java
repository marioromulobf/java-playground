package com.mariofernandes.javapoc.sep.dpk14;

import java.util.ArrayList;
import java.util.List;

public class DPK14Impl1 {
    int maxCol;
    int maxRow;
    int minCol;
    int minRow;

    public List<String> move(String[][] grid, int[] initialPosition, String[] moves) {
        var result = new ArrayList<String>();
        maxCol = grid[0].length - 1;
        maxRow = grid.length - 1;
        minCol = 0;
        minRow = 0;

        String fighter = grid[initialPosition[0]][initialPosition[1]];
        int[] currentPosition = initialPosition;
        for (String currentMove : moves) {
            grid[currentPosition[0]][currentPosition[1]] = "";

            currentPosition = getNewPosition(currentPosition[0], currentPosition[1], currentMove);
            if (grid[currentPosition[0]][currentPosition[1]] != "") {
                result.add(grid[currentPosition[0]][currentPosition[1]]);
            }

            grid[currentPosition[0]][currentPosition[1]] = fighter;
        }

        return result;
    }

    private int[] getNewPosition(int row, int col, String move) {
        if ("up".equals(move)) {
            row--;
        } else if ("down".equals(move)) {
            row++;
        } else if ("left".equals(move)) {
            col--;
        } else if ("right".equals(move)) {
            col++;
        }

        if (row < minRow) {
            row = maxRow;
        }
        if (col < minCol) {
            col = maxCol;
        }
        if (row > maxRow) {
            row = minRow;
        }
        if (col > maxCol) {
            col = minCol;
        }

        return new int[]{row, col};
    }

    public static void printGrid(String[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            sb.append("[");
            for  (int j = 0; j < grid[i].length; j++) {
                if (j > 0) {
                    sb.append(", ");
                }
                sb.append(grid[i][j]);
            }
            sb.append("]\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 14 - Implementation 01 <--");
        DPK14Impl1 dpk14Impl1 = new DPK14Impl1();

        var grid = new String[][]{
                { "Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega" },
                { "Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison" }
        };
        var initialPosition = new int[]{0, 0};
        var moves = new String[]{"up", "left", "down", "right"};

        printGrid(grid);
        var result = dpk14Impl1.move(grid, initialPosition, moves);
        System.out.println("move(grid, [0,0], [\"up\", \"left\", \"down\", \"right\"]) -> " + result + "\n");
        printGrid(grid);
    }
}

