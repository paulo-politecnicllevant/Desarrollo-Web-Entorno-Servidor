package org.example.jdbcdao.model;

import org.example.jdbcdao.dao.TallerDao;
import org.example.jdbcdao.dao.jdbc.TallerDaoJdbcImpl;
import org.example.jdbcdao.dao.memory.TallerDaoMemoryImpl;

import java.util.List;

public class TallerModel {
    private static final TallerModel INSTANCIA = new TallerModel();

    public static TallerModel instancia(){
        return INSTANCIA;
    }

    private TallerDao tallerDao = new TallerDaoJdbcImpl();

    public List<Taller> tallers(){
        return tallerDao.getAll(); //Esto coge el getAll de la clase TallerDaoMemoryImpl
    }

    public Taller taller(String id){
        return tallerDao.getById(id); //Esto coge el getAll de la clase TallerDaoMemoryImpl
    }
}
