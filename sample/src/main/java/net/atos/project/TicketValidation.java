package net.atos.project;

public class TicketValidation
{
    ParkingTicket parkingTicket;

    private String[] ticket;

    private boolean isValid = true;

    private StringBuilder validationErrors = new StringBuilder();

    public TicketValidation(String[] ticket, ParkingTicket parkingTicket)
    {
        this.ticket = ticket;
        this.parkingTicket = parkingTicket;
    }

    public void validateTicket()
    {
        validateArguments();
        validateRegNumber();
        validateArrivalHour();
        validateArrivalMin();
        validateIsPrePaid();
        validateExpiryHour();
        validateExpiryMin();
        validatePrePaidHour();
    }

    public void validateArguments()
    {
        if (ticket.length > 8)
        {
            validationErrors.append(" Incorrect number of arguments,");
            setIsValid(false);
        }
    }

    public void validateRegNumber()
    {
        if (ticket[0].length() > 7)
        {
            validationErrors.append(" Invalid Number Plate,");
            setIsValid(false);
        }
        else
        {
            parkingTicket.setRegNumber(ticket[0]);
        }
    }

    public void validateArrivalHour()
    {
        if (Integer.parseInt(ticket[1]) < 1 || Integer.parseInt(ticket[1]) > 24)
        {
            validationErrors.append(" Invalid arrival hour,");
            setIsValid(false);
        }
        else
        {
            parkingTicket.setArrivalHour(Integer.parseInt(ticket[1]));
        }
    }

    public void validateArrivalMin()
    {
        if (Integer.parseInt(ticket[2]) < 0 || Integer.parseInt(ticket[2]) > 60)
        {
            validationErrors.append(" Invalid arrival min,");
            setIsValid(false);
        }
        else
        {
            parkingTicket.setArrivalMin(Integer.parseInt(ticket[2]));
        }
    }

    public void validateIsPrePaid()
    {
        if (!"y".equalsIgnoreCase(ticket[3]) && !"n".equalsIgnoreCase(ticket[3]))
        {
            validationErrors.append(" Invalid input format,");
            setIsValid(false);
        }

        if ("n".equalsIgnoreCase(ticket[3]))
        {
            parkingTicket.setIsPrePaid(false);
        }
        else
        {
            parkingTicket.setIsPrePaid(true);
        }
    }

    public void validateExpiryHour()
    {
        if (Integer.parseInt(ticket[4]) < 0 || Integer.parseInt(ticket[4]) > 24)
        {
            validationErrors.append(" Invalid expiry hour,");
            setIsValid(false);
        }
        else
        {
            parkingTicket.setExpiryHour(Integer.parseInt(ticket[4]));
        }
    }

    public void validateExpiryMin()
    {
        if (Integer.parseInt(ticket[5]) < 0 || Integer.parseInt(ticket[5]) > 60)
        {
            validationErrors.append(" Invalid expiry min,");
            setIsValid(false);
        }
        else
        {
            parkingTicket.setExpiryMin(Integer.parseInt(ticket[4]));
        }
    }

    private void validatePrePaidHour()
    {
        if (parkingTicket.isPrePaid())
        {
            if (Integer.parseInt(ticket[1]) > Integer.parseInt(ticket[4]))
            {
                validationErrors.append(" Invalid expiry time for pre paid ticket,");
                setIsValid(false);
            }
        }
    }

    public void setIsValid(boolean isValid)
    {
        this.isValid = isValid;
    }

    public boolean getIsValid()
    {
        return isValid;
    }

    public StringBuilder getErrorReporting()
    {
        return validationErrors;
    }
}
