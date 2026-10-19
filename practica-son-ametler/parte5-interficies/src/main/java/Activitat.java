public class Activitat implements Facturable {

    private String nom;
    private double preuPersona;
    private int persones;

    public Activitat(String nom, double preuPersona, int persones) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("El nom es obligatori");
        }

        if (preuPersona <= 0) {
            throw new IllegalArgumentException("El preu ha de ser mes gran que 0");
        }

        if (persones < 1) {
            throw new IllegalArgumentException("Hi ha d'haver com a minim una persona");
        }

        this.nom = nom;
        this.preuPersona = preuPersona;
        this.persones = persones;
    }

    @Override
    public String concepte() {
        return nom + " (" + persones + " pers.)";
    }

    @Override
    public double baseImposable() {
        return preuPersona * persones;
    }

    @Override
    public int percentatgeIVA() {
        return IVA_GENERAL;
    }
}
