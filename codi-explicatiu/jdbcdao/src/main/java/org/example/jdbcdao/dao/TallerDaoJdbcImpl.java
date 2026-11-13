package org.example.jdbcdao.dao;

import org.example.jdbcdao.model.Taller;

import java.util.List;

public class TallerDaoJdbcImpl implements TallerDao{
    @Override
    public List<Taller> getAll() {
        return List.of();
    }

    @Override
    public Taller getById(String id) {
        return null;
    }
}
