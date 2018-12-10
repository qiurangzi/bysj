package test;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangtianfeng on 2018/12/5.
 */
public class test {
    public static void main(String[] args) throws IOException {
        long startTime=System.currentTimeMillis();
        String str  = null;
File file=new File("C:\\Users\\wangtianfeng\\Desktop\\ceshi - 副本.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));
        Queue<String> queue=new LinkedList<>();
        while((str = br.readLine()) != null){
            queue.offer(str);
        }
        br.close();
        long endTime = System.currentTimeMillis();
        double userTime = ((double)endTime - startTime)/1000;//执行时长<秒>
        System.out.println("\n"+String.format("执行完毕,共花时长:%s秒", userTime));//秒
    }
}
