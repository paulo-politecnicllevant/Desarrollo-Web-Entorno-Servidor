package org.example.jdbcdao.dao.memory;

import org.example.jdbcdao.dao.TallerDao;
import org.example.jdbcdao.model.Taller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TallerDaoMemoryImpl implements TallerDao {

    private final Map<String, Taller> tallers = new LinkedHashMap<>();

    public TallerDaoMemoryImpl() {
        afegeixTaller(new Taller("1", "git", "g", LocalDate.of(2026,10,27), 80, new BigDecimal("111")));
        afegeixTaller(new Taller("2", "docker", "g", LocalDate.of(2026,12,5), 16, new BigDecimal("123")));
        afegeixTaller(new Taller("3", "ia", "g", LocalDate.of(2026,3,9), 19, new BigDecimal("1656")));
        afegeixTaller(new Taller("4", "sql", "g", LocalDate.of(2026,7,13), 39, new BigDecimal("96")));
        afegeixTaller(new Taller("5", "rest", "g", LocalDate.of(2026,1,7), 74, new BigDecimal("9819")));
    }

    private void afegeixTaller(Taller taller) {
        tallers.put(taller.getId(), taller);
    }

    @Override
    public List<Taller> getAll() {
        return new ArrayList<>(tallers.values());
    }

    @Override
    public Taller getById(String id) {
        return tallers.get(id);
    }
}
