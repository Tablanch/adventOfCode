package twentyfour.exercises;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3part2 {

    public static void main(String[] args) {
        try {
            InputStream inputStream = Day3part1.class.getResourceAsStream("/twentyfour/inputfiles/input3.txt");
            if (inputStream == null) {
                throw new FileNotFoundException("File not found: /twentyfour/inputfiles/input3.txt");
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            String mulRegex = "mul\\(\\d{1,3},\\d{1,3}\\)";
            String doRegex = "do()";
            String dontRegex = "don't()";
            int sum = 0;

            Pattern mulPattern = Pattern.compile(mulRegex);
            Pattern doPattern = Pattern.compile(doRegex);
            Pattern dontPattern = Pattern.compile(dontRegex);

            while ((line = br.readLine()) != null) {
                List<Instruction> instructions = new ArrayList<>();

                Matcher mulMatcher = mulPattern.matcher(line);
                while (mulMatcher.find()) {
                    instructions.add(new Instruction(mulMatcher.start(), "mul", mulMatcher.group()));
                }

                Matcher doMatcher = doPattern.matcher(line);
                while (doMatcher.find()) {
                    instructions.add(new Instruction(doMatcher.start(), "do", null));
                }

                Matcher dontMatcher = dontPattern.matcher(line);
                while (dontMatcher.find()) {
                    instructions.add(new Instruction(dontMatcher.start(), "don't", null));
                }

                // Ordina per posizione nel testo
                instructions.sort(Comparator.comparingInt(i -> i.position));

                // Ora esegui
                boolean enabled = true;
                for (Instruction instr : instructions) {
                    switch (instr.type) {
                        case "do":
                            enabled = true;
                            break;
                        case "don't":
                            enabled = false;
                            break;
                        case "mul":
                            if (enabled) {
                                String[] parts = instr.content.substring(4, instr.content.length() - 1).split(",");
                                int x = Integer.parseInt(parts[0]);
                                int y = Integer.parseInt(parts[1]);
                                sum += x * y;
                            }
                            break;
                    }
                }
            }

            System.out.println("Totale moltiplicazioni abilitate: " + sum);

        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static class Instruction {
        int position;
        String type; // "do", "don't", "mul"
        String content; // solo per mul

        public Instruction(int position, String type, String content) {
            this.position = position;
            this.type = type;
            this.content = content;
        }
    }
}
