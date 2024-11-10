import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Copy implements Runnable{
    private MyBlockingQueue<Integer> input;

    private MyBlockingQueue<Integer> output2;
    private MyBlockingQueue<Integer> output3;
    private MyBlockingQueue<Integer> output5;

    private MyBlockingQueue<HammingNumber> outputPrint;

    @Override
    public void run() {
        try{
            while(true){
                int currentValue = input.take();
                System.out.println(currentValue);
                HammingNumber output = new HammingNumber(currentValue);
                output2.offer(currentValue);
                output3.offer(currentValue);
                output5.offer(currentValue);
                outputPrint.offer(output);
            }
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    public Copy(MyBlockingQueue<Integer> input, MyBlockingQueue<Integer> output2, MyBlockingQueue<Integer> output3, MyBlockingQueue<Integer> output5, MyBlockingQueue<HammingNumber> outputPrint) {
        this.input = input;
        this.output2 = output2;
        this.output3 = output3;
        this.output5 = output5;
        this.outputPrint = outputPrint;
    }
}
