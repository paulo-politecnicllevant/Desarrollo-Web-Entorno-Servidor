import java.time.LocalDate;
import java.util.Date;

public abstract class Exemplar {
    private String codi;
    private String titol;

    public Exemplar(String codi, String titol){
        this.codi = codi;
        this.titol = titol;
    }

    public abstract int diesPrestec();

    public LocalDate dataRetorn(LocalDate dataPrestec){
        return dataPrestec.plusDays(diesPrestec());
    }

    public String getCodi() {
        return codi;
    }

    public String getTitol() {
        return titol;
    }

    @Override
    public String toString() {
        return titol + "[" + codi + "]";
    }
}
