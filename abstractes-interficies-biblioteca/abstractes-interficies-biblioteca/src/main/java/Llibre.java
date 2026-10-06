public class Llibre extends Exemplar{
    private String autor;

    public Llibre(String codi, String titol, String autor){
        super(codi, titol);
        this.autor = autor;
    }

    @Override
    public int diesPrestec() {
        return 21;
    }

    public String getAutor() {
        return autor;
    }
}
