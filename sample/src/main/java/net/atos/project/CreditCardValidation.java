package net.atos.project;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CreditCardValidation
{
    private CreditCardPayment creditCard;

    public CreditCardValidation(CreditCardPayment creditCard)
    {
        this.creditCard = creditCard;
    }

    public boolean isValid()
    {
        DateFormat formatDate = new SimpleDateFormat("MMyy");
        Calendar currentDate = Calendar.getInstance();
        currentDate.set(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), 0, 23, 59, 59);

        try
        {
            java.util.Date expire = formatDate.parse(creditCard.getUserCardExpiry());

            if (expire.before(currentDate.getTime()))
                return false;
            if (creditCard.getUserCardExpiry().length() != 4)
                return false;
            if (!cardNumberContainsChar())
                return false;
            if (!cardIsCorrectLength())
                return false;
        }
        catch (java.text.ParseException e)
        {
            return false;
        }

        return true;
    }

    public boolean cardNumberContainsChar()
    {
        return creditCard.getUserCardNum().matches("[0-9]+");
    }

    public boolean cardIsCorrectLength()
    {
        return creditCard.getUserCardNum().length() == 16;
    }

}
