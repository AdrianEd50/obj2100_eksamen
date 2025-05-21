package com.example.obj2100_eksamen.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbllogin", schema = "kino")
public class Bruker {

    @Getter
    @Setter
    @Id
    @Column(name = "l_brukernavn")
    private String brukernavn;


    @Column(name = "l_pinkode")
    private String pinKode;

    @Column(name = "l_erplanlegger")
    private boolean erPlanlegger;

    public Bruker(String Brukernavn, String PinKode, boolean erPlanlegger){
        this.brukernavn=Brukernavn;
        this.pinKode=PinKode;
        this.erPlanlegger=erPlanlegger;
    }

    public Bruker() {

    }



    public boolean geterPlanlegger(){
        return erPlanlegger;
    }

    public String getPassord() {
        return pinKode;
    }

}
