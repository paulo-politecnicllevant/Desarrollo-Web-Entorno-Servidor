/**
 * Una casa de pagès (part 4). NO ÉS una habitació: no té preu base ni vistes, i es lloga sencera.
 * Si heretàs d'Habitacio, heretaria dades que no té i la regla de les 4 places. Per això hereta
 * d'Allotjament, el pare comú.
 */
public class Casa extends Allotjament {
    public static final double PREU_PLACA = 30;
    public static final double SUPLEMENT_PISCINA = 40;
    public static final double NETEJA_FINAL = 60;

    private final boolean piscina;

    public Casa(String codi, String nom, int places, boolean piscina) {
        super(codi, nom, places);
        this.piscina = piscina;
    }

    public boolean tePiscina() {
        return piscina;
    }

    /** Si Casa no implementàs aquest mètode, no compilaria: Allotjament el declara abstracte. */
    @Override
    public double preuNit() {
        return getPlaces() * PREU_PLACA + (piscina ? SUPLEMENT_PISCINA : 0);
    }

    /** La neteja es cobra una vegada per estada, no per nit: s'afegeix al càlcul comú d'Allotjament. */
    @Override
    public double preuEstada(int nits) {
        return super.preuEstada(nits) + NETEJA_FINAL;
    }

    @Override
    public String toString() {
        return piscina ? super.toString() + " · piscina privada" : super.toString();
    }
}
