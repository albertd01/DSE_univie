import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        MyBlockingQueue<Integer> inputQueue = new MyBlockingQueue<>();
        MyBlockingQueue<HammingNumber> printQueue = new MyBlockingQueue<>();
        MyBlockingQueue<Integer> mult2Queue = new MyBlockingQueue<>();
        MyBlockingQueue<Integer> mult3Queue = new MyBlockingQueue<>();
        MyBlockingQueue<Integer> mult5Queue = new MyBlockingQueue<>();

        MyBlockingQueue<Integer> mergeInput = new MyBlockingQueue<>(3);

        Thread copyThread = new Thread(new Copy(inputQueue, mult2Queue, mult3Queue, mult5Queue, printQueue));
        Thread multBy2 = new Thread(new MultBy2(mult2Queue, mergeInput));
        Thread multBy3 = new Thread(new MultBy3(mult3Queue, mergeInput));
        Thread multBy5 = new Thread(new MultBy5(mult5Queue, mergeInput));
        Thread mergeThread = new Thread(new Merge(mergeInput, inputQueue));
        Thread printThread = new Thread(new Print(printQueue));

        inputQueue.offer(1);

        copyThread.start();
        multBy2.start();
        multBy3.start();
        multBy5.start();
        printThread.start();
        mergeThread.start();


    }
}
