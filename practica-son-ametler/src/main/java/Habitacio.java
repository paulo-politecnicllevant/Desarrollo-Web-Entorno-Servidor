/**
 * Primera versió, feta pel becari. De moment, Son Ametler només lloga habitacions.
 */
public class Habitacio {
    private static final int PLACES_MINIMES = 1;
    private static final int PLACES_MAXIMES = 4;
    private static final int PREU_VISTES = 15;

    private String codi;
    private String nom;
    public int places;
    public double preuBase;
    public boolean vistes;

    public Habitacio(String codi, String nom, int places, double preuBase, boolean vistes) {
        this.codi = codi;
        this.nom = nom;
        if(places < PLACES_MINIMES || places > PLACES_MAXIMES){
            throw new IllegalArgumentException("El nombre de places ha de ser entre 1 i 4");
        }
        this.places = places;
        if(preuBase <= 0){
            throw new IllegalArgumentException("El preu base ha de ser més gran que 0");
        }
        this.preuBase = preuBase;
        this.vistes = vistes;
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

    public void setPreuBase(double preuBase) {
        this.preuBase = preuBase;
    }

    public boolean teVistes() {
        return vistes;
    }

    public double preuNit(){
        if(teVistes()){
            return preuBase + PREU_VISTES;
        }
        return preuBase;
    }

    @Override
    public String toString() {
        String text = codi + " " + nom + " · " + places + " places";
        return vistes ? text + " · amb vistes" : text;
    }
}
