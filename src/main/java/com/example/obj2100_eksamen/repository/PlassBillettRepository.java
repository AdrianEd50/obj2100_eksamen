/*package com.example.obj2100_eksamen.repository;

import com.example.obj2100_eksamen.model.PlassBillett;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlassBillettRepository extends JpaRepository<PlassBillett, Long> {

    // Eksempel: sjekk om en plass er opptatt for en gitt visning
    boolean existsByPbKinosalNrAndPbRadNrAndPbSeteNrAndPbBillettKode(int kinosalNr, int radNr, int seteNr, String billettKode);
}*/



/*package com.example.obj2100_eksamen.repository;

import com.example.obj2100_eksamen.model.PlassBillett;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlassBillettRepository extends JpaRepository<PlassBillett, Long> {
    boolean existsByPbKinosalNrAndPbRadNrAndPbSeteNrAndPbBillettKode(
            int pbKinosalNr, int pbRadNr, int pbSeteNr, String pbBillettKode
    );
}*/


/*import com.example.obj2100_eksamen.model.PlassBillett;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlassBillettRepository extends JpaRepository<PlassBillett, Long> {
    int countByPbKinosalNrAndPbBillettKodeStartingWith(int kinosalNr, String visningsnrPrefix);

    int countByPbVisningsnr(int visningnr);

    boolean existsByPbRadNrAndPbSeteNrAndPbVisningsnr(int rad, int sete, int visningsnr);
}*/


package com.example.obj2100_eksamen.repository;

import com.example.obj2100_eksamen.model.PlassBillett;
import com.example.obj2100_eksamen.model.PlassBillettId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlassBillettRepository extends JpaRepository<PlassBillett, PlassBillettId> {
    boolean existsByPbRadNrAndPbSeteNrAndVisningsnr(int rad, int sete, int visningsnr);
    int countByVisningsnr(int visningsnr);
}