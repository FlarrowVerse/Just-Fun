/**
 * Created by Archisman on 6/2/2016.
 */
// for BufferedReader and FileWriter classes

import java.io.* ;
public class inputFile {
    // data members
    protected FileWriter fw;
    protected BufferedWriter bw;
    protected PrintWriter pw;

    /**
     * Constructor for class inputFile
     */
    inputFile(String filename) {
        try {
            File file = new File(filename);
            if(!file.exists()) file.createNewFile();
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

        }catch (Exception e) {
            System.out.println("Exception Occured: "+e);
        }
    }

    /**
     * Method to write a string to the file.
     */
    public void writeToFile(String word) {
        try {
            pw.println(word);
        }catch (Exception e) {
            System.out.println("Exception occurred while trying to write to file: "+e);
        }
    }

    /**
     * Method to finally close the file.
     */
    public void closeFile() {
        try {
            pw.close();
            bw.close();
            fw.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
