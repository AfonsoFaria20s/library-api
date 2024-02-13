package com.fonsedev;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Timer;

public class MazeSolver {
    int[][] maze;

    public MazeSolver(int[][] maze) {
        this.maze = maze;
    }

    public void start() {
        displayMaze();
    }

    public void solveMaze() {

    }

    public void displayMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 0) {
                    System.out.print("   ");
                } else if (maze[i][j] == 1) {
                    System.out.print(" # ");
                } else if (maze[i][j] == 2) {
                    System.out.print(" x ");
                } else if (maze[i][j] == 9) {
                    System.out.print(" o ");
                }
            }
            System.out.println();
        }
    }

    public static String getSymbol(int value) {
        switch (value) {
            case 0:
                return "0"; // or any symbol for an open path
            case 1:
                return "1"; // or any symbol for a wall
            case 2:
                return "2"; // or any symbol for a special location
            case 9:
                return "9"; // or any symbol for the destination
            default:
                return "?"; // unknown symbol for other values
        }
    }
}
