/**
 * CLASSE ABSTRACTA (part 4): el pare comú d'habitacions, suites i cases.
 *
 * Per què abstracta?
 *   · No existeix cap «allotjament» que no sigui d'un tipus concret: new Allotjament(...) no ha de compilar.
 *   · Les filles comparteixen dades (codi, nom, places) i codi (preuEstada, toString), cosa que una
 *     interfície no podria tenir.
 *   · Hi ha una operació, preuNit(), que no té cap resposta general: cada tipus la calcula a la seva manera.
 */
public abstract class Allotjament {
    private final String codi;
    private final String nom;
    private final int places;

    // protected: només el criden les filles, amb super(...). Les validacions comunes són aquí, una vegada.
    protected Allotjament(String codi, String nom, int places) {
        this.codi = textObligatori(codi, "codi");
        this.nom = textObligatori(nom, "nom");
        if (places < 1) {
            throw new IllegalArgumentException("Un allotjament ha de tenir com a mínim una plaça");
        }
        this.places = places;
    }

    public String getCodi() {
        return codi;
    }

    public String getNom() {
        return nom;
    }

    public int getPlaces() {
        return places;
    }

    /** Mètode abstracte, sense cos: cada tipus d'allotjament sap quant val una nit. */
    public abstract double preuNit();

    /**
     * Codi comú, escrit una vegada. Pot cridar preuNit() encara que sigui abstracte: quan s'executi,
     * l'objecte serà una habitació, una suite o una casa, i es farà servir el seu preuNit().
     * Casa el sobreescriu per sumar-hi la neteja final.
     */
    public double preuEstada(int nits) {
        return preuNit() * nits;
    }

    private static String textObligatori(String text, String camp) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("El camp " + camp + " és obligatori");
        }
        return text;
    }

    @Override
    public String toString() {
        return codi + " " + nom + " · " + places + " places";
    }
}
