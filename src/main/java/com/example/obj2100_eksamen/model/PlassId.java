package com.example.obj2100_eksamen.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
public class PlassId implements Serializable {

    private int radNr;
    private int seteNr;
    private int kinosalNr;

    public PlassId() {}

    public PlassId(int radNr, int seteNr, int kinosalNr) {
        this.radNr = radNr;
        this.seteNr = seteNr;
        this.kinosalNr = kinosalNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlassId)) return false;
        PlassId that = (PlassId) o;
        return radNr == that.radNr && seteNr == that.seteNr && kinosalNr == that.kinosalNr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radNr, seteNr, kinosalNr);
    }
}