package tut01;

import java.util.Scanner;

/**
 * A class to demonstrate:
 * (i) the use of Scanner class to read input from the keyboard.
 * (ii) working with strings
 * 
 * @author Aarthi N
 */
public class Sum {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println();
    System.out.println("Enter some integers separated only by spaces: (example 10 20 30)");
    int sum = 0;
    String numbers = sc.nextLine();
    String[] nos = numbers.split(" ");
    for (int i = 0; i < nos.length; i++) {
      sum += Integer.parseInt(nos[i]);
    }
    System.out.println();
    System.out.println("Sum =" + sum);
    sc.close();
  }
}
