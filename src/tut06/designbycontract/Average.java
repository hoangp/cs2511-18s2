package tut06.designbycontract;

public class Average {
  private static double average(double[] nums) {
    double sum = 0;
    for (double x : nums) {
      sum += x;
    }
    return sum/nums.length;
  }

  public static void main(String[] args) {
    double[] numArray = {1.9, 2.8, 3.7, 4.6, 5.5};
    System.out.println(average(numArray));
  }
}
