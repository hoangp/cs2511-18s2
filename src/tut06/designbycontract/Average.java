package tut06.designbycontract;

public class Average {
  private double average(double[] nums) {
    double sum = 0;
    for (double x : nums) {
      sum += x;
    }
    return sum / nums.length;
  }

  public static void main(String[] args) {
    Average a = new Average();
    double[] numArray = { 0 };
    System.out.println(a.average(numArray));
  }
}
