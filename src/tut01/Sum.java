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
    System.out.println("Enter some integers: ");
    
    Scanner sc = new Scanner(System.in);
    String numbers = sc.nextLine();
    String[] nos = numbers.split(" ");
    
    int sum = 0;
    for (int i = 0; i < nos.length; i++) {
      sum += Integer.parseInt(nos[i]);
    }
    
    System.out.println("Sum =" + sum);
    sc.close();
  }
}
