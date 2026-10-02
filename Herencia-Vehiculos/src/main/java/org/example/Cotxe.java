package org.example;

public class Cotxe extends Vehicle{
    public double SUMPLEMENT_AUTOMATIC_DIA;
    private int places;
    private boolean automatic;

    public Cotxe(
            String matricula,
            String marca,
            String model,
            double preuDia,
            int places,
            boolean automatic
    )
    {
        super(matricula, marca, model, preuDia);
        this.places = places;
        this.automatic = automatic;
    }

    @Override
    public double preuLloguer(int dies) {
        return 0;
    }

    @Override
    public String toString() {
        return "Cotxe{" +
                "SUMPLEMENT_AUTOMATIC_DIA=" + SUMPLEMENT_AUTOMATIC_DIA +
                ", places=" + places +
                ", automatic=" + automatic +
                '}';
    }
}
