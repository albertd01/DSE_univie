import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
public class MultBy2 implements IMultBy, Runnable{

    private MyBlockingQueue<Integer> inputQueue;
    private MyBlockingQueue<Integer> outputQueue;

    public MultBy2(MyBlockingQueue<Integer> inputQueue, MyBlockingQueue<Integer> outputQueue) {
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
    }
    @Override
    public int multByN(int i) {
        return i*2;
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
