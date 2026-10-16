/**
 * INTERFÍCIE (part 5): tot el que pot ser una línia d'una factura.
 *
 * La implementen Reserva i Activitat, que no tenen res més en comú: no
 * comparteixen cap atribut ni cap família. Només es comprometen a respondre aquestes tres preguntes.
 * Per això és una interfície i no una classe abstracta. A més, Reserva podrà implementar-ne d'altres.
 */
public interface Facturable {

    /** Constants (implícitament public static final): els tipus d'IVA s'escriuen en un sol lloc. */
    int IVA_REDUIT = 10;       // allotjament i hostaleria
    int IVA_GENERAL = 21;      // activitats

    /** Mètodes abstractes (implícitament public abstract): cada classe sap què factura. */
    String concepte();

    double baseImposable();

    int percentatgeIva();

    /**
     * Mètodes default: el càlcul de l'IVA s'escriu en UN SOL LLOC. Com que una interfície no té atributs,
     * només poden fer servir els altres mètodes del contracte.
     */
    default double iva() {
        return baseImposable() * percentatgeIva() / 100;
    }

    default double total() {
        return baseImposable() + iva();
    }
}
