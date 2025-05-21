package com.example.obj2100_eksamen.controller;

import com.example.obj2100_eksamen.DTO.PlassDTO;
import com.example.obj2100_eksamen.model.Plass;
import com.example.obj2100_eksamen.repository.PlassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plass")
public class PlassController {

    @Autowired
    private PlassRepository plassRepository;

    @GetMapping("/alle")
    public ResponseEntity<List<Plass>> hentAllePlasser() {
        return ResponseEntity.ok(plassRepository.findAll());
    }

    @PostMapping("/lagre")
    public ResponseEntity<String> leggTilPlass(@RequestBody PlassDTO dto) {
        Plass plass = new Plass();
        plass.setRadNr(dto.getRadNr());
        plass.setSeteNr(dto.getSeteNr());
        plass.setKinosalNr(dto.getKinosalNr());

        plassRepository.save(plass);
        return ResponseEntity.ok("Plass lagret");
    }
}