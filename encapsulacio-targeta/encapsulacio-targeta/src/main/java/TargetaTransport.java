import java.util.ArrayList;

/**
 * Targeta de transport públic.
 * ATENCIÓ: aquesta versió està MAL encapsulada. És el punt de partida de l'activitat 3.
 */
public class TargetaTransport {
    private String numero;
    private String titular;
    private double saldo;
    private double tarifa;
    private ArrayList<String> viatges = new ArrayList<>();

    public TargetaTransport(String numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.tarifa = 1.15;
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTarifa() {
        return tarifa;
    }

    public ArrayList<String> getViatges() {
        return viatges;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
}
