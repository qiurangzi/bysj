package test;

import java.io.*;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by wangtianfeng on 2018/12/7.
 */
public class ReadRunnable implements Runnable {
    public BlockingQueue<String> queue;
    public String fileName="C:\\Users\\wangtianfeng\\Desktop\\ceshi - 副本.csv";
    public int count;
public ReadRunnable(BlockingQueue<String> queue)
{
    this.queue=queue;
}
    @Override
    public void run() {
        long startTime=System.currentTimeMillis();
        String str  = null;
        File file=new File(fileName);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            while((str = br.readLine()) != null){
                count++;
                queue.put(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("总计读取"+count+"条记录");
        long endTime = System.currentTimeMillis();
        double userTime = ((double)endTime - startTime)/1000;//执行时长<秒>
        System.out.println("\n"+String.format("read执行完毕,共花时长:%s秒", userTime));//秒
    }
}
