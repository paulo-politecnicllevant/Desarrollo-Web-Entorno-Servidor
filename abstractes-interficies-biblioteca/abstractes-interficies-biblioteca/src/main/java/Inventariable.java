public interface Inventariable {

    public final int LLINDAR_VALOR = 500;

    double valorReposicio();

    default boolean esDeValor() {
        return valorReposicio() >= LLINDAR_VALOR;
    }
}
