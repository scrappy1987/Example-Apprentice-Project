package net.atos.project;

public class ChargeManager
{
    private ParkingTicket parkingTicket;

    private LengthOfStayCalc timeStayed;

    private double charge;

    private TimeManager timeManager;

    public ChargeManager(ParkingTicket parkingTicket, TimeManager timeManager, LengthOfStayCalc timeStayed)
    {
        this.timeStayed = timeStayed;
        this.parkingTicket = parkingTicket;
        this.timeManager = timeManager;
    }

    public void calcCostOfStay()
    {
        if (parkingTicket.isPrePaid())
        {
            CalcOverstayedTime overstayedTime = new CalcOverstayedTime(parkingTicket, timeManager);
            overstayedTime.calcOverstayedTime();

            PrePaidCharge prepaidTransaction = new PrePaidCharge(charge, timeManager, overstayedTime);
            prepaidTransaction.prePaidOverstayedCharge();
            this.charge = prepaidTransaction.getCharge();
        }
        else
        {
            DriveUpCharge driveupTransaction = new DriveUpCharge(timeStayed, charge, timeManager);
            driveupTransaction.driveUpCharge();
            this.charge = driveupTransaction.getCharge();
        }
    }

    public double getCharge()
    {
        return charge;
    }
}
