import java.util.List;

public class Util {

    public static <T extends Comparable<T>> T maxim(List<T> elements) {
        T maxim = elements.get(0);

        for (T element : elements) {
            if (element.compareTo(maxim) > 0) {
                maxim = element;
            }
        }

        return maxim;
    }
}