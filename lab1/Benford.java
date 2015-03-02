/*
 * Jack Benson
 * 15 February 2015
 * I adhered to the honor code on this program
 */


import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
/**
 * @author jackbenson
 *
 */

public class Benford {
    public static final int MAXWIDTH = 50;
    /**
     * This program preforms a Benford analysis on a file
     *  @param args Filename for the input string
     */
    public static void main(String[] args) {
        Scanner input;
        int counter = 0;
        int[] firstArray = new int[10];
        try {

            input = new Scanner(new File(args[0]));
            while (input.hasNext()) {                                   //if there is a next string
                 String stringtoread = input.next();                    // create variable "stringtoread"
                 String firstdigit = stringtoread.substring(0, 1);      // trim string to the first digit, create var
                if (Character.isDigit(stringtoread.charAt(0))) {        // if char at beginning is a digit, do stuff
                    int a =Integer.parseInt(firstdigit);                // create variable "a" and cast as an int
                    firstArray[ a ]++;
                }

            }
            int Max = -1;                                               // Find the maximum frequency
            int count = 0;
            for(int i : firstArray) {
                count+=i;                                               //Keep a total count of numbers
                if (i > Max) Max = i;
            }
            System.out.println("The Benford Analysis Program!");
            for (int i = 0; i < firstArray.length; i++) {
                float freq = (float)firstArray[i]/(float)count*(float)100.0;
                System.out.printf("%d %8d %4.1f%% : ", i, firstArray[i], freq);
                int round = (MAXWIDTH * firstArray[i] / Max);                               //not really sure what this does
                int rounded = Math.round(round);
                for (int star =  0; star < /*(MAXWIDTH*firstArray[i]/Max)*/ rounded; star++) //what I commented out works fine
                    System.out.print("*");
                System.out.println();
            }


            //System.out.println(Arrays.toString(firstArray));
        }

        catch (FileNotFoundException e) {
            System.out.println("Problem opening file: " + e.getMessage());
            System.exit(1);

        }
    }
}
