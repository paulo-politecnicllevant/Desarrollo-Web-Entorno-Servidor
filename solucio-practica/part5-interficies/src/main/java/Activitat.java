/**
 * Una activitat contractada durant l'estada (part 5): una excursió a cavall, una classe de cuina...
 *
 * No és un allotjament ni una reserva, i no hereta de res. Però també es factura: implementa Facturable.
 * Tots els atributs són final: una activitat contractada no canvia.
 */
public class Activitat implements Facturable {
    private final String nom;
    private final double preuPersona;
    private final int persones;

    public Activitat(String nom, double preuPersona, int persones) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("El nom de l'activitat és obligatori");
        }
        if (preuPersona <= 0) {
            throw new IllegalArgumentException("El preu ha de ser més gran que 0");
        }
        if (persones < 1) {
            throw new IllegalArgumentException("Hi ha d'anar com a mínim una persona");
        }
        this.nom = nom;
        this.preuPersona = preuPersona;
        this.persones = persones;
    }

    public String getNom() {
        return nom;
    }

    public double getPreuPersona() {
        return preuPersona;
    }

    public int getPersones() {
        return persones;
    }

    // ── Facturable ──

    @Override
    public String concepte() {
        return nom + " (" + persones + " pers.)";
    }

    @Override
    public double baseImposable() {
        return preuPersona * persones;
    }

    @Override
    public int percentatgeIva() {
        return IVA_GENERAL;
    }

    // iva() i total() li arriben fets per la interfície (default).
}
