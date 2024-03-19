package com.edteam.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "user")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {


    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="role_id")
    @Getter @Setter
    private Role role;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password")
    @Getter @Setter
    private String password;

    @Column(name = "nombre")
    @Getter @Setter
    private String nombre;

    @Column(name = "apellido")
    @Getter @Setter
    private String apellido;

    @Column(name = "email")
    @Getter @Setter
    private String email;

    @Column(name = "telefono")
    @Getter @Setter
    private String telefono;

    @Column(name = "fecha_nac")
    @Getter @Setter
    private Date fechaNac;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(role, user.role) && Objects.equals(password, user.password) && Objects.equals(nombre, user.nombre) && Objects.equals(apellido, user.apellido) && Objects.equals(email, user.email) && Objects.equals(telefono, user.telefono) && Objects.equals(fechaNac, user.fechaNac);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, password, nombre, apellido, email, telefono, fechaNac);
    }
}