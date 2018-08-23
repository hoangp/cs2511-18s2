package tut03.equals;

/**
 * This class demonstrates an incorrect definition of equals()
 */
public class Point {
  int x; int y;
  
  public Point(int x, int y) {
    this.x = x; this.y = y;
  }
 
  public boolean equals(Point obj) {
    return (this.x == obj.x) && (this.y == obj.y);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Point other = (Point) obj;
    if (x != other.x) return false;
    if (y != other.y) return false;
    return true;
  }

  public static void main(String[] args) {
    Point p1 = new Point(1, 2);
    Point p2 = new Point(1, 2);

    System.out.println(p1.equals(p2)); // true

    Object p3 = p2;
    System.out.println(p3.equals(p1)); // false. WHY?
  } 
}
