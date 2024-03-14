package com.edteam.demo.models;
import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false) //no se va a poder modificar, y no puede tener valor nulo
    private long id;

    @Column(columnDefinition = "DATETIME", updatable = false)
    protected Date createdDate;

    @Column(columnDefinition = "DATETIME", updatable = false)
    protected Date updatedDate;

    @PrePersist
    protected void onCreate(){
        updatedDate = new Date();
        if (createdDate == null) { //si no hay fecha creada
            createdDate = new Date(); //la crea
        }
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
