package twentyfour.exercises;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Autori:
 *  - tablanch
 *  - sisyphus
 *  Fonte:
 * <a href="https://adventofcode.com/2024/day/1#part1">Advent of Code 2024 - Day 1, Part 1</a>
 *
 * @author tablanch
 * @author sisyphus
 */
public class Day1part1 {
    public static void main(String[] args) throws IOException {

        try {
            InputStream inputStream = Day1part1.class.getResourceAsStream("/twentyfour/inputfiles/input1.txt");
            if (inputStream == null) {
                throw new FileNotFoundException("File not found: /twentyfour/inputfiles/input1.txt");
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String st;
            List<Integer> firstGroup = new ArrayList<>();
            List<Integer> secondGroup = new ArrayList<>();
            while ((st = br.readLine()) != null) {
                System.out.println(st);
                String[] arr = st.split("\\s+");
                firstGroup.add(Integer.valueOf(arr[0]));
                secondGroup.add(Integer.valueOf(arr[1]));
            }

            Collections.sort(firstGroup);
            Collections.sort(secondGroup);
            System.out.println(firstGroup);
            System.out.println(secondGroup);
            int sum = 0;
            for(int i = 0; i < firstGroup.size(); i++) {
                sum += Math.abs(firstGroup.get(i)-secondGroup.get(i));
            }
            System.out.println(sum);

        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}