/**
 *@author jackbenson Jack Benson and Aliyah Tuzhilin
 * 15 February 2015
 * I worked on this program with Aliyah Tuzhilin
 * We adhered to the honor code on this assignment
 */
public class pyramid {
    public static void main(String[] args) {
        /**
         * @param args Args string input as number
         */
	if (args.length == 1);
	    int N = Integer.parseInt(args[0]);
		for (int row = 0; row < N ; row++) {
		    for (int spaces = 0; spaces < N - (row + 1); spaces++) {
			System.out.print(" ");
		    }
		    for (int stars = 0; stars < 2*row + 1; stars++) {
			System.out.print("*");
		    }
		    System.out.println();
	}

    }

}
