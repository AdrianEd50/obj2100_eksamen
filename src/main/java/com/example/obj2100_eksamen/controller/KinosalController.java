package com.example.obj2100_eksamen.controller;

import com.example.obj2100_eksamen.DTO.KinosalDTO;
import com.example.obj2100_eksamen.model.Kinosal;
import com.example.obj2100_eksamen.repository.KinosalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/kinosal")
public class KinosalController {

    @Autowired
    private KinosalRepository kinosalRepository;

    // GET: Hent alle kinosaler som DTO
    @GetMapping("/alle")
    public ResponseEntity<List<KinosalDTO>> hentAlleKinosaler() {
        List<KinosalDTO> kinosaler = kinosalRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(kinosaler);
    }

    // POST: Lagre en ny kinosal
    @PostMapping("/leggtil")
    public ResponseEntity<KinosalDTO> leggTilKinosal(@RequestBody KinosalDTO dto) {
        Kinosal nySal = new Kinosal();
        nySal.setKinosalNr(dto.getKinosalNr()); // Legg til denne linjen
        nySal.setKinoNavn(dto.getKinoNavn());
        nySal.setKinosalNavn(dto.getKinosalNavn());
        kinosalRepository.save(nySal);
        return ResponseEntity.ok(toDTO(nySal));
    }

    // 🔁 Hjelpemetode for mapping
    private KinosalDTO toDTO(Kinosal sal) {
        KinosalDTO dto = new KinosalDTO();
        dto.setKinosalNr(sal.getKinosalNr());
        dto.setKinoNavn(sal.getKinoNavn());
        dto.setKinosalNavn(sal.getKinosalNavn());
        return dto;
    }
}