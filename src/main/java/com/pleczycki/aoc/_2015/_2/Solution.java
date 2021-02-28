package com.pleczycki.aoc._2015._2;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Path.of("C:\\Users\\Patryk\\Documents\\Advent-of-Code\\src\\main\\java\\com\\pleczycki\\aoc\\_2015\\_2\\input.txt"));

        int totalSurface = 0;
        int totalDistance = 0;

        for (String s : input) {
            String[] dimensions = StringUtils.split(s, 'x');
            int l = Integer.parseInt(dimensions[0]);
            int w = Integer.parseInt(dimensions[1]);
            int h = Integer.parseInt(dimensions[2]);

            int smallestArea = Math.min(Math.min(l * w, l * h), w * h);
            totalSurface += 2 * (l * w + l * h + w * h) + smallestArea;

            int smallestDistance = Math.min(Math.min(l + w, l + h), w + h);
            totalDistance += 2 * smallestDistance + (l * w * h);
        }
        System.out.println("Total surface = " + totalSurface);
        System.out.println("Total distance = " + totalDistance);
    }
}
