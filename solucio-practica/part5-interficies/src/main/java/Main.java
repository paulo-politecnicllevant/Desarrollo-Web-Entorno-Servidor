import java.time.LocalDate;

/**
 * El programa del becari, adaptat a les classes encapsulades (part 2, pregunta 3).
 *
 * Les set línies que «no haurien de ser possibles» ara no compilen: són aquí comentades, amb el motiu
 * i, quan n'hi ha, la manera correcta de fer-ho.
 */
public class Main {
    public static void main(String[] args) {
        Client aina = new Client("43123456A", "Aina Riera", "aina@exemple.cat");
        Habitacio garrover = new Habitacio("H2", "Garrover", 2, 90, true);
        Reserva r = new Reserva(aina, garrover, LocalDate.of(2026, 7, 10), LocalDate.of(2026, 7, 13), 2);
        r.afegirObservacio("Arribarem després de les 22 h");
        System.out.println(r.getCodi() + ": " + r.getClient().getNom() + ", " + r.nits() + " nits, " + r.preu() + " €");

        // 1. r.sortida = ...;          NO COMPILA: sortida és private (i final).
        //                              Les dates d'una reserva no es poden canviar. Les nits i el preu ja no
        //                              són atributs: es calculen a partir de les dates i sempre quadren.
        // 2. r.persones = 5;           NO COMPILA: private i final, sense setter.
        //                              (I el constructor no accepta més persones que places.)
        // 3. r.codi = "R999";          NO COMPILA: private i final, sense setter.
        // 4. Reserva.comptador = 0;    NO COMPILA: el comptador és private.
        // 5. garrover.preuNit = -90;   NO COMPILA: l'atribut és private (i ara es diu preuBase).
        //                              garrover.setPreuBase(-90) compila, però llança IllegalArgumentException.
        // 6. r.cancelada = true/false; NO COMPILA: private. Es cancel·la amb r.cancelar(), i no hi ha
        //                              cap mètode per «descancel·lar». Cancel·lar-la dues vegades llança
        //                              IllegalStateException.
        // 7. r.observacions.clear();   NO COMPILA: private.
        //                              r.getObservacions().clear() compila, però llança UnsupportedOperationException.
        r.cancelar();
        System.out.println(r + ", " + r.nits() + " nits, " + r.preu() + " €");
    }
}
