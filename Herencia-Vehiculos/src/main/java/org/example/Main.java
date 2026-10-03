package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static List<Vehicle> vehicles = new ArrayList<>();

    static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        IO.println(String.format("Hello and welcome!"));

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            IO.println("i = " + i);
        }

        vehicles.add(new Cotxe("1234 XXX", "Seat", "Ibiza", 10, 4, false));
        vehicles.add(new Cotxe("5678 XXX", "Tesla", "Model 3", 80, 5, true));

        vehicles.add(new Moto("1111 XXX", "Honda", "CB125", 20, 2));
        vehicles.add(new Moto("2222 XXX", "Yamaha", "MT125", 25, 2));

        vehicles.add(new Furgoneta("3333 XXX", "Ford", "Transit", 40, 1000));
        vehicles.add(new Furgoneta("4444 XXX", "Mercedes", "Sprinter", 50, 1500));

        for(Vehicle vehicle : vehicles){
            System.out.println("------------------------------");
            System.out.println(vehicle);

            System.out.println("Preu 3 dies: " + vehicle.preuLloguer(3) + " €");
            System.out.println("Preu 7 dies: " + vehicle.preuLloguer(7) + " €");
        }
    }
}
