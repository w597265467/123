package file;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final String DEFULT_PATTERN = "yyyyMMddHHmmss";
    public static final String NORMAL_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DAY_PATTERN = "yyyyMMdd";

    public static String getNowTime(){
        Date date = new Date();
        return dateFormat(date ,DEFULT_PATTERN);
    }

    /**
     * yyyyMMddHHmmss
     * @param pattern
     * @return
     */
    public static String getNowTime(String pattern){
        Date date = new Date();
        return dateFormat(date ,pattern);
    }

    public static String dateFormat(Date date,String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String dateStr = sdf.format(date);
        return dateStr;
    }
    public static String dateFormat(Date date){
       return dateFormat(date,DEFULT_PATTERN);
    }

}
