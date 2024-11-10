import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class Print implements Runnable{
    private MyBlockingQueue<HammingNumber> inputQueue;


    public Print(MyBlockingQueue<HammingNumber> inputQueue) {
        this.inputQueue = inputQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                HammingNumber value = inputQueue.take();
                if(value.getValue()<0){
                    System.exit(-1);
                }
                System.out.println(value.getValue());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
