import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Una reserva d'un client en un allotjament.
 *
 * Part 2 (encapsulació): atributs privats, cap setter, validacions i un comptador de classe.
 * Part 4: rep un Allotjament (abans, una Habitacio) i calcula el preu amb preuEstada(), perquè
 *         les cases hi sumen la neteja.
 */
public class Reserva {
    // De classe (static): un sol comptador compartit per totes les reserves.
    // Privat: ningú de fora el pot posar a 0 (abans, Reserva.comptador = 0 repetia codis).
    private static int comptador = 0;

    private final String codi;
    private final Client client;
    private final Allotjament allotjament;
    private final LocalDate entrada;
    private final LocalDate sortida;
    private final int persones;
    private boolean cancelada;                       // comença a false: només canvia amb cancelar()
    private final List<String> observacions = new ArrayList<>();

    // No hi ha atributs nits ni preu: es calculen a partir de les dates. Si fossin atributs, podrien
    // no quadrar amb les dates (és el que passava al codi del becari en canviar la sortida).

    public Reserva(Client client, Allotjament allotjament, LocalDate entrada, LocalDate sortida, int persones) {
        if (client == null || allotjament == null) {
            throw new IllegalArgumentException("El client i l'allotjament són obligatoris");
        }
        if (persones < 1 || persones > allotjament.getPlaces()) {
            throw new IllegalArgumentException(
                    "Hi poden anar entre 1 i " + allotjament.getPlaces() + " persones");
        }
        comprovarDates(entrada, sortida);
        this.client = client;
        this.allotjament = allotjament;
        this.entrada = entrada;
        this.sortida = sortida;
        this.persones = persones;
        // El codi es dona AL FINAL, quan ja s'ha comprovat tot: una reserva rebutjada no gasta cap número.
        comptador++;
        this.codi = String.format("R%03d", comptador);
    }

    public String getCodi() {
        return codi;
    }

    public Client getClient() {
        return client;
    }

    public Allotjament getAllotjament() {
        return allotjament;
    }

    public LocalDate getEntrada() {
        return entrada;
    }

    public LocalDate getSortida() {
        return sortida;
    }

    public int getPersones() {
        return persones;
    }

    public boolean estaCancelada() {
        return cancelada;
    }

    /** Vista de només lectura: qui la rep la pot llegir, però add() o clear() llancen una excepció. */
    public List<String> getObservacions() {
        return Collections.unmodifiableList(observacions);
    }

    public void afegirObservacio(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("L'observació no pot ser buida");
        }
        observacions.add(text);
    }

    public void cancelar() {
        // El valor és correcte, però l'objecte no està en condicions de fer l'operació: IllegalStateException.
        if (cancelada) {
            throw new IllegalStateException("La reserva " + codi + " ja està cancel·lada");
        }
        cancelada = true;
    }

    /** Atribut derivat: es calcula cada vegada, i per això sempre quadra amb les dates. */
    public int nits() {
        return (int) ChronoUnit.DAYS.between(entrada, sortida);
    }

    /** Polimorfisme: cada allotjament calcula el preu de l'estada a la seva manera. */
    public double preu() {
        return allotjament.preuEstada(nits());
    }

    // ── Mètode privat auxiliar ──

    // static: no fa servir cap atribut de la reserva.
    private static void comprovarDates(LocalDate entrada, LocalDate sortida) {
        if (entrada == null || sortida == null) {
            throw new IllegalArgumentException("Les dates són obligatòries");
        }
        if (!sortida.isAfter(entrada)) {
            throw new IllegalArgumentException("La sortida ha de ser posterior a l'entrada");
        }
    }

    @Override
    public String toString() {
        String text = codi + " · " + client.getNom() + " · " + allotjament.getCodi() + " · " + entrada + " → " + sortida;
        return cancelada ? text + " · cancel·lada" : text;
    }
}
