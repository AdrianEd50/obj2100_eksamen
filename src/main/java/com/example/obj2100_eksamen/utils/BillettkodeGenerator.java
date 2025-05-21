package com.example.obj2100_eksamen.utils;

import java.util.Random;

public class BillettkodeGenerator {
    public static String genererKode() {
        String bokstaver = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder kode = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 4; i++) kode.append(bokstaver.charAt(rand.nextInt(26)));
        for (int i = 0; i < 2; i++) kode.append(rand.nextInt(10));
        return kode.toString();
    }
}