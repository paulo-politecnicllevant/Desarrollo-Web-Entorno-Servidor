import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * La factura d'un client (part 5).
 *
 * Les línies són una List<Facturable>: la factura no sap si són reserves, activitats o qualsevol altra cosa
 * que es pugui facturar demà. Només en coneix el contracte. Per això no hi ha cap instanceof ni cap if sobre
 * el tipus, i una cosa nova per facturar (per exemple, els consums del bar) no obligaria a tocar aquesta classe.
 */
public class Factura {
    private final String numero;
    private final Client client;
    private final List<Facturable> linies = new ArrayList<>();

    public Factura(String numero, Client client) {
        if (numero == null || numero.isBlank() || client == null) {
            throw new IllegalArgumentException("El número i el client són obligatoris");
        }
        this.numero = numero;
        this.client = client;
    }

    public String getNumero() {
        return numero;
    }

    public Client getClient() {
        return client;
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
        double suma = 0;
        for (Facturable linia : linies) {
            suma += linia.total();      // polimorfisme: cada línia fa el seu càlcul
        }
        return suma;
    }
}
