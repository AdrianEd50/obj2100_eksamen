/*package com.example.obj2100_eksamen.repository;

import com.example.obj2100_eksamen.model.Visning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisningRepository extends JpaRepository<Visning, Integer> {
    // Ingen ekstra metoder trengs for å hente alle
}*/




package com.example.obj2100_eksamen.repository;

import com.example.obj2100_eksamen.model.Visning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface VisningRepository extends JpaRepository<Visning, Integer> {
    List<Visning> findByDatoAndStarttidAfter(LocalDate dato, LocalTime tid);
    List<Visning> findByFilmnr(int filmnr);
}

