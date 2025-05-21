package com.example.obj2100_eksamen.controller;

import com.example.obj2100_eksamen.DTO.RegistrerBrukerDTO;
import com.example.obj2100_eksamen.model.Bruker;
import com.example.obj2100_eksamen.repository.BrukerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private BrukerRepository brukerRepository;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody Bruker loginRequest) {
        if (loginRequest.getBrukernavn() == null || loginRequest.getPassord() == null) {
            return ResponseEntity.badRequest().body("Brukernavn og passord må oppgis.");
        }

        Optional<Bruker> funnetBruker = brukerRepository.findById(loginRequest.getBrukernavn());

        if (funnetBruker.isPresent()) {
            Bruker bruker = funnetBruker.get();

            if (bruker.getPassord().equals(loginRequest.getPassord())) {
                return ResponseEntity.ok("Innlogging vellykket.");
            } else {
                return ResponseEntity.status(401).body("Feil passord.");
            }
        }

        return ResponseEntity.status(404).body("Bruker finnes ikke.");
    }

    @PostMapping("/registrer")
    public ResponseEntity<String> registrer(@RequestBody RegistrerBrukerDTO dto) {
        if (dto.getBrukernavn() == null || dto.getPinKode() == null) {
            return ResponseEntity.badRequest().body("Brukernavn og pinkode må oppgis.");
        }

        if (brukerRepository.existsById(dto.getBrukernavn())) {
            return ResponseEntity.badRequest().body("Bruker finnes allerede.");
        }

        Bruker nyBruker = new Bruker(dto.getBrukernavn(), dto.getPinKode(), dto.isErPlanlegger());
        brukerRepository.save(nyBruker);
        return ResponseEntity.ok("Bruker registrert.");
    }

    @GetMapping("/alle")
    public ResponseEntity<List<Bruker>> hentAlleBrukere() {
        return ResponseEntity.ok(brukerRepository.findAll());
    }
}