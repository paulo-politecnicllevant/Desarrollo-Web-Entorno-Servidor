package org.example.jdbcdao.dao;

import org.example.jdbcdao.model.Taller;

import java.util.List;

public interface TallerDao {
    List<Taller> getAll();
    Taller getById(String id);
}
