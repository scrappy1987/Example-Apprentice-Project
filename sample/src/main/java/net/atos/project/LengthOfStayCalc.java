package net.atos.project;

public class LengthOfStayCalc
{
    private int lengthofstayHours;

    private int lengthofstayMins;

    private TimeManager timeManager;

    private ParkingTicket parkingTicket;

    public LengthOfStayCalc(ParkingTicket parkingTicket, TimeManager timeManager)
    {
        this.timeManager = timeManager;
        this.parkingTicket = parkingTicket;
    }

    public void calcLengthofstay()
    {
        this.lengthofstayHours = timeManager.getPayHour() - parkingTicket.getArrivalHour();
        this.lengthofstayMins = timeManager.getPayMin() - parkingTicket.getArrivalMin();

        if (this.lengthofstayMins < 0)
        {
            this.lengthofstayMins += 60;
            this.lengthofstayHours--;
        }

        if (this.lengthofstayHours < 0 || this.lengthofstayHours == 0 && this.lengthofstayMins < 1)
        {
            this.lengthofstayHours += 24;
        }
    }

    public int getLengthofStayMins()
    {
        return lengthofstayMins;
    }

    public int getLengthofStayHours()
    {
        return lengthofstayHours;
    }
}
