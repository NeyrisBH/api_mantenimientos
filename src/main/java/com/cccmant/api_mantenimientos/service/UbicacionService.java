package com.cccmant.api_mantenimientos.service;

import java.util.List;
import java.util.Optional;

import com.cccmant.api_mantenimientos.model.Ubicacion;

public interface UbicacionService {
    public List<Ubicacion> consultar();

    public Optional<Ubicacion> consultarPorId(Long codigo);

    public Ubicacion crear(Ubicacion ubicacion);

    public Ubicacion actualizar(Ubicacion ubicacion);

    public String eliminar(Long codigo);
}
