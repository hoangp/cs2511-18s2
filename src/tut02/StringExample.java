package tut02;

/**
 * An example to understand that Java Strings are immutable
 * 
 * @author Aarthi N
 */
public class StringExample {
  public static void main(String[] args) {
    String message = "It is pouring like cats and dogs outside";
    message = message + "and the lightining struck [";
    for (int i = 0; i <= 11; i++) {
      message = message + i + ",";
    }
    message = message + "]";
    System.out.println(message);
  }
}
