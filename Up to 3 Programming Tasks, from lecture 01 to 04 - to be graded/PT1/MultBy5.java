import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
public class MultBy5 implements IMultBy, Runnable{
    private MyBlockingQueue<Integer> inputQueue;
    private MyBlockingQueue<Integer> outputQueue;

    public MultBy5(MyBlockingQueue<Integer> inputQueue, MyBlockingQueue<Integer> outputQueue) {
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
    }
    @Override
    public int multByN(int i) {
        return i*5;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int value = inputQueue.take();
                outputQueue.offer(multByN(value));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
