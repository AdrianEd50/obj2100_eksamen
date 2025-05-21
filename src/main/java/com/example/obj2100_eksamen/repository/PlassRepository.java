package com.example.obj2100_eksamen.repository;

import com.example.obj2100_eksamen.model.Plass;
import com.example.obj2100_eksamen.model.PlassId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlassRepository extends JpaRepository<Plass, PlassId> {
}
