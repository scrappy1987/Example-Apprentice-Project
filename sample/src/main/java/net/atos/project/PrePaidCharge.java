package net.atos.project;

import java.util.Calendar;

public class PrePaidCharge
{
    double charge;

    private TimeManager timeManager;

    private CalcOverstayedTime overstayedTime;

    public PrePaidCharge(double charge, TimeManager timeManager, CalcOverstayedTime overstayedTime)
    {
        this.charge = charge;
        this.timeManager = timeManager;
        this.overstayedTime = overstayedTime;
    }

    public void prePaidOverstayedCharge()
    {
        String concatTime = overstayedTime.getOverstayedHours() + "." + overstayedTime.getOverstayedMins();
        double totalTime = Double.parseDouble(concatTime);
        totalTime = Math.ceil(totalTime);

        if (totalTime > 0)
        {
            if (isWeekday())
            {
                overstayedWeekdayCharge(totalTime);
            }
            else
            {
                overstayedWeekendCharge(totalTime);
            }
        }
    }

    public void overstayedWeekdayCharge(double totalTime)
    {
        if (totalTime <= 1)
        {
            charge = Charges.WD_UPTO1HR.getCharge() * Charges.OVR_DISCOUNT.getCharge();
        }
        else if (totalTime <= 2)
        {
            charge = Charges.WD_UPTO2HR.getCharge() * Charges.OVR_DISCOUNT.getCharge();
        }
        else if (totalTime <= 4)
        {
            charge = Charges.WD_UPTO4HR.getCharge() * Charges.OVR_DISCOUNT.getCharge();
        }
        else if (totalTime <= 6)
        {
            charge = Charges.WD_UPTO6HR.getCharge() * Charges.OVR_DISCOUNT.getCharge();
        }
        else if (totalTime <= 9)
        {
            charge = Charges.WD_UPTO9HR.getCharge() * Charges.OVR_DISCOUNT.getCharge();
        }
        else if (totalTime <= 12)
        {
            charge = Charges.WD_UPTO12HR.getCharge() * Charges.OVR_DISCOUNT.getCharge();
        }
        else if (totalTime <= 24)
        {
            charge = Charges.WD_UPTO24HR.getCharge() * Charges.OVR_DISCOUNT.getCharge();
        }
    }

    public void overstayedWeekendCharge(double totalTime)
    {
        if (totalTime <= 2)
        {
            charge = Charges.WE_UPTO2HR.getCharge() * Charges.OVR_DISCOUNT.getCharge();
        }
        else if (totalTime <= 6)
        {
            charge = Charges.WE_UPTO6HR.getCharge() * Charges.OVR_DISCOUNT.getCharge();
        }
        else if (totalTime <= 24)
        {
            charge = Charges.WE_UPTO24HR.getCharge() * Charges.OVR_DISCOUNT.getCharge();
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
