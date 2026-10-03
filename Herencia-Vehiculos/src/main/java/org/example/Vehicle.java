package org.example;

public class Vehicle {
    private String matricula;
    private String marca;
    private String model;
    private double preuDia;

    public Vehicle(
            String matricula,
            String marca,
            String model,
            double preuDia
    )
    {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuDia = preuDia;
    }

    public double preuLloguer(int dies){

        if (dies >= 7){
            return (preuDia * dies) * 0.9;
        }

        return preuDia * dies;
    }

    public double preuLloguer(int dies, boolean assegurancaTotal) {
        double preu = preuLloguer(dies);

        if (assegurancaTotal) {
            preu += 12 * dies;
        }

        return preu;
    }

    @Override
    public String toString() {
        return  " " + marca  +
                " " + model +
                " " + matricula +
                " " + preuDia + "€/dia, ";
    }
}
