/*package com.example.obj2100_eksamen.controller;

import com.example.obj2100_eksamen.DTO.VisningDTO;
import com.example.obj2100_eksamen.model.Visning;
import com.example.obj2100_eksamen.repository.FilmRepository;
import com.example.obj2100_eksamen.repository.VisningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planlegger")
public class PlanleggerController {

    @Autowired
    private VisningRepository visningRepository;

    @Autowired
    private FilmRepository filmRepository;

    @PostMapping("/visning")
    public ResponseEntity<String> leggTilVisning(@RequestBody VisningDTO visningDTO) {
        if (visningDTO.getFilmtittel() == null || visningDTO.getTidspunkt() == null) {
            return ResponseEntity.badRequest().body("Tittel og tidspunkt må oppgis.");
        }

        // Finn filmen basert på tittel
        var film = filmRepository.findById(Math.toIntExact(visningDTO.getFilmtittel()));

        if (film.isEmpty()) {
            return ResponseEntity.status(404).body("Film ikke funnet.");
        }

        Visning visning = new Visning();
        visning.setFilmtittel(Math.toIntExact(visningDTO.getFilmtittel()));
        visning.setTidspunkt(visningDTO.getTidspunkt());
        visning.getKinosalNr(visningDTO.getKinosalnr());

        visningRepository.save(visning);
        return ResponseEntity.ok("Visning lagt til.");
    }

    @GetMapping("/visninger")
    public ResponseEntity<List<Visning>> hentAlleVisninger() {
        return ResponseEntity.ok(visningRepository.findAll());
    }
}*/