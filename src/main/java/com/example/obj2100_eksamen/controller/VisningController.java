/*package com.example.obj2100_eksamen.controller;


import com.example.obj2100_eksamen.model.Visning;
import com.example.obj2100_eksamen.service.VisningService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/visninger")
public class VisningController {

    private final VisningService visningService;

    public VisningController(VisningService visningService) {
        this.visningService = visningService;
    }

    // Hent alle visninger
    @GetMapping
    public List<Visning> hentAlle() {
        return visningService.hentAlleVisninger();
    }

    // Hent visning med ID
    @GetMapping("/{id}")
    public ResponseEntity<Visning> hentMedId(@PathVariable int id) {
        return visningService.hentMedId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



    // Lagre visning (ÅPEN)
    @PostMapping
    public ResponseEntity<Visning> lagre(@RequestBody Visning visning) {
        Visning lagret = visningService.lagre(visning);
        return ResponseEntity.ok(lagret);
    }

    // Slett visning (ÅPEN)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> slett(@PathVariable int id) {
        visningService.slett(id);
        return ResponseEntity.noContent().build();
    }
}*/






package com.example.obj2100_eksamen.controller;

import com.example.obj2100_eksamen.model.Visning;
import com.example.obj2100_eksamen.service.VisningService;
import com.example.obj2100_eksamen.session.BrukerSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/visninger")
public class VisningController {

    private final VisningService visningService;

    @Autowired
    private BrukerSession session;

    public VisningController(VisningService visningService) {
        this.visningService = visningService;
    }

    // ÅPEN: Hent alle visninger
    @GetMapping
    public List<Visning> hentAlle() {
        return visningService.hentAlleVisninger();
    }

    // ÅPEN: Hent visning med ID
    @GetMapping("/{id}")
    public ResponseEntity<Visning> hentMedId(@PathVariable int id) {
        return visningService.hentMedId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ÅPEN: Hent visninger som starter om 30+ minutter
    @GetMapping("/kommende")
    public List<Visning> hentKommendeVisninger() {
        LocalDate idag = LocalDate.now();
        LocalTime grense = LocalTime.now().plusMinutes(30);
        return visningService.hentKommendeVisninger(idag, grense);
    }

    // BESKYTTET: Krever innlogging som planlegger
    @PostMapping
    public ResponseEntity<?> lagre(@RequestBody Visning visning) {
        if (session == null || !session.harRolle("planlegger")) {
            return ResponseEntity.status(403).body("Tilgang nektet: Krever rolle planlegger");
        }
        return ResponseEntity.ok(visningService.lagre(visning));
    }

    // BESKYTTET: Krever innlogging som planlegger
    @DeleteMapping("/{id}")
    public ResponseEntity<?> slett(@PathVariable int id) {
        if (session == null || !session.harRolle("planlegger")) {
            return ResponseEntity.status(403).body("Tilgang nektet: Krever rolle planlegger");
        }
        visningService.slett(id);
        return ResponseEntity.noContent().build();
    }
}
