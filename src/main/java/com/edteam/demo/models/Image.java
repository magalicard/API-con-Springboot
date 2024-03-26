package com.edteam.demo.models;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;
@Entity
@Table(name = "imagen")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Image {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", updatable = false, nullable = false) //no se va a poder modificar, y no puede tener valor nulo
        private Long id;

        @Column(name = "uuid", unique = true)
        @Getter @Setter
        private UUID uuid; // Campo UUID agregado

        @Column(name = "nombre")
        @Getter @Setter
        private String nombre;

        @Column(name = "tipo")
        @Getter @Setter
        private String tipo;

        @Column(name = "tamano")
        @Getter @Setter
        private Long tamano;

        @Lob
        @Column(name = "pixel")
        @Getter @Setter
        private byte[] pixel;


}


