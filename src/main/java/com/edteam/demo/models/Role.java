package com.edteam.demo.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "user")
public class Role extends BaseEntity {
    @Column(name = "nombre")
    private String nombre;

    /**
     *
     * Permisos
     */
    //notacion para controlar lo de traer varios permisos
    @OneToMany(cascade = CascadeType.ALL
           , fetch = FetchType.EAGER, mappedBy = "role") //mapea t0do esto el rol de usuario
    private Set<Permiso> permisos; //trae los datos

    public void setPermisos(Set<Permiso> lista) {
        permisos = lista;
    }

    public Set<Permiso> getPermiso(){
        return permisos;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
