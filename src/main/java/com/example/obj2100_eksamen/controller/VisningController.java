package com.example.obj2100_eksamen.controller;

import com.example.obj2100_eksamen.model.Visning;
import com.example.obj2100_eksamen.service.VisningService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/visninger")
public class VisningController {

    private final VisningService visningService;

    public VisningController(VisningService visningService) {
        this.visningService = visningService;
    }

    @GetMapping("/kommende")
    public List<Visning> hentKommendeVisninger() {
        return visningService.hentAktuelleVisninger();
    }
}