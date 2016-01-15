package net.atos.project;

public class TransactionManager
{
    private ParkingTicket parkingTicket;

    public TransactionManager(ParkingTicket parkingTicket)
    {
        this.parkingTicket = parkingTicket;
    }

    public void processTicket()
    {
        TimeManager timeManager = new TimeManager();

        LengthOfStayCalc timeStayed = new LengthOfStayCalc(parkingTicket, timeManager);
        timeStayed.calcLengthofstay();

        ChargeManager calcCharge = new ChargeManager(parkingTicket, timeManager, timeStayed);
        calcCharge.calcCostOfStay();

        TransactionDisplay consoleDisplay = new TransactionDisplay(timeStayed, parkingTicket, calcCharge);
        consoleDisplay.writeToConsole();

        WriteToTicketLog ticketlogFile = new WriteToTicketLog(parkingTicket, timeManager, timeStayed, calcCharge);
        ticketlogFile.writeToFile();

        if (calcCharge.getCharge() > 0)
        {
            WriteToAuthoFile authorisationFile = new WriteToAuthoFile(parkingTicket, timeManager);
            authorisationFile.writeToFile();
        }
    }
}
