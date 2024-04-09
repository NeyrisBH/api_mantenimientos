package com.cccmant.api_mantenimientos.service;

import java.util.List;
import java.util.Optional;

import com.cccmant.api_mantenimientos.model.Usuarios;

public interface UsuariosService {
    public List<Usuarios> consultar();

    public Optional<Usuarios> consultarUsuario(String nombres, String apellidos);

    public Usuarios crear(Usuarios usuario);

    public Usuarios actualizar(Usuarios usuario);

    public String eliminar(Long codigo);
}
