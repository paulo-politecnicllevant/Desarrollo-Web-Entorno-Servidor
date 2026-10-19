import java.util.List;

public class Informes {

    public static double totalFacturat(List<? extends Facturable> elements) {
        double total = 0;

        for (Facturable element : elements) {
            total += element.total();
        }

        return total;
    }

    public static <T extends Facturable> T mesCar(List<T> elements) {
        if (elements == null || elements.isEmpty()) {
            throw new IllegalArgumentException("La llista no pot estar buida");
        }

        T maxim = elements.get(0);

        for (T element : elements) {
            if (element.total() > maxim.total()) {
                maxim = element;
            }
        }

        return maxim;
    }
}
