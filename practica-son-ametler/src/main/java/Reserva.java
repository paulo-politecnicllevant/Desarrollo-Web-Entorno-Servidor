import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * Primera versió, feta pel becari.
 */
public class Reserva {
    public static int comptador = 0;

    public String codi;
    public Client client;
    public Habitacio habitacio;
    public LocalDate entrada;
    public LocalDate sortida;
    public int persones;
    public boolean cancelada;
    public ArrayList<String> observacions = new ArrayList<>();

    public Reserva(Client client, Habitacio habitacio, LocalDate entrada, LocalDate sortida, int persones) {
        comptador++;

        if (persones < 1 || persones > habitacio.getPlaces()) {
            throw new IllegalArgumentException("Poden anar entre 1 i " + habitacio.getPlaces() + " persones");
        }else if(client == null || habitacio == null){
            throw new IllegalArgumentException("El client i l'habitació son obligatoris");
        }
        this.codi = "R" + comptador;
        this.client = client;
        this.habitacio = habitacio;
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

    public Habitacio getHabitacio() {
        return habitacio;
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
        return habitacio.preuNit() * nits();
    }

    @Override
    public String toString() {
        String text = codi + " " + client + " " + habitacio + " " + entrada + " -> " + sortida;
        return cancelada ? text + " · cancel·lada" : text;
    }
}
