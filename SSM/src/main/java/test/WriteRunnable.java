package test;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by wangtianfeng on 2018/12/7.
 */
public class WriteRunnable implements Runnable {
    public BlockingQueue<String> queue;
    public WriteRunnable(BlockingQueue<String> queue){
        this.queue=queue;
    }
    @Override
    public void run() {
        while(true){

            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
