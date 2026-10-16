/**
 * Una habitació de la casa principal.
 *
 * Part 2: era una classe independent, amb codi, nom i places.
 * Part 4: aquests tres atributs han pujat a Allotjament, perquè també els tenen les cases. Aquí només
 * queda el que és propi d'una habitació: el preu base i les vistes.
 */
public class Habitacio extends Allotjament {
    public static final double SUPLEMENT_VISTES = 15;
    public static final int PLACES_MAXIMES = 4;

    private double preuBase;           // no és final: els preus canvien cada temporada (setPreuBase)
    private final boolean vistes;      // final: és una característica de l'habitació, no canvia

    public Habitacio(String codi, String nom, int places, double preuBase, boolean vistes) {
        super(codi, nom, places);      // Allotjament comprova el codi, el nom i que hi hagi alguna plaça
        if (places > PLACES_MAXIMES) { // la regla de les 4 places només és de les habitacions: va aquí
            throw new IllegalArgumentException("Una habitació té com a màxim " + PLACES_MAXIMES + " places");
        }
        this.preuBase = preuPositiu(preuBase);
        this.vistes = vistes;
    }

    public double getPreuBase() {
        return preuBase;
    }

    public void setPreuBase(double preuBase) {
        this.preuBase = preuPositiu(preuBase);
    }

    public boolean teVistes() {
        return vistes;
    }

    @Override
    public double preuNit() {
        return vistes ? preuBase + SUPLEMENT_VISTES : preuBase;
    }

    // Privat i static: el constructor i el setter comproven el preu de la mateixa manera.
    // No cridam setPreuBase() des del constructor: una filla el podria sobreescriure.
    private static double preuPositiu(double preu) {
        if (preu <= 0) {
            throw new IllegalArgumentException("El preu ha de ser més gran que 0");
        }
        return preu;
    }

    @Override
    public String toString() {
        // super.toString() escriu el codi, el nom i les places: la part comuna la fa Allotjament
        return vistes ? super.toString() + " · amb vistes" : super.toString();
    }
}
