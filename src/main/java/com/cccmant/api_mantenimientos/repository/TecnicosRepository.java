package com.cccmant.api_mantenimientos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cccmant.api_mantenimientos.model.Tecnico;

public interface TecnicosRepository extends JpaRepository<Tecnico, Long> {
    @Query("SELECT t FROM Tecnico t WHERE t.email = :email")
    List<Tecnico> findByCorreo(String email);
}
