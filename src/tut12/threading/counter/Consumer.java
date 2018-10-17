package tut12.threading.counter;

/**
 * Producer Thread which implements Runnable. Attempts to add 100 times to the
 * shared UnsafeCounter.
 */
public class Consumer implements Runnable {
  private Counter counter;

  public Consumer(Counter counter) {
    this.counter = counter;
  }

  @Override
  public void run() {
    for (int i = 0; i < 1000000; i++) {
      counter.minus(1);
    }
  }
}