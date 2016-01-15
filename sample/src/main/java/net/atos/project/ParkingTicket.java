package net.atos.project;

import java.util.UUID;

public class ParkingTicket
{
    private String regNumber;

    private int arrivalHour;

    private int arrivalMin;

    private boolean prePaid;

    private int expiryHour;

    private int expiryMin;

    private UUID uniqueId;

    public void setUniqueId()
    {
        this.uniqueId = UUID.randomUUID();
    }

    public UUID getUniqueId()
    {
        return uniqueId;
    }

    public String getRegNumber()
    {
        return regNumber;
    }

    public void setRegNumber(String regNumber)
    {
        this.regNumber = regNumber;
    }

    public int getArrivalHour()
    {
        return arrivalHour;
    }

    public void setArrivalHour(int arrivalHour)
    {
        this.arrivalHour = arrivalHour;
    }

    public int getArrivalMin()
    {
        return arrivalMin;
    }

    public void setArrivalMin(int arrivalMin)
    {
        this.arrivalMin = arrivalMin;
    }

    public int getExpiryHour()
    {
        return expiryHour;
    }

    public void setExpiryHour(int expiryHour)
    {
        this.expiryHour = expiryHour;
    }

    public int getExpiryMin()
    {
        return expiryMin;
    }

    public void setExpiryMin(int expiryMin)
    {
        this.expiryMin = expiryMin;
    }

    public boolean isPrePaid()
    {
        return prePaid;
    }

    public void setIsPrePaid(boolean prePaid)
    {
        this.prePaid = prePaid;
    }
}
