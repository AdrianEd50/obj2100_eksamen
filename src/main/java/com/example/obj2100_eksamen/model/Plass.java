package com.example.obj2100_eksamen.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tblplass", schema = "kino")
@IdClass(PlassId.class)
public class Plass {

    @Id
    @Column(name = "p_radnr")
    private int radNr;

    @Id
    @Column(name = "p_setenr")
    private int seteNr;

    @Id
    @Column(name = "p_kinosalnr")
    private int kinosalNr;
}