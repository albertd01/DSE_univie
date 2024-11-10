package Bank;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class TransactionManager implements Runnable {
    private Queue<Runnable> pendingTransactions = new LinkedBlockingQueue<Runnable>();
    
    private Thread t;

    public TransactionManager(){
        this.createThread();
    }

    public void addPendingTransaction(Runnable transaction){
    	
        pendingTransactions.add(transaction);
    }

    @Override
    public void run() {
        while(true){
            Runnable currentTransaction = pendingTransactions.poll();
            if(currentTransaction!=null){
                Thread t = new Thread(currentTransaction);
                t.start();
            }
        }
    }

    private void createThread(){
        if(t==null){
            t= new Thread(this);
        }
        t.start();
    }
}
