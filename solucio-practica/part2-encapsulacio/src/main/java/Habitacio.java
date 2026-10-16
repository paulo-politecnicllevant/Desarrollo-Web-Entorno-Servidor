/**
 * Una habitació de la casa principal (part 2: encapsulació).
 *
 * Tots els atributs són privats. El codi, el nom, les places i les vistes no canvien mai: són final i no
 * tenen setter. El preu base sí que canvia (cada temporada), però només amb un setter que el comprova.
 */
public class Habitacio {
    public static final double SUPLEMENT_VISTES = 15;
    public static final int PLACES_MAXIMES = 4;

    private final String codi;
    private final String nom;
    private final int places;
    private double preuBase;           // abans: public double preuNit
    private final boolean vistes;

    public Habitacio(String codi, String nom, int places, double preuBase, boolean vistes) {
        this.codi = textObligatori(codi, "codi");
        this.nom = textObligatori(nom, "nom");
        if (places < 1 || places > PLACES_MAXIMES) {
            throw new IllegalArgumentException("Una habitació té entre 1 i " + PLACES_MAXIMES + " places");
        }
        this.places = places;
        this.preuBase = preuPositiu(preuBase);
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

    public double getPreuBase() {
        return preuBase;
    }

    public void setPreuBase(double preuBase) {
        this.preuBase = preuPositiu(preuBase);
    }

    public boolean teVistes() {
        return vistes;
    }

    /**
     * El suplement de vistes es calcula AQUÍ, una sola vegada, i amb una constant.
     * Abans el calculava Reserva, amb un 15 escrit a mà: si canviava, s'havia de cercar per tot el codi.
     */
    public double preuNit() {
        return vistes ? preuBase + SUPLEMENT_VISTES : preuBase;
    }

    // Mètodes privats auxiliars: el constructor i el setter comproven de la mateixa manera.
    private static String textObligatori(String text, String camp) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("El camp " + camp + " és obligatori");
        }
        return text;
    }

    private static double preuPositiu(double preu) {
        if (preu <= 0) {
            throw new IllegalArgumentException("El preu ha de ser més gran que 0");
        }
        return preu;
    }

    @Override
    public String toString() {
        String text = codi + " " + nom + " · " + places + " places";
        return vistes ? text + " · amb vistes" : text;
    }
}
