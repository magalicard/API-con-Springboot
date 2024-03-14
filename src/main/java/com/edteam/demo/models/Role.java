package com.edteam.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends BaseEntity {

    @Column(name = "nombre")
    @Getter @Setter
    private String nombre;

    /**
     *
     * Permisos
     */
    //notacion para controlar lo de traer varios permisos
    @OneToMany(cascade = CascadeType.ALL
           , fetch = FetchType.EAGER, mappedBy = "role") //mapea t0do esto el rol de usuario
    private Set<Permiso> permisos; //trae los datos
}
