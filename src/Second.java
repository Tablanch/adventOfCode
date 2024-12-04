import java.io.*;
import java.net.URL;

public class Second {

    public static void main(String[] args) throws IOException {
            try {
                URL path = First.class.getResource("input2.txt");
                File file = new File("input2.txt");
                if (path != null)
                    file = new File(path.getFile());
                BufferedReader br = new BufferedReader(new FileReader(file));
                String st;
                int total = 0;
                OUTER_LOOP: while ((st = br.readLine()) != null) {
                    System.out.println(st);
                    String[] arr = st.split("\\s+");
                    boolean increasing = true;
                    for(int i = 0, j = i+1; i < arr.length - 1; i++, j++) {
                        int intI= Integer.parseInt(arr[i]);
                        int intJ = Integer.parseInt(arr[j]);
                        if(i == 0)
                            increasing = intI-intJ < 0;
                        if(Math.abs(intI-intJ) > 3 || Math.abs(intI-intJ) < 1 || ((intI - intJ) < 0) != increasing) {
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
