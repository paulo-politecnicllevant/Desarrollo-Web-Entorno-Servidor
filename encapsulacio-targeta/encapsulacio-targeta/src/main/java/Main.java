public class Main {
    public static void main(String[] args) {
        TargetaTransport t = new TargetaTransport("T-0001", "Aina Riera");

        // Recàrrega de 10 €
        t.recargar(10);

        // Validam tres viatges
        for (int i = 1; i <= 3; i++) {
            t.validarViatge("Linea" + i);

        }
        System.out.println(t.getTitular() + " té " + t.getSaldo() + " € i " + t.getViatges().size() + " viatges");

        // Coses que NO haurien de ser possibles:
        t.saldo = -50;          // saldo negatiu
        t.setTarifa(0);           // viatges gratis per sempre
        t.numero = "T-9999";    // la targeta canvia de número
        t.setTitular("");         // titular buit
        t.getViatges().clear();      // esborram l'historial de viatges
        System.out.println(t.getTitular() + " té " + t.getSaldo() + " € i " + t.getViatges().size() + " viatges");
    }
}
