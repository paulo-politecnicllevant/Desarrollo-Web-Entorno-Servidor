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
        vehicles.add(new Cotxe("s", "d", "d", 1, 1, false));

        vehicles.add(new Moto("s", "d", "d", 1, 1 ));
        vehicles.add(new Moto("s", "d", "d", 1, 1 ));

        vehicles.add(new Furgoneta("s", "d", "d", 1, 1 ));
        vehicles.add(new Furgoneta("s", "d", "d", 1, 1));

        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle.preuLloguer(3));
            System.out.println(vehicles);

            System.out.println(vehicle.preuLloguer(7));
            System.out.println(vehicles);
        }
    }
}
