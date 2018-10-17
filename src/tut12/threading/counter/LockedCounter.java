package tut12.threading.counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Thread Safe Counter class which uses Locks to Synchronize.
 */
public class LockedCounter implements Counter {
    private long count = 0;
    private Lock counterLock = new ReentrantLock();

    @Override
    public void add(long value) {
        counterLock.lock();
        count += value;
        counterLock.unlock();
    }

    @Override
    public long getCount() {
        return count;
    }

    @Override
    public void minus(long value) {
      counterLock.lock();
      count -= value;
      counterLock.unlock();
    }
}
