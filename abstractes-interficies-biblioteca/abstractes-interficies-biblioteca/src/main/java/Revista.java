public class Revista extends Exemplar{
    private int numero;

    public Revista(String codi, String titol, int numero){
        super(codi, titol);
        this.numero = numero;
    }

    @Override
    public int diesPrestec() {
        return 7;
    }

    public int getNumero() {
        return numero;
    }
}
