package test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangtianfeng on 2018/12/6.
 */
public class test2 {
    public static void main(String[] args) throws IOException {
        long startTime=System.currentTimeMillis();
        BufferedReader br=new BufferedReader(
                new InputStreamReader(new FileInputStream("C:/Users/wangtianfeng/Desktop/ceshi.csv"))
        );
        String line;
        String id;
        String name;
        List<String> li=new ArrayList<>();
        while((line=br.readLine())!=null){
           String[] info=line.split(",");
            id=new String(info[0].trim());
            name=new String(info[1].trim());
            li.add(new StringBuilder().append(id).append(",").append(name).toString());
        }
        String[] csvName = new String[22];
        for (int i = 0; i < csvName.length; i++) {
            csvName[i] = new StringBuilder().append("D:/test/ld").append(i+1).append(".csv").toString();
        }
        System.out.println("11个文件名名称分别为-->");
        for (int i = 0; i < csvName.length; i++) {
            System.out.print(csvName[i]+"\n");
        }

        //3.将集合数据导出到11个小CSV文件中
        boolean[] allSuccess = new boolean[csvName.length];
        for(int i = 1; i<=csvName.length;i++){
            boolean isSuccess = false;
            //每次导出一万条数据到CSV文件
            if(i ==22){
                isSuccess=exportCsv(new File(csvName[i-1]), li.subList((i-1)*50000, li.size()));
            }else{
                isSuccess=exportCsv(new File(csvName[i-1]), li.subList((i-1)*50000, i*50000));
            }
            allSuccess[i-1] = isSuccess;
        }

        //打印11个文件每次数据导出成功与否
        System.out.println("11个文件每次数据导出成功与否-->");
        for (int i = 0; i < allSuccess.length; i++) {
            System.out.print(allSuccess[i]+",");
        }

        long endTime = System.currentTimeMillis();    //获取结束时间
        double userTime = ((double)endTime - startTime)/1000;//执行时长<秒>
        System.out.println("\n"+String.format("执行完毕,共花时长:%s秒", userTime));//秒

    }
    public static boolean exportCsv(File file, List<String> dataList){
        boolean isSucess=false;

        FileOutputStream out=null;
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;
        try {
            out = new FileOutputStream(file);
            osw = new OutputStreamWriter(out,"UTF-8");//设置输出编码方式为UTF-8
            //加上UTF-8文件的标识字符
            osw.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB,(byte) 0xBF }));

            bw =new BufferedWriter(osw);
            if(dataList!=null && !dataList.isEmpty()){
                for(String data : dataList){
                    bw.append(data).append("\r");
                }
            }
            isSucess=true;
        } catch (Exception e) {
            isSucess=false;
        }finally{
            if(bw!=null){
                try {
                    bw.close();
                    bw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(osw!=null){
                try {
                    osw.close();
                    osw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                    out=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return isSucess;
    }

    }
