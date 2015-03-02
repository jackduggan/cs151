/*
 * Jack Benson and Aliyah Tuzhilin
 * 15 February 2015
 * We adhered to the honor code on this lab
 */
import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
/**
 * @author jackbenson
 */
public class Redactor {
    /**
     * This program redacts certain words
     * @param args Filename for the input
     */
    public static void main(String[] args) {
        String[] wordlist;
        Scanner input = null;
        Scanner input2 = null;
        Scanner article = null;
        int counter = 0;

        try {
            input = new Scanner(new File(args[0]));
            while (input.hasNextLine()) {
                ++counter;
                input.nextLine();
                //System.out.println(counter);
            }
            wordlist = new String[counter];
            input2 = new Scanner(new File(args[0]));
            for (int i = 0; i < counter; i++) {
                wordlist[i] = input2.next();
                //System.out.println(wordlist[i]);
            }
            article = new Scanner(new File(args[1]));


            while (article.hasNextLine()) {
                String nextLine = article.nextLine(); //Produces string "nextLine" which is the next word of the article
                for (int i = 0; i < counter; i++) {
                    String listElement = wordlist[i];
                    nextLine = nextLine.replaceAll(listElement, "XXXXXX");

                }
                System.out.println(nextLine);

            }


        } catch (FileNotFoundException e) {
            System.out.println("Problem opening file.");
            System.exit(1);

        }


    }
}
