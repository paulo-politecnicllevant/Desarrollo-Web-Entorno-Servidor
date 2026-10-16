/**
 * INTERFÍCIE (part 6): tot el que es pot guardar en un Registre té un codi que l'identifica.
 *
 * La implementen Allotjament (i, per herència, Habitacio, Suite i Casa) i Reserva.
 * És la cota de Registre<T extends Identificable>: gràcies a ella, el registre pot cridar getCodi().
 */
public interface Identificable {
    String getCodi();
}
