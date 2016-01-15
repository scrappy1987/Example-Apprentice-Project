package net.atos.project;

import java.util.Scanner;

public class CreditCardPayment
{
    private String userCardNum;

    private String userCardExpiry;

    public void getCreditCard()
    {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Card Transaction");

        System.out.println("Enter A Valid Credit Card Number:");
        userCardNum = userInput.nextLine();

        System.out.println("Expiry Date (MMYY):");
        userCardExpiry = userInput.next();
    }

    public String getUserCardNum()
    {
        return userCardNum;
    }

    public String getUserCardExpiry()
    {
        return userCardExpiry;
    }
}
