/**
 * Primera versió, feta pel becari. De moment, Son Ametler només lloga habitacions.
 */
public class Habitacio extends Allotjament{
    private static final int PLACES_MINIMES = 1;
    private static final int PLACES_MAXIMES = 4;
    private static final int PREU_VISTES = 15;

    private double preuBase;
    private boolean vistes;

    public Habitacio(String codi, String nom, int places, double preuBase, boolean vistes) {
        super(codi, nom, places);
        if(places < PLACES_MINIMES || places > PLACES_MAXIMES){
            throw new IllegalArgumentException("El nombre de places ha de ser entre 1 i 4");
        }
        if(preuBase <= 0){
            throw new IllegalArgumentException("El preu base ha de ser més gran que 0");
        }
        this.preuBase = preuBase;
        this.vistes = vistes;
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
        String text = super.toString();
        return vistes ? text + " · amb vistes" : text;
    }
}
