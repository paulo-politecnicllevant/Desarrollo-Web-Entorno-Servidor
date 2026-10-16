import java.util.List;

/**
 * Informes per a la gerència (part 6). Classe auxiliar: només té mètodes static.
 *
 * Els dos mètodes reben una llista de coses facturables, però no s'escriuen igual:
 *   · totalFacturat només LLEGEIX la llista i retorna un double: n'hi ha prou amb un comodí.
 *   · mesCar RETORNA un element de la llista, i qui el crida el vol del seu tipus (Reserva, Activitat...)
 *     sense càsting: necessita un paràmetre de tipus T que lligui el tipus de la llista amb el del retorn.
 */
public class Informes {

    /**
     * Amb List<Facturable>, la crida totalFacturat(reserves.tots()) no compilaria: una List<Reserva> no és
     * una List<Facturable>, encara que una Reserva sigui Facturable. «? extends Facturable» vol dir
     * «una llista d'algun tipus facturable»: hi encaixen List<Reserva>, List<Activitat> i List<Facturable>.
     */
    public static double totalFacturat(List<? extends Facturable> elements) {
        double suma = 0;
        for (Facturable element : elements) {        // llegir: tots són Facturable
            suma += element.total();
        }
        return suma;
    }

    /**
     * Mètode genèric amb una cota: T pot ser qualsevol tipus facturable, i el mètode retorna un T.
     * Amb una List<Reserva>, retorna una Reserva; amb una List<Activitat>, una Activitat.
     * Retorna null si la llista és buida.
     */
    public static <T extends Facturable> T mesCar(List<T> elements) {
        T mesCar = null;
        for (T element : elements) {
            if (mesCar == null || element.total() > mesCar.total()) {   // total() compila gràcies a la cota
                mesCar = element;
            }
        }
        return mesCar;
    }
}
