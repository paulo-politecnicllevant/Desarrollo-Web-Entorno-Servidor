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
        return 0;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", model='" + model + '\'' +
                ", preuDia=" + preuDia +
                '}';
    }
}
