package com.example.obj2100_eksamen.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tblfilm", schema = "kino")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_filmnr")
    private int filmnr;

    @Column(name = "f_filmnavn", nullable = false)
    private String navn;

    public Film(int filmnr, String navn) {
        this.filmnr = filmnr;
        this.navn = navn;
    }

    public Film() {
    }

    @Override
    public String toString() {
        return navn + " (ID: " + filmnr + ")";
    }
}