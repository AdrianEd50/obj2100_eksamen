/*package com.example.obj2100_eksamen.controller;

import com.example.obj2100_eksamen.DTO.BestillingRequestDTO;
import com.example.obj2100_eksamen.DTO.BillettBestillingDTO;
import com.example.obj2100_eksamen.DTO.PlassDTO;
import com.example.obj2100_eksamen.service.BestillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bestilling")
public class BestillingController {

    @Autowired
    private BestillingService bestillingService;

    @PostMapping("/reserver")
    public ResponseEntity<String> reserver(@RequestBody BestillingRequestDTO request) {
        BillettBestillingDTO dto = request.getBillett();
        var plasser = request.getPlasser();

        for (PlassDTO p : plasser) {
            if (!bestillingService.erPlassLedig(p, dto.getVisningsnr())) {
                return ResponseEntity.status(409).body("En eller flere plasser er allerede opptatt.");
            }
        }

        String kode = bestillingService.registrerBestilling(dto, plasser);
        return ResponseEntity.ok("Bestilling bekreftet! Din kode: " + kode);
    }
}*/


package com.example.obj2100_eksamen.controller;

import com.example.obj2100_eksamen.DTO.*;
import com.example.obj2100_eksamen.model.Visning;
import com.example.obj2100_eksamen.repository.VisningRepository;
import com.example.obj2100_eksamen.service.BestillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bestilling")
public class BestillingController {

    @Autowired
    private BestillingService bestillingService;

    @Autowired
    private VisningRepository visningRepository;

    @GetMapping("/visninger")
    public List<VisningDTO> hentTilgjengeligeVisninger() {
        return bestillingService.hentKommendeVisninger();
    }

    @GetMapping("/plasser/{visningsnr}")
    public List<PlassDTO> hentLedigePlasser(@PathVariable int visningsnr) {
        return bestillingService.hentLedigePlasserForVisning(visningsnr);
    }

    @PostMapping("/registrer")
    public ResponseEntity<BestillingsResponsDTO> registrerBestilling(@RequestBody BillettBestillingDTO dto) {
        String kode = bestillingService.registrerBestilling(dto);
        double pris = visningRepository.findById(dto.getVisningsnr()).get().getPris().doubleValue();
        int antall = dto.getPlasser().size();

        BestillingsResponsDTO respons = new BestillingsResponsDTO();
        respons.setBillettkode(kode);
        respons.setAntall(antall);
        respons.setTotalPris(antall * pris);

        return ResponseEntity.ok(respons);
    }
}







/*package com.example.obj2100_eksamen.controller;

import com.example.obj2100_eksamen.DTO.BillettBestillingDTO;
import com.example.obj2100_eksamen.DTO.PlassDTO;
import com.example.obj2100_eksamen.model.Billett;
import com.example.obj2100_eksamen.model.Visning;
import com.example.obj2100_eksamen.repository.BillettRepository;
import com.example.obj2100_eksamen.service.BestillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/bestilling")
public class BestillingController {

    @Autowired
    private BestillingService bestillingService;

    @GetMapping("/visninger")
    public ResponseEntity<List<Visning>> hentTilgjengelige() {
        return ResponseEntity.ok(bestillingService.hentVisningerInnen30Min());
    }

    @PostMapping("/reserver")
    public ResponseEntity<String> reserver(@RequestBody BillettBestillingDTO dto,
                                           @RequestBody List<PlassDTO> plasser) {
        for (PlassDTO p : plasser) {
            if (!bestillingService.erPlassLedig(p, dto.getVisningsnr())) {
                return ResponseEntity.status(409).body("En eller flere plasser er allerede opptatt.");
            }
        }

        String kode = bestillingService.registrerBestilling(dto, plasser);
        return ResponseEntity.ok("Bestilling bekreftet! Din kode: " + kode);
    }
}*/














/*@RestController
@RequestMapping("/bestilling")
public class BestillingController {

    @Autowired
    private BillettRepository billettRepository;

    @PostMapping("/billett")
    public ResponseEntity<Billett> bestillBillett(@RequestBody BillettBestillingDTO dto) {
        if (dto == null || dto.getBillettkode() == null || dto.getVisningsnr() == null) {
            return ResponseEntity.badRequest().build();
        }

        Billett billett = new Billett();
        billett.setBillettkode(dto.getBillettkode());
        billett.setVisningsnr(dto.getVisningsnr());
        billett.setErBetalt(false);

        billettRepository.save(billett);

        // TODO: Lagre plasser via et PlassRepository hvis det finnes
        return ResponseEntity.ok(billett);
    }

    @PutMapping("/billett/{kode}/betalt")
    public ResponseEntity<String> markerSomBetalt(@PathVariable String kode) {
        Optional<Billett> optionalBillett = billettRepository.findById(kode);

        if (optionalBillett.isPresent()) {
            Billett billett = optionalBillett.get();
            billett.setErBetalt(true);
            billettRepository.save(billett);
            return ResponseEntity.ok("Billett merket som betalt.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/billetter")
    public ResponseEntity<List<Billett>> hentAlleBilletter() {
        return ResponseEntity.ok(billettRepository.findAll());
    }
}*/
