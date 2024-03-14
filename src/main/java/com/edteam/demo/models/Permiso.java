package com.edteam.demo.models;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "permisos")
public class Permiso extends BaseEntity{
    @Column(name = "nombre")
    @Getter @Setter
    private String nombre;

    /**
     *Role
     * Agregamos la asociacion con el rol
     * Las tres primeras lineas son
     * para que nos traiga unicamente el id
     */
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("role_id") //nombre del objeto de json
    @ManyToOne(fetch = FetchType.LAZY) //trae solo datos necesarios, evitamos un stackoverflow
    @JoinColumn(name = "role_id") //nombre de la columna
    @Getter @Setter
    private Role role;

    
    //esto lo agregamos porque usamos LAZY
    @Override
    public String toString() {
        return "Permiso{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permiso permiso = (Permiso) o;
        return Objects.equals(nombre, permiso.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
