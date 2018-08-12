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
    return (this == obj);
  }

//  @Override
//  public boolean equals(Object obj) {
//    if (this == obj) return true;
//    if (obj == null) return false;
//    
//    if (!(obj instanceof Point)) return false;
//    Point o = (Point) obj;
//    if (this.x != o.x) return false;
//    if (this.y != o.y) return false;
//    
//    return true;
//  }

  public static void main(String[] args) {
    Point p1 = new Point(1, 2);
    Point p2 = new Point(1, 2);

    System.out.println(p1.equals(p2)); // true

    Object p3 = p2;
    System.out.println(p3.equals(p1)); // false. WHY?
    System.out.println(p1.equals(p3));
  } 
}
