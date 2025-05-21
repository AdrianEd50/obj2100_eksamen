package com.example.obj2100_eksamen.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tblbillett", schema = "kino")
public class Billett {

    @Id
    @Column(name = "b_billettkode")
    private String billettkode;

    @Column(name = "b_visningsnr")
    private int visningsnr;

    @Column(name = "b_erbetalt")
    private boolean erBetalt;

    public Billett() {}

    public Billett(String billettkode, int visningsnr, boolean erBetalt) {
        this.billettkode = billettkode;
        this.visningsnr = visningsnr;
        this.erBetalt = erBetalt;
    }
}
