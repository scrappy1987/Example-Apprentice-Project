package net.atos.project;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class WriteToTicketLog
{
    private ParkingTicket parkingTicket;

    private LengthOfStayCalc timeStayed;

    private ChargeManager calcCharge;

    private TimeManager timeManager;

    public WriteToTicketLog(ParkingTicket parkingTicket, TimeManager timeManager, LengthOfStayCalc timeStayed,
            ChargeManager cop)
    {
        this.parkingTicket = parkingTicket;
        this.timeStayed = timeStayed;
        this.timeManager = timeManager;
        this.calcCharge = cop;
    }

    public void writeToFile()
    {
        DecimalFormat df = new DecimalFormat("00");
        PrintWriter ticketLog = null;

        try
        {
            ticketLog = new PrintWriter(new FileOutputStream("src/main/resources/ParkingTicket.txt", true));
            ticketLog.println();
            ticketLog.print(parkingTicket.getUniqueId());
            ticketLog.print(", ");
            ticketLog.print(parkingTicket.getRegNumber());
            ticketLog.print(", ");
            ticketLog.print(timeManager.getDate());
            ticketLog.print(", ");
            ticketLog.print(parkingTicket.getArrivalHour() + ":" + df.format(parkingTicket.getArrivalMin()));
            ticketLog.print(", ");
            ticketLog.print(timeManager.getPayHour() + ":" + df.format(timeManager.getPayMin()));
            ticketLog.print(", ");
            ticketLog.print(timeStayed.getLengthofStayHours() + ":" + df.format(timeStayed.getLengthofStayMins()));
            ticketLog.print(", ");
            ticketLog.print(String.format("%.2f", calcCharge.getCharge()));
        }
        catch (IOException ioe)
        {
            System.out.println("\n-Error Writing to Ticket Log-");
            throw new RuntimeException(ioe);
        }
        finally
        {
            ticketLog.close();
            System.out.println("-Written To Ticket Log-");
        }

    }
}
