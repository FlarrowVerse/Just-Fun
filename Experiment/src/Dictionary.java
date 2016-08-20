/**
 * Created by DB on 2/6/2016.
 */
import java.io.*;
public class Dictionary {
    // data members
    protected FileReader fr;
    protected BufferedReader br;

    /**
     * Constructor for Dictionary
     */
    public Dictionary(String filename) {
        try {
            File file = new File(filename);
            if(!file.exists()) throw new FileNotFoundException();
            fr = new FileReader(file);
            br = new BufferedReader(fr);

        }catch (Exception e) {
            System.out.println("Exception Occured: "+e);
        }
    }

    /**
     * Method to read words from file
     */
    public void readfromInputFile() {
        try {
            String s = "";
            while((s = br.readLine()) != null) validateWords(s);
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Method to Validate words from file
     */
    public void validateWords(String word) {
        Dictionary temp = new Dictionary("D:\\Dictionary.txt");
        try {
            String validWord = "";
            while((validWord = br.readLine()) != null) {
                if(word.equalsIgnoreCase(validWord)) {
                    System.out.println(word);
                    temp.closeFile();
                    return;
                }
            }
            temp.closeFile();
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    private void closeFile() {
        try {
            br.close();
            fr.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Main method to implement
     */
    public static void implement(String filename) {
        Dictionary d = new Dictionary(filename);
        d.readfromInputFile();
    }
}
