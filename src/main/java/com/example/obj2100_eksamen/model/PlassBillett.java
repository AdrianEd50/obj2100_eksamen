/*package com.example.obj2100_eksamen.model;

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
    private Integer visningsnr;

    public void setPbVisningsnr(Integer visningsnr) {
        this.visningsnr = visningsnr;
    }
}*/


package com.example.obj2100_eksamen.model;

import jakarta.persistence.*;

@Entity
@IdClass(PlassBillettId.class)
public class PlassBillett {

    @Id
    private int pbRadNr;

    @Id
    private int pbSeteNr;

    @Column(nullable = false)
    private int visningsnr;

    public PlassBillett() {}

    public PlassBillett(int pbRadNr, int pbSeteNr, int visningsnr) {
        this.pbRadNr = pbRadNr;
        this.pbSeteNr = pbSeteNr;
        this.visningsnr = visningsnr;
    }

    // getters og setters
    public int getPbRadNr() { return pbRadNr; }
    public void setPbRadNr(int pbRadNr) { this.pbRadNr = pbRadNr; }
    public int getPbSeteNr() { return pbSeteNr; }
    public void setPbSeteNr(int pbSeteNr) { this.pbSeteNr = pbSeteNr; }
    public int getVisningsnr() { return visningsnr; }
    public void setVisningsnr(int visningsnr) { this.visningsnr = visningsnr; }
}