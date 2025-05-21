package com.example.obj2100_eksamen.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tblkinosal", schema = "kino")
public class Kinosal {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "k_kinosalnr")
    private int kinosalNr;

    @Column(name = "k_kinonavn")
    private String kinoNavn;

    @Column(name = "k_kinosalnavn")
    private String kinosalNavn;

    public Kinosal(int kinosalNr, String kinoNavn, String kinosalNavn) {
        this.kinosalNr = kinosalNr;
        this.kinoNavn = kinoNavn;
        this.kinosalNavn = kinosalNavn;
    }
}