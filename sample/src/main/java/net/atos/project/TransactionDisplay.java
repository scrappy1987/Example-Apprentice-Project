package net.atos.project;

public class TransactionDisplay
{
    private LengthOfStayCalc timeStayed;

    private ParkingTicket parkingTicket;

    private ChargeManager calcCharge;

    public TransactionDisplay(LengthOfStayCalc timeStayed, ParkingTicket parkingTicket, ChargeManager calcCharge)
    {
        this.timeStayed = timeStayed;
        this.parkingTicket = parkingTicket;
        this.calcCharge = calcCharge;
    }

    public void writeToConsole()
    {
        System.out.println("\nTransaction: " + parkingTicket.getUniqueId());
        System.out.println("Registration Number: " + parkingTicket.getRegNumber());

        if (timeStayed.getLengthofStayHours() <= 1)
        {
            System.out.println("Length Of Stay: " + timeStayed.getLengthofStayHours() + " hour and "
                    + timeStayed.getLengthofStayMins() + " minutes");
        }
        else
        {
            System.out.println("Length Of Stay: " + timeStayed.getLengthofStayHours() + " hours and "
                    + timeStayed.getLengthofStayMins() + " minutes");
        }

        System.out.println("Amount Due: £" + String.format("%.2f", calcCharge.getCharge()));
    }
}
