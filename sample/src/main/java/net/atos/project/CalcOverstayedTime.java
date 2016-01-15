package net.atos.project;

public class CalcOverstayedTime
{
    private int overstayedHours;

    private int overstayedMins;

    private ParkingTicket parkingTicket;

    private TimeManager timeManager;

    public CalcOverstayedTime(ParkingTicket parkingTicket, TimeManager timeManager)
    {
        this.parkingTicket = parkingTicket;
        this.timeManager = timeManager;
    }

    public void calcOverstayedTime()
    {
        overstayedHours = timeManager.getPayHour() - parkingTicket.getExpiryHour();
        overstayedMins = timeManager.getPayMin() - parkingTicket.getExpiryMin();

        if (overstayedMins < 0)
        {
            overstayedMins = 0;
            overstayedHours--;
        }
    }

    public int getOverstayedHours()
    {
        return overstayedHours;
    }

    public int getOverstayedMins()
    {
        return overstayedMins;
    }

}
