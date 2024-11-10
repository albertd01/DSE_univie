import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;

public class MyBlockingQueue<T> {
    private Queue<T> queue;
    private Set<T> distinctValues;
    private CountDownLatch latch;

    public MyBlockingQueue(int distinctCount) {
        this.queue = new LinkedList<>();
        this.distinctValues = new HashSet<>();
        this.latch = new CountDownLatch(distinctCount);
    }

    public MyBlockingQueue() {
        this.queue = new LinkedList<>();
        this.distinctValues = new HashSet<>();
        this.latch = new CountDownLatch(0);
    }

    public synchronized void offer(T item) throws InterruptedException {
        boolean isNew = distinctValues.add(item);
        if (isNew) {
            latch.countDown();
        }
        queue.offer(item);
        notifyAll();
    }

    public synchronized T take() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        T item = queue.poll();
        notifyAll();
        return item;
    }

    public int size() {
        synchronized (this) {
            return queue.size();
        }
    }

    public void awaitDistinctValues() throws InterruptedException {
        latch.await();
        resetLatch();
    }
    private void resetLatch(){
        distinctValues.clear();
        latch = new CountDownLatch((int)latch.getCount());
    }

}