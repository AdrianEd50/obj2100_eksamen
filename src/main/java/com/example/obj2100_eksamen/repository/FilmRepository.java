package com.example.obj2100_eksamen.repository;

import com.example.obj2100_eksamen.model.Film;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    // Alle standard CRUD-metoder er inkludert automatisk
}