package org.example;

public class Furgoneta extends Vehicle{
    public double SUPLEMENT_NETEJA;
    private int capacitatKg;

    public Furgoneta(
            String matricula,
            String marca,
            String model,
            double preuDia,
            int capacitatKg
    )
    {
        super(matricula, marca, model, preuDia);
        this.capacitatKg = capacitatKg;
    }

    @Override
    public double preuLloguer(int dies) {
        return super.preuLloguer(dies) + 15;
    }

    @Override
    public String toString(){
        return  "Furgoneta" +
                super.toString() +
                 capacitatKg;
    }
}
