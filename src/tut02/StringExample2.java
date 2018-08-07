package tut02;

/**
 * An example to understand that Java Strings are immutable
 * 
 * @author Aarthi N
 */
public class StringExample2 {
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder(200);
    sb.append("It is pouring like cats and dogs outside");
    sb.append("and the lightining struck [");
    for (int i = 0; i <= 11; i++) {
      sb.append(i).append(",");
    }
    sb.append("]");
    String result = new String(sb);
    System.out.println(result);
  }
}
