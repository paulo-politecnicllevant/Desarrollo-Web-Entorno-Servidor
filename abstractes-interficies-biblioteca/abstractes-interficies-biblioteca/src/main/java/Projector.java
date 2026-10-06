public class Projector implements Inventariable {

    private String aula;
    private double valor;

    public Projector(String aula, double valor) {
        this.aula = aula;
        this.valor = valor;
    }

    @Override
    public double valorReposicio() {
        return valor;
    }

    @Override
    public boolean esDeValor() {
        return valor >= 1000;
    }

    @Override
    public String toString() {
        return "Projector de l'aula " + aula;
    }
}