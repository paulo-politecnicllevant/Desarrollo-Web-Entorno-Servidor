public abstract class Allotjament implements Identificable {
    private String codi;
    private String nom;
    private int places;

    public Allotjament(String codi, String nom, int places){
        this.codi = codi;
        this.nom = nom;
        this.places = places;
    }

    public abstract double preuNit();

    public double preuEstada(int nits){
        return nits * preuNit();
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

    @Override
    public String toString() {
        return codi + " " + nom + " · " + places + " places";
    }
}
