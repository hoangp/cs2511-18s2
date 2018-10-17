package tut12.threading.counter;

public interface Counter {
  void add(long value);
  void minus(long value);
  long getCount();
}
