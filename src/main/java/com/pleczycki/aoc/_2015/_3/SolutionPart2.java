package com.pleczycki.aoc._2015._3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import static com.pleczycki.aoc._2015._3.Solution.getNewPosition;

public class SolutionPart2 {
    public static void main(String[] args) throws IOException {
        Set<Position> positions = new HashSet<>();
        Position currentSantaPosition = new Position(0, 0);
        Position currentRobotPosition = new Position(0, 0);
        positions.add(currentSantaPosition);
        positions.add(currentRobotPosition);

        String input = Files.readString(Path.of("C:\\Users\\Patryk\\Documents\\Advent-of-Code\\src\\main\\java\\com\\pleczycki\\aoc\\_2015\\_3\\input.txt"));
        for (int i = 0; i < input.length(); i++) {
            if(i % 2 == 0) {
                currentSantaPosition = getNewPosition(currentSantaPosition, input.charAt(i));
                positions.add(currentSantaPosition);
            } else {
                currentRobotPosition = getNewPosition(currentRobotPosition, input.charAt(i));
                positions.add(currentRobotPosition);
            }

        }
        System.out.println("Unique positions: " + positions.size());
    }
}
