package org.example;

import org.example.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Flota {
    private final List<Vehicle> vehicles = new ArrayList<>();

    public void afegir(Vehicle v) {
        if (v == null) throw new IllegalArgumentException("Vehicle null");
        vehicles.add(v);
    }

    public double totalLloguer(int dies) {
        double total = 0;
        for (Vehicle v : vehicles) total += v.preuLloguer(dies);
        return total;
    }
}