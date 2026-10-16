/**
 * Una suite (part 3: herència). ÉS UNA habitació: té preu base, vistes i com a màxim 4 places,
 * i es reserva igual. Per això hereta d'Habitacio, i no directament d'Allotjament.
 *
 * Només afegeix el que té de nou (els metres) i canvia el que fa diferent (el preu i el toString).
 */
public class Suite extends Habitacio {
    public static final double RECARREC_SUITE = 0.25;   // un 25 % més que una habitació

    private final int metres;

    public Suite(String codi, String nom, int places, double preuBase, boolean vistes, int metres) {
        // Primera línia obligatòria: Habitacio no té constructor sense paràmetres.
        // Habitacio (i, a través seu, Allotjament) ja comprova el codi, el nom, les places i el preu.
        super(codi, nom, places, preuBase, vistes);
        if (metres <= 0) {
            throw new IllegalArgumentException("Els metres han de ser més que 0");
        }
        this.metres = metres;
    }

    public int getMetres() {
        return metres;
    }

    /**
     * super.preuNit() és el preu d'una habitació amb les mateixes característiques (vistes incloses).
     * No podem fer servir preuBase directament: és private d'Habitacio. I està bé que sigui així:
     * si demà canvia el suplement de vistes, la suite el seguirà sense tocar-la.
     */
    @Override
    public double preuNit() {
        return super.preuNit() * (1 + RECARREC_SUITE);
    }

    @Override
    public String toString() {
        return super.toString() + " · suite de " + metres + " m²";
    }
}
