package tut12.threading.counter;

/**
 * Thread safe Counter which utilizes Java's synchronized keyword.
 */
public class SynchronizedCounter implements Counter {
    private long count = 0;

    @Override
    public void add(long value) {
    	synchronized(this) {
    		count += value;
    	}
    }

    @Override
    public long getCount() {
        return count;
    }

    @Override
    public void minus(long value) {
      synchronized(this) {
        count -= value;
      }
    }
}
