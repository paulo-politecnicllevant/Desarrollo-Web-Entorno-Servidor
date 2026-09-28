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
        if (tarifa <= 0){
            throw new IllegalArgumentException("La tarifa no pot ser menor o igual que 0");
        }else{
            this.tarifa = tarifa;
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

        if (saldo + quantitat > 100) {
            throw new IllegalArgumentException(
                    "El saldo no pot superar els 100 euros"
            );
        }

        saldo += quantitat;
    }

    public boolean validarViatge(String linia) {
        if (saldo >= tarifa) {
            saldo -= tarifa;
            viatges.add(linia);
            return true;
        }

        return false;
    }
}
