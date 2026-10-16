import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * CLASSE GENÈRICA (part 6): una sola classe per guardar allotjaments, reserves i qualsevol altra cosa
 * que tengui un codi.
 *
 * La cota «T extends Identificable» fa dues coses:
 *   · A fora, limita què s'hi pot guardar: un Registre<Client> no compila, perquè Client no és Identificable.
 *   · A dins, deixa cridar getCodi() sobre qualsevol T. Sense la cota, d'un T només es coneixerien els
 *     mètodes d'Object, i afegir() i cercar() no compilarien.
 *
 * Només cal un paràmetre de tipus: tots els codis són String.
 */
public class Registre<T extends Identificable> {
    private final List<T> elements = new ArrayList<>();

    public void afegir(T element) {
        if (element == null) {
            throw new IllegalArgumentException("No es pot afegir null");
        }
        if (cercar(element.getCodi()) != null) {
            // El registre no sap si guarda allotjaments o reserves: per això parla d'un «element»
            throw new IllegalArgumentException("Ja hi ha un element amb el codi " + element.getCodi());
        }
        elements.add(element);
    }

    /** Retorna l'element amb aquest codi, o null si no n'hi ha cap. Qui el crida no ha de fer cap càsting. */
    public T cercar(String codi) {
        for (T element : elements) {
            if (element.getCodi().equals(codi)) {     // equals, i no ==: són String
                return element;
            }
        }
        return null;
    }

    /** Llista de només lectura: des de fora no s'hi pot afegir res sense passar per afegir(). */
    public List<T> tots() {
        return Collections.unmodifiableList(elements);
    }

    public int quants() {
        return elements.size();
    }
}
