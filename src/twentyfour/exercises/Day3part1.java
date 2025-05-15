package twentyfour.exercises;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Autori:
 *  - sisyphus
 *  Fonte:
 * <a href="https://adventofcode.com/2024/day/3#part1">Advent of Code 2024 - Day 3, Part 1</a>
 *
 * @author sisyphus
 */
public class Day3part1 {

    public static void main(String[] args) {
        try {
            InputStream inputStream = Day3part1.class.getResourceAsStream("/twentyfour/inputfiles/input3.txt");
            if (inputStream == null) {
                throw new FileNotFoundException("File not found: /twentyfour/inputfiles/input3.txt");
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            String regex = "mul\\(\\d{1,3},\\d{1,3}\\)";
            Pattern pattern = Pattern.compile(regex);
            int sum = 0;

            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    String match = matcher.group(); // es. "mul(12,345)"
                    String content = match.substring(4, match.length() - 1); // "12,345"
                    String[] parts = content.split(",");
                    int x = Integer.parseInt(parts[0]);
                    int y = Integer.parseInt(parts[1]);
                    int product = x * y;
                    System.out.println("mul(" + x +"," + y + ")");
                    sum += product;
                }

            }

            System.out.println("Somma totale dei risultati: " + sum);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
