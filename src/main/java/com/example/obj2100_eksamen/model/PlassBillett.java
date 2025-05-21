package com.example.obj2100_eksamen.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tblplassbillett", schema = "kino")
@IdClass(PlassBillettId.class)
public class PlassBillett {
    @Id
    @Column(name = "pb_radnr")
    private int pbRadNr;

    @Id
    @Column(name = "pb_setenr")
    private int pbSeteNr;

    @Id
    @Column(name = "pb_kinosalnr")
    private int pbKinosalNr;

    @Id
    @Column(name = "pb_billettkode")
    private String pbBillettKode;
}

