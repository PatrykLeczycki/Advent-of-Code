package com.pleczycki.aoc._2015._5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Solution {

    static boolean checkForForbiddenPair(char first, char second) {
        return (first == 'a' && second == 'b') ||
                (first == 'c' && second == 'd') ||
                (first == 'p' && second == 'q') ||
                (first == 'x' && second == 'y');
    }

    static boolean isCharVowel(char c) {
        return List.of('a', 'e', 'i', 'o', 'u').contains(c);
    }

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Path.of("C:\\Users\\Patryk\\Documents\\Advent-of-Code\\src\\main\\java\\com\\pleczycki\\aoc\\_2015\\_5\\input.txt"));

        int vowelsFoundNumber = 0;
        boolean twoSameSequence = false;
        boolean forbiddenPairFound = false;

        int niceStringsCounter = 0;

        for (String s : input) {
            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);

                if (i != s.length() - 1) {
                    if (forbiddenPairFound = checkForForbiddenPair(currentChar, s.charAt(i + 1))) {
                        System.out.println(currentChar + "||" + s.charAt(i + 1));
                        break;
                    }

                    if (!twoSameSequence && currentChar == s.charAt(i + 1)) {
                        System.out.println(currentChar + "|" + s.charAt(i + 1));
                        twoSameSequence = true;
                    }
                }

                if (vowelsFoundNumber < 3 && isCharVowel(currentChar)) {
                    vowelsFoundNumber++;
                }
            }

            if (!forbiddenPairFound && twoSameSequence && vowelsFoundNumber >= 3) {
                niceStringsCounter++;
                System.out.println(s);
            }

            vowelsFoundNumber = 0;
            forbiddenPairFound = false;
            twoSameSequence = false;
        }
        System.out.println("Nice strings: " + niceStringsCounter);
    }
}
