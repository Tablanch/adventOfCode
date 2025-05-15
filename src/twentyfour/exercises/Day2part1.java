package twentyfour.exercises;

import java.io.*;

/**
 * Autori:
 *  - tablanch
 *  - sisyphus
 *  Fonte:
 * <a href="https://adventofcode.com/2024/day/2#part1">Advent of Code 2024 - Day 2, Part 1</a>
 *
 * @author tablanch
 * @author sisyphus
 */
public class Day2part1 {

    public static void main(String[] args) throws IOException {
            try {
                InputStream inputStream = Day2part1.class.getResourceAsStream("/twentyfour/inputfiles/input2.txt");
                if (inputStream == null) {
                    throw new FileNotFoundException("File not found: /twentyfour/inputfiles/input2.txt");
                }
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                String st;
                int total = 0;
                OUTER_LOOP: while ((st = br.readLine()) != null) {
                    System.out.println(st);
                    String[] arr = st.split("\\s+");
                    boolean increasing = true;
                    for(int i = 0, j = i+1; i < arr.length - 1; i++, j++) {

                        int intI= Integer.parseInt(arr[i]);
                        int intJ = Integer.parseInt(arr[j]);
                        boolean currentIncreasing = intJ > intI;

                        if(i == 0){
                            increasing = intJ > intI;
                        }
                        if(Math.abs(intI-intJ) < 1 || Math.abs(intI-intJ) > 3 || currentIncreasing != increasing) {
                            continue OUTER_LOOP;
                        }
                    }
                    total++;
                }

                System.out.println("Il totale è " + total);
            } catch(FileNotFoundException e) {
                System.out.println(e.getMessage());
            }

    }
}
