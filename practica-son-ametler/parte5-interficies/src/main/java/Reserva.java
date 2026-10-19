import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * Primera versió, feta pel becari.
 */
public class Reserva implements Facturable{
    private static int comptador = 0;

    private String codi;
    private Client client;
    private Allotjament allotjament;
    private LocalDate entrada;
    private LocalDate sortida;
    private int persones;
    private boolean cancelada;
    private ArrayList<String> observacions = new ArrayList<>();

    public Reserva(Client client, Allotjament allotjament, LocalDate entrada, LocalDate sortida, int persones) {
        comptador++;

        if (persones < 1 || persones > allotjament.getPlaces()) {
            throw new IllegalArgumentException("Hi ha de haber com a minim una persona i un allotjament");
        }else if(client == null || allotjament == null){
            throw new IllegalArgumentException("El client i l'habitació son obligatoris");
        }
        this.codi = "R" + comptador;
        this.client = client;
        this.allotjament = allotjament;
        this.entrada = entrada;
        this.sortida = sortida;
        this.persones = persones;
        this.codi = String.format("R%03d", comptador);
    }

    public String getCodi() {
        return codi;
    }

    public Client getClient() {
        return client;
    }

    public Allotjament getAllotjament() {
        return allotjament;
    }

    public LocalDate getEntrada() {
        return entrada;
    }

    public LocalDate getSortida() {
        return sortida;
    }

    public int getPersones() {
        return persones;
    }

    public boolean estaCancelada() {
        return cancelada;
    }

    public ArrayList<String> getObservacions() {
        return observacions;
    }

    public void cancelar(){
        if(!cancelada){
            cancelada = true;
        }else{
            System.out.println("La reserva ya esta cancelada");
        }
    }

    public void afegirObservacio(String text){
        if(text == null || text.isEmpty()){
            throw new IllegalArgumentException("El text no pot estar buit");
        }
        observacions.add(text);
    }

    public int nits() {
        return (int) ChronoUnit.DAYS.between(entrada, sortida);
    }

    public double preu() {
        return allotjament.preuNit() * nits();
    }

    @Override
    public String toString() {
        String text = codi + " " + client + " " + allotjament + " " + entrada + " -> " + sortida;
        return cancelada ? text + " · cancel·lada" : text;
    }

    @Override
    public String concepte() {
        return "Estada a " + allotjament.getNom() + " (" + nits() + " nits)";
    }

    @Override
    public double baseImposable() {
        return preu();
    }

    @Override
    public int percentatgeIVA() {
        return IVA_REDUIT;
    }
}
