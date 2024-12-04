import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class First {
    public static void main(String[] args) throws IOException {

        try {

            URL path = First.class.getResource("input1.txt");
            File file = new File("input1.txt");
            if (path != null)
                file = new File(path.getFile());
            BufferedReader br = new BufferedReader(new FileReader(file));
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