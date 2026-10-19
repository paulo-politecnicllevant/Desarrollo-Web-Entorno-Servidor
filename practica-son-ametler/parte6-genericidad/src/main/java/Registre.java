import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Registre<T extends Identificable> {
    private List<T> elements = new ArrayList<>();

    public void afegir(T element) {
        if (element == null) {
            throw new IllegalArgumentException("L'element no pot estar buit");
        }
        elements.add(element);
    }

    public T cercar(String codi) {
        for (T element : elements) {
            if (element.getCodi().equals(codi)) {
                return element;
            }
        }

        return null;
    }

    public List<T> tots() {
        return Collections.unmodifiableList(elements);
    }

    public int quants() {
        return elements.size();
    }
}
