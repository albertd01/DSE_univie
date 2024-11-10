import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;

public class Merge implements Runnable{
    private MyBlockingQueue<Integer> mergeInput;
    private MyBlockingQueue<Integer> mergeOutput;



    public Merge(MyBlockingQueue<Integer> mergeInput, MyBlockingQueue<Integer> mergeOutput){
        this.mergeInput = mergeInput;
        this.mergeOutput = mergeOutput;
    }

    @Override
    public void run() {
        try {

            while (true) {
                mergeInput.awaitDistinctValues();
                synchronized (this){
                    Set<Integer> orderedNumbers = new TreeSet<>();
                    while (orderedNumbers.size()<3){
                        orderedNumbers.add(mergeInput.take());
                    }
                    for(int i : orderedNumbers){
                        mergeOutput.offer(i);
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

