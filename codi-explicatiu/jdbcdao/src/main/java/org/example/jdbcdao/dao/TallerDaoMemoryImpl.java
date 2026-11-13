package org.example.jdbcdao.dao;

import org.example.jdbcdao.model.BancDeTallers;
import org.example.jdbcdao.model.Taller;

import java.util.List;

public class TallerDaoMemoryImpl implements TallerDao{

    BancDeTallers banc = BancDeTallers.instancia();

    @Override
    public List<Taller> getAll() {
        return banc.tallers();
    }

    @Override
    public Taller getById(String id) {
        return banc.taller(id);
    }
}
