import java.util.ArrayList;
import java.util.List;

public class Inventari {

    private List<Inventariable> equips;

    public Inventari() {
        equips = new ArrayList<Inventariable>();
    }

    public void afegir(Inventariable equip) {
        equips.add(equip);
    }

    public void mostrar() {
        for (Inventariable equip : equips) {
            System.out.print(equip);

            System.out.print(": " + equip.valorReposicio() + " €");

            if (equip.esDeValor()) {
                System.out.print(" (de valor)");
            }

            System.out.println();
        }
    }

    public double valorTotal() {
        double total = 0;

        for (Inventariable equip : equips) {
            total += equip.valorReposicio();
        }

        return total;
    }

    public int quantsDeValor() {
        int quantitat = 0;

        for (Inventariable equip : equips) {
            if (equip.esDeValor()) {
                quantitat++;
            }
        }

        return quantitat;
    }
}