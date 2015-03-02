/*
 * Jack Benson and Aliyah Tuzhilin
 * 15 February 2015
 * We adhered to the honor code on this lab
 */


import java.util.Scanner;
import java.util.Random;

/**
 * @author jackbenson
 */
public class HiLo {
    /**
     * This program plays the game HiLo
     *@param args Filename of input
     */
   public static void main(String[] args) {
       Random rnd = new Random();
       int target = rnd.nextInt(1000) + 1;
       int up = 0;
       //System.out.println(target);
       System.out.print("Enter a number: ");

       Scanner input = new Scanner(System.in);

       while (input.hasNextLine()) {
           String line = input.nextLine();
           Scanner s2 = new Scanner(line);
           if (s2.hasNextInt()) {
               int userGuess = s2.nextInt();
               ++up;

               if (userGuess == target) {
                   System.out.println("That's correct!  It took you " + up + " tries");
                   break;


               } else if (userGuess < target) {
                   System.out.println("Too low!");
                   System.out.print("Enter a number: ");

               } else {
                   System.out.println("Too high!");
                   System.out.print("Enter a number: ");

               }

           } else {
               System.out.println("Not a number!");
               System.out.print("Enter a number: ");

           }

       }

   }
}

