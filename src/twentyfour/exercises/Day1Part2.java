package twentyfour.exercises;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://adventofcode.com/2024/day/1#part2">Advent of Code 2024 - Day 1, Part 2</a>
 */
public class Day1Part2 {

    public static void main(String[] args) throws IOException {
            try {
                InputStream inputStream = Day1Part1.class.getResourceAsStream("/twentyfour/inputfiles/alvisegenerated/input1p2.txt");
                if (inputStream == null) {
                    throw new FileNotFoundException("File not found: /twentyfour/inputfiles/alvisegenerated/input1p2.txt");
                }
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                String st;

                List<Integer> leftList = new ArrayList<>();
                Map<Integer, Integer> rightCountMap = new HashMap<>();

                while ((st = br.readLine()) != null) {
                    //System.out.println(st);
                    String[] arr = st.split("\\s+");

                    int left = Integer.parseInt(arr[0]);
                    int right = Integer.parseInt(arr[1]);
                    leftList.add(left);
                    rightCountMap.put(right, rightCountMap.getOrDefault(right, 0) + 1);
                }

                int total = calculateSimilarityScore(leftList, rightCountMap);

                System.out.println("Left list: " + leftList);
                System.out.println("Right count map: " + rightCountMap);
                System.out.println("Il totale è " + total);
            } catch(FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
    }

    public static int calculateSimilarityScore(List<Integer> list, Map<Integer, Integer> map){
        int similarityScore = 0;

        for (int leftValue : list) {
            int rightCount = map.getOrDefault(leftValue, 0);
            similarityScore += leftValue * rightCount;
        }

        return similarityScore;
    }
}
