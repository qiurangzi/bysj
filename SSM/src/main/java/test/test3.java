package test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * Created by wangtianfeng on 2018/12/6.
 */
public class test3 {
    public static void main(String[] args) throws IOException {

        ExecutorService service= Executors.newFixedThreadPool(5);
        BlockingQueue<String> queue=new LinkedBlockingQueue<>();
        //读
        ReadRunnable read=new ReadRunnable(queue);
        service.submit(read);
        //写
        WriteRunnable write=new WriteRunnable(queue);
        service.submit(write);
        service.shutdown();


    }
    }
