import java.time.LocalDate;

/**
 * El programa del becari. Compila i s'executa, però deixa fer coses que no s'haurien de poder fer.
 */
public class Main {
    public static void main(String[] args) {
        Client aina = new Client("43123456A", "Aina Riera", "aina@exemple.cat");
        Habitacio garrover = new Habitacio("H2", "Garrover", 2, 90, true);
        Reserva r = new Reserva(aina, garrover, LocalDate.of(2026, 7, 10), LocalDate.of(2026, 7, 13), 2);
        r.afegirObservacio("Arribarem després de les 22 h");
        System.out.println(r.getCodi() + ": " + r.getClient().getNom() + ", " + r.nits() + " nits, " + r.preu() + " €");

        // Coses que NO haurien de ser possibles:

        /*
        r.sortida = LocalDate.of(2026, 7, 20);   // No compila ya que sortida es privado y la fecha no se puede cambiar
        r.persones = 5;                          // No compila ya que no hay setter
        r.codi = "R999";                         // No compila ya que no hay setter
        Reserva.comptador = 0;                   // No compila ya que comptador es privado
        garrover.preuBase = -90;                 // No compila ya que el atributo ahora es privado
                                                 garrover.setPreuBase(-90) -> da una IllegalArgumentException

        r.cancelada = true;                      // No compila ya que no usa el metodo cancelar
        r.cancelada = false;                     // No compila ya que no hay un metodo para descancelar
        r.observacions.clear();                  // No compila ya que es privado
                                                 r.getObservacions().clear() -> da una UnsupportedOperationException.
        System.out.println(r.codi + ": " + r.client.getNom() + ", " + r.nits + " nits, " + r.preu + " €");
         */


    }
}
