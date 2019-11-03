import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {
    private Map<String, Integer> wordCounter;

    public DuplicateCounter(){
        wordCounter = new HashMap<String,Integer>();
    }

    public void count(String dataFile){
        Scanner scnr = null;

        try {
            scnr = new Scanner(new File(dataFile));
        }

        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        while (scnr.hasNext()) {
            String text = scnr.next().toLowerCase();
            Integer count = wordCounter.get(text);

            if(count == null) {
                count = 1;
            }

            else {
                count++;
            }

            wordCounter.put(text, count);
        }
        scnr.close();
    }

    public void write(String outputFile){

        try {
            PrintWriter pwr = new PrintWriter(new File(outputFile));
            for(String k : wordCounter.keySet()) {
                pwr.println(k + " " + wordCounter.get(k));
            }
            pwr.close();

        }

        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
