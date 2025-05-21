package com.example.obj2100_eksamen.repository;

import com.example.obj2100_eksamen.model.Billett;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BillettRepository extends JpaRepository<Billett, String> {
    List<Billett> findByVisningsnr(int visningsnr);
}