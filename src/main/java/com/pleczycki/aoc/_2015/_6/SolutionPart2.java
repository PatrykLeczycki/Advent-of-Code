package com.pleczycki.aoc._2015._6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SolutionPart2 {

    static void getModifiedLights(int[][] layout, int startingFirst, int endingFirst, int startingSecond, int endingSecond, String mode) {
        for (int i = startingFirst; i <= startingSecond; i++) {
            for (int j = endingFirst; j <= endingSecond; j++) {
                switch (mode) {
                    case "turn on" -> layout[i][j] += 1;
                    case "turn off" -> {
                        if (layout[i][j] > 0) {
                            layout[i][j]--;
                        }
                    }
                    case "toggle" -> layout[i][j] += 2;
                }
            }
        }
    }

    static String getMode(String input) {
        if (input.startsWith("turn on")) {
            return "turn on";
        }

        if (input.startsWith("turn off")) {
            return "turn off";
        }

        return "toggle";
    }

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Path.of("C:\\Users\\Patryk\\Documents\\Advent-of-Code\\src\\main\\java\\com\\pleczycki\\aoc\\_2015\\_6\\input.txt"));

        int[][] lights = new int[1000][1000];

        for (String s : input) {
            String mode = getMode(s);
            s = s.replace(mode + " ", "");
            s = s.replace(" through ", ",");

            String[] values = s.split(",");

            int startingFirst = Integer.parseInt(values[0]);
            int endingFirst = Integer.parseInt(values[1]);
            int startingSecond = Integer.parseInt(values[2]);
            int endingSecond = Integer.parseInt(values[3]);

            getModifiedLights(lights, startingFirst, endingFirst, startingSecond, endingSecond, mode);
        }

        int turnedOnNumber = 0;

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                turnedOnNumber += lights[i][j];
            }
        }

        System.out.println("Lights turned on: " + turnedOnNumber);
    }
}
