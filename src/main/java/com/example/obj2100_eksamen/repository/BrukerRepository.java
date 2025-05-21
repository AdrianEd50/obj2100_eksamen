package com.example.obj2100_eksamen.repository;

import com.example.obj2100_eksamen.model.Bruker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrukerRepository extends JpaRepository<Bruker, String> {
    // Finner bruker basert på brukernavn (primærnøkkel)
    Bruker findByBrukernavn(String brukernavn);
}
