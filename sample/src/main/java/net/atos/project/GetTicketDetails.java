package net.atos.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetTicketDetails
{
    public static void main(String[] args)
    {
        GetTicketDetails cd = new GetTicketDetails();
        cd.readTicket(args);
    }

    public void readTicket(String[] args)
    {
        BufferedReader ticketTest = null;
        String line = "";

        try
        {
            ticketTest = new BufferedReader(new FileReader("src/test/resources/TicketTesting.txt"));

            while ((line = ticketTest.readLine()) != null)
            {
                String[] ticket = line.split(", ");

                ParkingTicket parkingTicket = new ParkingTicket();
                parkingTicket.setUniqueId();

                TicketValidation ticketValidation = new TicketValidation(ticket, parkingTicket);
                ticketValidation.validateTicket();

                if (ticketValidation.getIsValid())
                {
                    TransactionManager newTransaction = new TransactionManager(parkingTicket);
                    newTransaction.processTicket();
                }
                else if (!ticketValidation.getIsValid())
                {
                    System.out.println("");
                    System.out.println("Error with ticket! " + ticketValidation.getErrorReporting());
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            throw new RuntimeException();
        }
        finally
        {
            if (ticketTest != null)
            {
                try
                {
                    ticketTest.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                    throw new RuntimeException();
                }
            }
        }

        System.out.println("\nDone");
    }
}
