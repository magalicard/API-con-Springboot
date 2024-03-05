package com.edteam.demo.models;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity
@Table(name = "permisos")
public class Permiso extends BaseEntity{
    @Column(name = "nombre")
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
    private Role role;



    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
