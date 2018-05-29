package com.mry.util;

import java.util.Calendar;

/**
 * Created by zyh on 2017/2/22.
 */
public class GetServiceExecutionIndexUtil {
    private int number;
    public int getIndex(int cycle,Calendar now,Calendar start){
        switch(cycle) {
            case 1:
                number = 1;
            case 2:
                number = 3;
            case 3:
                number = 12;
        }
        int nowYear=now.get(Calendar.YEAR);
        int startYear=start.get(Calendar.YEAR);
        int nowMonth=now.get(Calendar.MONTH);
        int startMonth=start.get(Calendar.MONTH);
        int index=((nowYear-startYear)*12+nowMonth + 1-startMonth+1)/number;
       // int index=((now.get(Calendar.YEAR)-start.get(Calendar.YEAR))*12+now.get(Calendar.MONTH) + 1-start.get(Calendar.MONTH)+1)/number;
        return index;
    }
}
