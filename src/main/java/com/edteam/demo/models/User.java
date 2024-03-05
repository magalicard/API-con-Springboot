package com.edteam.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "user")
public class User extends BaseEntity {

    //Le damos un objeto rol, no es un sql sino un objeto
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) //tipo de acceso que va a tener el json
    @ManyToOne(fetch=FetchType.EAGER) //estrategia para que siempre me traiga el contenido
    @JoinColumn(name="role_id") //en que columna se va a asociar
    private Role role;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fecha_nac")
    private Date fechaNac;

    public User() {}
    public User(long id, String nombre, String apellido, String email, String telefono, Date fechaNac) {
        setId(id);
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.fechaNac = fechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
