import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Factura {
    private String numero;
    private Client client;
    private List<Facturable> linies = new ArrayList<>();

    public Factura(String numero, Client client) {
        if (numero == null || numero.isBlank() || client == null) {
            throw new IllegalArgumentException("El número i el client són obligatoris");
        }
        this.numero = numero;
        this.client = client;
    }

    public void afegir(Facturable linia) {
        if (linia == null) {
            throw new IllegalArgumentException("La línia no pot ser null");
        }

        linies.add(linia);
    }

    public List<Facturable> getLinies() {
        return Collections.unmodifiableList(linies);
    }

    public double total() {
        double total = 0;

        for (Facturable linia : linies) {
            total += linia.total();
        }

        return total;
    }

    public String getNumero() {
        return numero;
    }

    public Client getClient() {
        return client;
    }
}
