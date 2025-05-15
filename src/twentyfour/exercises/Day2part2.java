package twentyfour.exercises;

import java.io.*;
import java.util.Arrays;

/**
 * Autori:
 *  - sisyphus
 *  Fonte:
 * <a href="https://adventofcode.com/2024/day/2#part2">Advent of Code 2024 - Day 2, Part 2</a>
 *
 * @author sisyphus
 */
public class Day2part2 {
    public static void main(String[] args) throws IOException {
        try {
            InputStream inputStream = Day2part2.class.getResourceAsStream("/twentyfour/inputfiles/input2.txt");
            if (inputStream == null) {
                throw new FileNotFoundException("File not found: /twentyfour/inputfiles/input2.txt");
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            int totalSafeReports = 0;

            while ((line = br.readLine()) != null) {
                int[] levels = Arrays.stream(line.split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                if (isSafe(levels)) {
                    totalSafeReports++;
                    continue;
                }

                // Try removing one level at a time
                for (int i = 0; i < levels.length; i++) {
                    int[] reduced = removeIndex(levels, i);
                    if (isSafe(reduced)) {
                        totalSafeReports++;
                        break; // No need to try more removals
                    }
                }
            }

            System.out.println("Totale report sicuri: " + totalSafeReports);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    // Verify the sequence direction and if the line is safe (1 to 3 value difference)
    public static boolean isSafe(int[] levels) {
        if (levels.length < 2) return true;

        boolean increasing = levels[1] > levels[0];

        for (int i = 1; i < levels.length; i++) {
            int prev = levels[i - 1];
            int curr = levels[i];

            int diff = Math.abs(curr - prev);
            boolean currentIncreasing = curr > prev;

            if (diff < 1 || diff > 3 || currentIncreasing != increasing) {
                return false;
            }
        }

        return true;
    }

    // Remove the array[indexToRemove] element
    public static int[] removeIndex(int[] array, int indexToRemove) {
        int[] result = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != indexToRemove) {
                result[j++] = array[i];
            }
        }
        return result;
    }
}

