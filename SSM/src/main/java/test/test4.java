package test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by wangtianfeng on 2018/12/6.
 */
public class test4 {
    /**
     * 生成查询实际投放数据sql
     */
    public static void main(String[] args) throws IOException {
        querySendData();
    }
    private static void querySendData() {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null;
        Calendar c = null;
        String startDate = null;
        String endDate = null;
        try {
            beginDate = sdf.parse("2018-10-01");
            c = Calendar.getInstance();
            c.setTime(beginDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 5; i++) {
            startDate = sdf.format(c.getTime());
            c.add(Calendar.DATE, 1);
            endDate = sdf.format(c.getTime());
            String sql = "SELECT CGP_ID,COUNT(*),SUM(PRICE) \r\n" + "	FROM BID_ACT_RESULT\r\n"
                    + "	WHERE      WIN_TIME BETWEEN TO_DATE('" + startDate
                    + " 00:00:00','YYYY-MM-DD HH24:MI:SS') AND TO_DATE('" + endDate
                    + " 00:00:00','YYYY-MM-DD HH24:MI:SS')\r\n"
                    + "	      AND PHONE_NUM IN(SELECT PHONE_NUM  FROM  OPENAPI_FREQ_BLCOK    WHERE CHANNEL_ID ='CMPP_LECHENG' AND\r\n"
                    + "	        INSERT_TIME between to_date('" + startDate
                    + " 00:00:00','yyyy-mm-dd hh24:mi:ss') and to_date('" + endDate
                    + " 00:00:00','yyyy-mm-dd hh24:mi:ss')\r\n" + "	      )\r\n" + "	GROUP BY CGP_ID\r\n"
                    + "	ORDER BY CGP_ID;";

            System.out.println("--查询第" + i + "天");
            System.out.println(sql);

        }
    }
}
