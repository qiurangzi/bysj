package test;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by wangtianfeng on 2018/12/7.
 */
public class test31 {
    public static void main(String[] args) throws IOException {
        BlockingQueue<String> queue=new LinkedBlockingQueue<>();
        ReadRunnable read=new ReadRunnable(queue);
        read.run();


    }
}
