public interface Inventariable {

    double valorReposicio();

    default boolean esDeValor() {
        return valorReposicio() >= 500;
    }
}
