public class Suite extends Habitacio {

    private static final double SUPLEMENT_SUITE = 0.25;

    private int metresQuadrats;

    public Suite(String codi, String nom, int places, double preuBase, boolean vistes, int metresQuadrats) {

        super(codi, nom, places, preuBase, vistes);

        if (metresQuadrats <= 0) {
            throw new IllegalArgumentException("Els metres quadrats han de ser més grans que 0");
        }

        this.metresQuadrats = metresQuadrats;
    }

    public int getMetresQuadrats() {
        return metresQuadrats;
    }

    @Override
    public double preuNit() {
        return super.preuNit() * (1 + SUPLEMENT_SUITE);
    }

    @Override
    public String toString() {
        return super.toString() + " · suite de " + metresQuadrats + " m2";
    }
}
