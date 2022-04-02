package com.example.thebaber.Models;

import java.util.Date;

public class DateConvert {
    Date date;

    public DateConvert(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        String FormatDay="";
        int i  = date.getDay();
        Date tempDate = new Date();
        int currentDay = tempDate.getDay();
        if(date.getDate()==tempDate.getDate())
        {
            FormatDay = "Hôm nay, ";
        }
        if(i==1)
        {
            FormatDay +="Thứ 2";
        }
        else if(i==2)
        {
            FormatDay +="Thứ 3";
        }
        else if(i==3)
        {
            FormatDay +="Thứ 4";
        }
        else if(i==4)
        {
            FormatDay +="Thứ 5";
        }
        else if(i==5)
        {
            FormatDay +="Thứ 6";
        }
        else if(i==6)
        {
            FormatDay +="Thứ 7";
        }
        else
        {
            FormatDay +="Chủ nhật";
        }
        String mDate = String.valueOf(date.getDate());
        String mMonth = String.valueOf(date.getMonth()+1);
        return FormatDay+" ("+mDate+"/"+mMonth+")";
    }
}
