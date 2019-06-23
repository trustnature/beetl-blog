package com.ibeetl.blog.function;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author GavinKing
 * @ClassName: PrintTimeUtil
 * @Description:
 * @date 2018/12/11
 */
public class PrintTimeUtil {

    public static String printTime(Date date,String format){

        Date now = new Date();
        Long fiveM = date.getTime() + (5*60*1000);
        Long thM = date.getTime() + (30*60*1000);
        Long oneH = date.getTime() + (60*60*1000);
        if(now.getTime() < fiveM){
            return "刚刚";
        }
        if(now.getTime() < thM){
            return "半小时前";
        }
        if(now.getTime() < oneH){
            return "一小时前";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);

        return sdf.format(date);
    }
}
