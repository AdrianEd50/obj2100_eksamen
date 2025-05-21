package com.example.obj2100_eksamen.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class VisningDTO {
    private int visningnr;
    private int filmnr;
    private int kinosalnr;
    private LocalDate dato;
    private LocalTime starttid;
    private double pris;
    private int ledigePlasser;
}