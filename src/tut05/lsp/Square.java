package tut05.lsp;

public class Square extends Rectangle {

  public Square(String color) {
    super(color);
  }

  @Override
  public void setWidth(int aWidth) {
    super.setWidth(aWidth);
    super.setHeight(aWidth);
  }

  @Override
  public void setHeight(int aHeight) {
    super.setWidth(aHeight);
    super.setHeight(aHeight);
  } 

  public static void main(String[] args) {
    Square s = new Square("green");
    s.setHeight(10);
    
    System.out.println(s.getArea()); // 100

    Rectangle r = s;
    r.setWidth(10);
    r.setHeight(5);

    System.out.println(r.getArea()); // ??

  }
}
