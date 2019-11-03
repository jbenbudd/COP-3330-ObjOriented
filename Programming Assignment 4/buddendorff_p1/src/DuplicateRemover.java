import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
    private Set<String> uniqueWords;

    public void remove(String dataFile) throws FileNotFoundException {
        String text = "";
        uniqueWords = new HashSet<String>();
        Scanner scnr = new Scanner(new File(dataFile));
        while(scnr.hasNext()) {
            text = scnr.next();
            uniqueWords.add(text);
        }
        scnr.close();
    }

    public void write(String outputFile) throws IOException {
        FileWriter flw = null;

        File outText = new File(outputFile);

        if(outText.exists()) {
            flw = new FileWriter(outText,true);
            Iterator itr=uniqueWords.iterator();

            while(itr.hasNext()) {
                String str=(String)itr.next();
                flw.write(str+"\n");
            }
            flw.close();
            System.out.println("Complete.");

        }

        else {
            outText.createNewFile();
            flw = new FileWriter(outText);
            Iterator itr=uniqueWords.iterator();

            while(itr.hasNext()) {
                String str=(String)itr.next();
                flw.write(str+"\n");
            }
            flw.close();
            System.out.println("Complete.");
        }

    }

}

