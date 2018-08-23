package tut01;

public class HelloWorld {
  private String greeting;
  
  public void setGreeting(String greeting) {
    this.greeting = greeting;
  }

  public static void main(String[] args) {
    // System.out.println("Hello to the world");

    HelloWorld australian = new HelloWorld();
    australian.setGreeting("Gooday!!");
    
    HelloWorld french = new HelloWorld();
    french.setGreeting("Bonjour!!");
    
    System.out.println(australian.greeting);
    System.out.println(french.greeting);
  }
}
