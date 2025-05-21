package com.example.obj2100_eksamen.service;

import com.example.obj2100_eksamen.DTO.BillettBestillingDTO;
import com.example.obj2100_eksamen.DTO.PlassDTO;
import com.example.obj2100_eksamen.model.Billett;
import com.example.obj2100_eksamen.model.PlassBillett;
import com.example.obj2100_eksamen.repository.BillettRepository;
import com.example.obj2100_eksamen.repository.PlassBillettRepository;
import com.example.obj2100_eksamen.repository.VisningRepository;
import com.example.obj2100_eksamen.utils.BillettkodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BestillingService {

    @Autowired
    private VisningRepository visningRepository;

    @Autowired
    private BillettRepository billettRepository;

    @Autowired
    private PlassBillettRepository plassBillettRepository;

    public boolean erPlassLedig(PlassDTO p, int visningsnr) {
        return !plassBillettRepository.existsByPbKinosalNrAndPbRadNrAndPbSeteNrAndPbBillettKode(
                p.getKinosalNr(), p.getRadNr(), p.getSeteNr(), String.valueOf(visningsnr) // midlertidig!
        );
    }

    public String registrerBestilling(BillettBestillingDTO dto, List<PlassDTO> plasser) {
        String kode = BillettkodeGenerator.genererKode();
        while (billettRepository.existsById(kode)) {
            kode = BillettkodeGenerator.genererKode();
        }

        Billett billett = new Billett(kode, dto.getVisningsnr(), false);
        billettRepository.save(billett);

        for (PlassDTO p : plasser) {
            PlassBillett pb = new PlassBillett();
            pb.setPbBillettKode(kode);
            pb.setPbKinosalNr(p.getKinosalNr());
            pb.setPbRadNr(p.getRadNr());
            pb.setPbSeteNr(p.getSeteNr());
            plassBillettRepository.save(pb);
        }

        return kode;
    }
}

















/*package com.example.obj2100_eksamen.service;

import com.example.obj2100_eksamen.DTO.BillettBestillingDTO;
import com.example.obj2100_eksamen.DTO.PlassDTO;
import com.example.obj2100_eksamen.model.Billett;
import com.example.obj2100_eksamen.model.PlassBillett;
import com.example.obj2100_eksamen.model.Visning;
import com.example.obj2100_eksamen.repository.*;
import com.example.obj2100_eksamen.utils.BillettkodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BestillingService {

    @Autowired
    private VisningRepository visningRepository;

    @Autowired
    private BillettRepository billettRepository;

    @Autowired
    private PlassBillettRepository plassBillettRepository;

    public List<Visning> hentVisningerInnen30Min() {
        LocalDateTime nå = LocalDateTime.now().plusMinutes(30);
        return visningRepository.findAll().stream()
                .filter(v -> v.getTidspunkt().isAfter(nå))
                .toList();
    }

    public boolean erPlassLedig(PlassDTO p, int visningsnr) {
        return !plassBillettRepository.existsByPbKinosalNrAndPbRadNrAndPbSeteNrAndPbBillettKode(
                p.getKinosalNr(), p.getRadNr(), p.getSeteNr(), String.valueOf(visningsnr)
        );
    }

    public String registrerBestilling(BillettBestillingDTO dto, List<PlassDTO> plasser) {
        String kode = BillettkodeGenerator.genererKode();
        while (billettRepository.existsById(kode)) {
            kode = BillettkodeGenerator.genererKode();
        }

        Billett billett = new Billett(kode, dto.getVisningsnr(), false);
        billettRepository.save(billett);

        for (PlassDTO p : plasser) {
            PlassBillett pb = new PlassBillett();
            pb.setPbBillettKode(kode);
            pb.setPbKinosalNr(p.getKinosalNr());
            pb.setPbRadNr(p.getRadNr());
            pb.setPbSeteNr(p.getSeteNr());
            plassBillettRepository.save(pb);
        }

        return kode;
    }
}*/