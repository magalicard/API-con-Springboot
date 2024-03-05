package com.edteam.demo.dao;

import com.edteam.demo.models.Permiso;

import java.util.List;

public interface PermisoDao {

    List<Permiso> getAll();
    Permiso get(long id);
    Permiso register(Permiso Permiso);
    Permiso update(Permiso Permiso);
    void delete(long id);
}