package tut12.threading.boundedqueue;

/**
 * Created by red on 22-May-18.
 */
public class ThreadTester {

  public static void main(String[] args) {
    ThreadTester t = new ThreadTester();

    int test = 1;
    
    if (test == 1)
      t.testUnsafeQ();
    else if (test == 2)
      t.testSafeQ(); // Condition variables and locks.
    else
      t.testSyncQ(); // Synchronized queue.
  }

  private void testUnsafeQ() {
    BoundedQueue<Integer> q = new UnsynchronizedBoundedQueue<>(10);
    Thread t1 = new Thread(new Producer(1, 50, q));
    Thread t2 = new Thread(new Producer(51, 100, q));
    Thread t3 = new Thread(new Consumer(100, q));
    t1.start();
    t2.start();
    t3.start();
  }

  private void testSafeQ() {
    BoundedQueue<Integer> q = new SafeBoundedQueue<>(10);
    Thread t1 = new Thread(new Producer(1, 50, q));
    Thread t2 = new Thread(new Producer(51, 100, q));
    Thread t3 = new Thread(new Consumer(100, q));
    t1.start();
    t2.start();
    t3.start();
  }

  private void testSyncQ() {
    BoundedQueue<Integer> q = new SynchronizedBoundedQueue<>(10);
    Thread t1 = new Thread(new Producer(1, 50, q));
    Thread t2 = new Thread(new Producer(51, 100, q));
    Thread t3 = new Thread(new Consumer(100, q));
    t1.start();
    t2.start();
    t3.start();
  }
}
