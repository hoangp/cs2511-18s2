package tut07.exceptions;

public class LimitException extends Exception {
  private static final long serialVersionUID = 1L;

  public LimitException(String message) {
    super(message);
  }

}
