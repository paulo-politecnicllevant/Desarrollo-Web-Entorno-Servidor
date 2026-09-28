import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Targeta de transport públic.
 * ATENCIÓ: aquesta versió està MAL encapsulada. És el punt de partida de l'activitat 3.
 */
public class TargetaTransport {
    private String numero;
    private String titular;
    private long saldoCentimos;
    private long tarifaCentimos;
    private ArrayList<String> viatges = new ArrayList<>();

    public TargetaTransport(String numero, String titular) {
        if(numero == null){
            throw new IllegalArgumentException("El número no pot estar buit");
        }else{
            this.numero = numero;
        }

        if(titular == null){
            throw new IllegalArgumentException("El titular no pot estar buit");
        }else{
            this.titular = titular;
        }

        this.tarifaCentimos = 115;
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldoCentimos / 100.0;
    }

    public double getTarifa() {
        return tarifaCentimos / 100.0;
    }

    public List<String> getViatges() {
        return Collections.unmodifiableList(viatges);
    }

    public void setTarifa(double tarifa) {
        if (tarifa <= 0){
            throw new IllegalArgumentException("La tarifa no pot ser menor o igual que 0");
        }else{
            tarifaCentimos = Math.round(tarifa * 100);
        }
    }

    public void setTitular(String titular) {
        if (titular == null) {
            throw new IllegalArgumentException("El titular no pot estar buit");
        }else{
            this.titular = titular;
        }
    }

    public void recargar(double quantitat) {
        if (quantitat < 5 || quantitat > 50) {
            throw new IllegalArgumentException(
                    "La recarrega ha de ser entre 5 i 50 euros"
            );
        }

        if (saldoCentimos + quantitat > 100) {
            throw new IllegalArgumentException(
                    "El saldo no pot superar els 100 euros"
            );
        }

        saldoCentimos += quantitat;
    }

    public boolean validarViatge(String linia) {
        if (saldoCentimos >= tarifaCentimos) {
            saldoCentimos -= tarifaCentimos;
            viatges.add(linia);
            return true;
        }

        return false;
    }

    public void validarText(String text){
        if(text == null || text.isEmpty()){
            throw new IllegalArgumentException("El text no pot estar buit");
        }
    }
}
