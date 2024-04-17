package com.cccmant.api_mantenimientos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cccmant.api_mantenimientos.model.Tecnico;

@Repository
public interface AutenticacionRepository extends JpaRepository<Tecnico, Long> {

    @Query("SELECT t FROM Tecnico t WHERE t.email = ?1 AND t.contraseña = ?2")
    Optional<Tecnico> loginTecnico(String email, String contraseña);
}
