package com.pleczycki.aoc._2015._1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {

    public static void main(String[] args) throws IOException {
        String input = Files.readString(Path.of("C:\\Users\\Patryk\\Documents\\Advent-of-Code\\src\\main\\java\\com\\pleczycki\\aoc\\_2015\\_1\\input.txt"));

        int floor = 0;

        boolean reachedMinusOne = false;

        for (int i = 0; i < input.length(); i++) {
            floor += (input.charAt(i) == '(' ? 1 : -1);
            if (!reachedMinusOne && floor == -1) {
                System.out.println("Minus one index = " + (i + 1));
                reachedMinusOne = true;
            }
        }
        System.out.println("Floor: " + floor);
    }
}
