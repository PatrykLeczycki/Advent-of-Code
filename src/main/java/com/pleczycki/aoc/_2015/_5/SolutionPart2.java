package com.pleczycki.aoc._2015._5;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SolutionPart2 {

    static boolean checkIfContainsTwoPairs(String s, char first, char second, int indexOfSecond) {
        String substring = StringUtils.substring(s, indexOfSecond);
        return substring.contains("" + first + second);
    }

    static boolean checkIfSameCharPairIsSeparated(String s, char c) {
        int firstOccurence = s.indexOf(c);
        return (s.length() > firstOccurence + 2) && s.charAt(firstOccurence + 2) == c;
    }

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Path.of("C:\\Users\\Patryk\\Documents\\Advent-of-Code\\src\\main\\java\\com\\pleczycki\\aoc\\_2015\\_5\\input.txt"));

        boolean containsTwoPairs = false;
        boolean sameCharPairIsSeparated = false;

        int niceStringsCounter = 0;

        for (String s : input) {
            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);

                if (i < s.length() - 1) {
                    if (!containsTwoPairs) {
                        containsTwoPairs = checkIfContainsTwoPairs(s, currentChar, s.charAt(i + 1), (i + 1));
                    }

                    if (!sameCharPairIsSeparated) {
                        sameCharPairIsSeparated = checkIfSameCharPairIsSeparated(s, currentChar);
                    }
                }
            }

            if (containsTwoPairs && sameCharPairIsSeparated) {
                niceStringsCounter++;
                System.out.println(s);
            }

            containsTwoPairs = false;
            sameCharPairIsSeparated = false;
        }
        System.out.println("Nice strings: " + niceStringsCounter);
    }
}
