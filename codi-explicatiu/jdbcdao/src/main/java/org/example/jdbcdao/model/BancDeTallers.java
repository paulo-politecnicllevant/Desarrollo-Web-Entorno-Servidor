package org.example.jdbcdao.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class BancDeTallers {
    private static final BancDeTallers INSTANCIA = new BancDeTallers();

    private final Map<String, Taller> tallers = new LinkedHashMap<>();

    private BancDeTallers() {
        afegeixTaller(new Taller("1", "git", "g", LocalDate.of(2026,10,27), 80, new BigDecimal("111")));
        afegeixTaller(new Taller("2", "docker", "g", LocalDate.of(2026,12,5), 16, new BigDecimal("123")));
        afegeixTaller(new Taller("3", "ia", "g", LocalDate.of(2026,3,9), 19, new BigDecimal("1656")));
        afegeixTaller(new Taller("4", "sql", "g", LocalDate.of(2026,7,13), 39, new BigDecimal("96")));
        afegeixTaller(new Taller("5", "rest", "g", LocalDate.of(2026,1,7), 74, new BigDecimal("9819")));
    }

    public static BancDeTallers instancia(){
        return INSTANCIA;
    }

    private void afegeixTaller(Taller taller) {
        tallers.put(taller.getId(), taller);
    }

    public synchronized List<Taller> tallers() {
        return new ArrayList<>(tallers.values());
    }

    public synchronized Taller taller(String id) {
        return tallers.get(id);
    }
}
