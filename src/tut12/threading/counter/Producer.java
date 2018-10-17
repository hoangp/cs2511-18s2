package tut12.threading.counter;

/**
 * Producer Thread which implements Runnable. Attempts to add 100 times to the
 * shared UnsafeCounter.
 */
public class Producer implements Runnable {
  private Counter counter;

  public Producer(Counter counter) {
    this.counter = counter;
  }

  @Override
  public void run() {
    for (int i = 0; i < 1000000; i++) {
      counter.add(1);
    }
  }
}



























//public void runWithSleep() {
//try {
//for (int i = 0; i < 10000; i++) {
//  counter.add(1);
//  Thread.sleep(10);
//}
//} catch (InterruptedException e) {
//System.err.println("Thread was interrupted.");
//}
//}
