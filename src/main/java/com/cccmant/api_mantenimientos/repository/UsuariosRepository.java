package com.cccmant.api_mantenimientos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cccmant.api_mantenimientos.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    @Query("SELECT u FROM Usuarios u WHERE u.nombres = :nombres")
    List<Usuarios> findByNombres(String nombres);

    @Query("SELECT u FROM Usuarios u WHERE u.nombres = :nombres")
    Optional<Usuarios> findByNombresO(String nombres);

    @Query("SELECT u FROM Usuarios u WHERE u.apellidos = :apellidos")
    List<Usuarios> findByApellidos(String apellidos);
}
