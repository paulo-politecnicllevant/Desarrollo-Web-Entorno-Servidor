package org.example;

public class Moto extends Vehicle{
    private int cilindrada;

    public Moto(
            String matricula,
            String marca,
            String model,
            double preuDia,
            int cilindrada
    ){
        super(matricula, marca, model, preuDia);
        this.cilindrada = cilindrada;
    }

    public boolean potConduirAmbCarnet(){
        return false;
    }
}
