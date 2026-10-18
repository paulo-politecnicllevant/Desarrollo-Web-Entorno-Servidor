/**
 * Primera versió, feta pel becari. De moment, Son Ametler només lloga habitacions.
 */
public class Habitacio {
    public String codi;
    public String nom;
    public int places;
    public double preuNit;
    public boolean vistes;

    public Habitacio(String codi, String nom, int places, double preuNit, boolean vistes) {
        this.codi = codi;
        this.nom = nom;
        this.places = places;
        this.preuNit = preuNit;
        this.vistes = vistes;
    }
}
