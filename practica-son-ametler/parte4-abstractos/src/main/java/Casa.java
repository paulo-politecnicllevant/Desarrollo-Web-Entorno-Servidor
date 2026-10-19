public class Casa extends Allotjament{
    private static final int PREU_PLACA = 30;
    private static final int SUPLEMENT_PISCINA = 40;
    private static final int NETEJA_ESTADA = 60;
    private final boolean tePiscina;

    public Casa(String codi, String nom, int places, boolean tePiscina) {
        super(codi, nom, places);
        this.tePiscina = tePiscina;
    }

    @Override
    public double preuNit() {
        return getPlaces() * PREU_PLACA + (tePiscina ? SUPLEMENT_PISCINA : 0);
    }

    @Override
    public double preuEstada(int nits) {
        return super.preuEstada(nits) + NETEJA_ESTADA;
    }

    @Override
    public String toString() {
        return tePiscina ? super.toString() + " · piscina privada" : super.toString();
    }
}
