package net.atos.project;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteToAuthoFile
{
    private ParkingTicket parkingTicket;

    private TimeManager timeManager;

    private boolean authorisation = true;

    public WriteToAuthoFile(ParkingTicket parkingTicket, TimeManager timeManager)
    {
        this.parkingTicket = parkingTicket;
        this.timeManager = timeManager;
    }

    public void writeToFile()
    {
        PrintWriter authLog = null;
        do
        {
            try
            {
                authLog = new PrintWriter(new FileOutputStream("src/main/resources/ParkingTicketAuthorisation.txt",
                        true));

                authLog.println();
                authLog.print(parkingTicket.getUniqueId());
                authLog.print(", ");

                if (!parkingTicket.isPrePaid())
                {
                    authLog.print("D");
                    authLog.print(", ");
                }
                else
                {
                    authLog.print("O");
                    authLog.print(", ");
                }

                authLog.print(timeManager.getDate());
                authLog.print(", ");

                CreditCardPayment creditCard = new CreditCardPayment();
                creditCard.getCreditCard();

                authLog.print(creditCard.getUserCardNum());
                authLog.print(", ");
                authLog.print(creditCard.getUserCardExpiry());
                authLog.print(", ");

                CreditCardValidation validateCard = new CreditCardValidation(creditCard);

                if (!validateCard.isValid())
                {
                    System.out.println("Credit card invalid, re-enter details");
                    authLog.print("fail");
                    authLog.print(", ");
                    authLog.print("Credit Card Invalid");

                    setAuthorisation(false);
                }
                else
                {
                    System.out.println("Processing...");
                    authLog.print("pass");
                    authLog.print(", ");
                    authLog.print("n/a");

                    setAuthorisation(true);
                }
            }
            catch (IOException ioe)
            {
                System.out.println("Error Writing To Authorisation File");
                throw new RuntimeException(ioe);
            }
            finally
            {
                authLog.close();
            }

            System.out.println("Written To Authorisation File");
        }
        while (!getAuthorisation());

        System.out.println("End");
    }

    public void setAuthorisation(boolean authorisation)
    {
        this.authorisation = authorisation;
    }

    public boolean getAuthorisation()
    {
        return authorisation;
    }

}
