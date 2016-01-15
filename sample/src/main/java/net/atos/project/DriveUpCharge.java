package net.atos.project;

import java.util.Calendar;

public class DriveUpCharge
{
    private LengthOfStayCalc timeStayed;

    private TimeManager timeManager;

    private double charge;

    public DriveUpCharge(LengthOfStayCalc timeStayed, double charge, TimeManager timeManager)
    {
        this.timeStayed = timeStayed;
        this.charge = charge;
        this.timeManager = timeManager;
    }

    public void driveUpCharge()
    {
        String concatTime = timeStayed.getLengthofStayHours() + "." + timeStayed.getLengthofStayMins();
        double totalTime = Double.parseDouble(concatTime);
        totalTime = Math.ceil(totalTime);

        if (totalTime > 0)
        {
            if (isWeekday())
            {
                weekdayCharge(totalTime);
            }
            else
            {
                weekendCharge(totalTime);
            }
        }
    }

    public void weekdayCharge(double totalTime)
    {
        if (totalTime <= 1)
        {
            charge = Charges.WD_UPTO1HR.getCharge();
        }
        else if (totalTime <= 2)
        {
            charge = Charges.WD_UPTO2HR.getCharge();
        }
        else if (totalTime <= 4)
        {
            charge = Charges.WD_UPTO4HR.getCharge();
        }
        else if (totalTime <= 6)
        {
            charge = Charges.WD_UPTO6HR.getCharge();
        }
        else if (totalTime <= 9)
        {
            charge = Charges.WD_UPTO9HR.getCharge();
        }
        else if (totalTime <= 12)
        {
            charge = Charges.WD_UPTO12HR.getCharge();
        }
        else if (totalTime <= 24)
        {
            charge = Charges.WD_UPTO24HR.getCharge();
        }

    }

    public void weekendCharge(double totalTime)
    {
        if (totalTime <= 2)
        {
            charge = Charges.WE_UPTO2HR.getCharge();
        }
        else if (totalTime <= 6)
        {
            charge = Charges.WE_UPTO6HR.getCharge();
        }
        else if (totalTime <= 24)
        {
            charge = Charges.WE_UPTO24HR.getCharge();
        }
    }

    public boolean isWeekday()
    {
        return timeManager.getCurrentDay() >= Calendar.MONDAY && timeManager.getCurrentDay() <= Calendar.FRIDAY;
    }

    public double getCharge()
    {
        return charge;
    }
}
