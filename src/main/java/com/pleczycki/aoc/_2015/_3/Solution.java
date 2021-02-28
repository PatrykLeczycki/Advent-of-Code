package com.pleczycki.aoc._2015._3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Solution {
    static Position getNewPosition(Position lastPosition, char direction) {
        Position newPosition = lastPosition;

        switch (direction) {
            case '<' -> newPosition = new Position(lastPosition.x - 1, lastPosition.y);
            case '>' -> newPosition = new Position(lastPosition.x + 1, lastPosition.y);
            case '^' -> newPosition = new Position(lastPosition.x, lastPosition.y + 1);
            case 'v' -> newPosition = new Position(lastPosition.x, lastPosition.y - 1);
        }
        return newPosition;
    }

    public static void main(String[] args) throws IOException {
        Set<Position> positions = new HashSet<>();
        Position currentPosition = new Position(0, 0);
        positions.add(currentPosition);

        String input = Files.readString(Path.of("C:\\Users\\Patryk\\Documents\\Advent-of-Code\\src\\main\\java\\com\\pleczycki\\aoc\\_2015\\_3\\input.txt"));
        for (int i = 0; i < input.length(); i++) {
            currentPosition = getNewPosition(currentPosition, input.charAt(i));
            positions.add(currentPosition);
        }
        System.out.println("Unique positions: " + positions.size());
    }
}
