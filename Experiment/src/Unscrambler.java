/**
 * Created by Archisman on 5/02/2016.
 */
import java.util.Scanner;
public class Unscrambler extends inputFile{

    protected static int c = 0;

    /**
     * Constructor for Unscrambler class
     */
    public Unscrambler(String file) {
        // invoking super class Constructor
        super(file);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word to be unscrambled");
        String word = sc.nextLine();
        System.out.println("Enter a name for the File: ");
        String file = sc.nextLine();
        Unscrambler newWord = new Unscrambler(file);
        newWord.display("",word);
        System.out.println("Number of Anagrams : "+c);
        newWord.closeFile();
        System.out.println("Valid Words are:");
        Dictionary.implement(file);
    }



    public void display(String a, String word) {
        if(word.length() == 2){
            String p1 = word.charAt(0) + "" + word.charAt(1);
            this.writeToFile(a+p1);
            c++;
            String p2 = word.charAt(1) + "" + word.charAt(0);
            this.writeToFile(a+p2);
            c++;
            return;
        }
        else {
            for (int i = 0; i < word.length();  i++) {
                String t = "";
                for (int j = 0; j < word.length();  j++) {
                    if(i != j)  t += word.charAt(j);
                }
                display(a+word.charAt(i), t);
            }
        }
    }
}
