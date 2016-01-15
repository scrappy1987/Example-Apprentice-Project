package net.atos.project;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeManager
{
    private int payHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

    private int payMin = Calendar.getInstance().get(Calendar.MINUTE);

    private int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

    private Date date = new Date();

    SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");

    public int getPayHour()
    {
        return payHour;
    }

    public int getPayMin()
    {
        return payMin;
    }

    public String getDate()
    {
        return formatDate.format(date);
    }

    public int getCurrentDay()
    {
        return currentDay;
    }
}
