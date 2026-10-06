public class Portatil extends Exemplar implements Inventariable{
    private double valor;

    public Portatil(String codi, String titol, double valor){
        super(codi, titol);
        this.valor = valor;
    }

    @Override
    public int diesPrestec(){
        return 1;
    }

    @Override
    public double valorReposicio(){
        return valor;
    }

    @Override
    public boolean esDeValor() {
        return valor >= 500;
    }

    public double getValor() {
        return valor;
    }
}
