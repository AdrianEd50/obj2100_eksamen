package com.example.obj2100_eksamen.model;

import java.io.Serializable;
import java.util.Objects;

public class PlassBillettId implements Serializable {
    private int pbRadNr;
    private int pbSeteNr;
    private int pbKinosalNr;
    private String pbBillettKode;

    // Konstruktører
    public PlassBillettId() {}
    public PlassBillettId(int rad, int sete, int sal, String kode) {
        this.pbRadNr = rad;
        this.pbSeteNr = sete;
        this.pbKinosalNr = sal;
        this.pbBillettKode = kode;
    }

    // equals() og hashCode() MÅ være implementert for IdClass!
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlassBillettId)) return false;
        PlassBillettId that = (PlassBillettId) o;
        return pbRadNr == that.pbRadNr &&
                pbSeteNr == that.pbSeteNr &&
                pbKinosalNr == that.pbKinosalNr &&
                Objects.equals(pbBillettKode, that.pbBillettKode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pbRadNr, pbSeteNr, pbKinosalNr, pbBillettKode);
    }
}