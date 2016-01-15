package net.atos.project;

public enum Charges
{
    WD_UPTO1HR(
            4.70),
    WD_UPTO2HR(
            7.40),
    WD_UPTO4HR(
            10.30),
    WD_UPTO6HR(
            14.80),
    WD_UPTO9HR(
            17.80),
    WD_UPTO12HR(
            20.20),
    WD_UPTO24HR(
            23.70),
    WE_UPTO2HR(
            4.40),
    WE_UPTO6HR(
            7.40),
    WE_UPTO24HR(
            12.00),
    OVR_DISCOUNT(
            0.90);

    private double charge;

    private Charges(double charge)
    {
        this.charge = charge;
    }

    double getCharge()
    {
        return charge;
    }
}
