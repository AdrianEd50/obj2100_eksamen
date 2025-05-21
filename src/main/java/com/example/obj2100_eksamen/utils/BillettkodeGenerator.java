package com.example.obj2100_eksamen.utils;

import java.util.UUID;

public class BillettkodeGenerator {
    public static String genererKode() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
