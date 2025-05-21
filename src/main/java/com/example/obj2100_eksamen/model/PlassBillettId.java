package com.example.obj2100_eksamen.model;

import java.io.Serializable;
import java.util.Objects;

public class PlassBillettId implements Serializable {

    private int pbRadNr;
    private int pbSeteNr;

    public PlassBillettId() {}

    public PlassBillettId(int pbRadNr, int pbSeteNr) {
        this.pbRadNr = pbRadNr;
        this.pbSeteNr = pbSeteNr;
    }

    // equals og hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlassBillettId)) return false;
        PlassBillettId that = (PlassBillettId) o;
        return pbRadNr == that.pbRadNr && pbSeteNr == that.pbSeteNr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pbRadNr, pbSeteNr);
    }
}