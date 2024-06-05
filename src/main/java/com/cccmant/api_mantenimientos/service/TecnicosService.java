package com.cccmant.api_mantenimientos.service;

import java.util.List;
import java.util.Optional;

import com.cccmant.api_mantenimientos.model.Tecnico;

public interface TecnicosService {
    public List<Tecnico> consultarTecnicos();

    public Optional<Tecnico> consultarTecnico(String email);

    public Optional<Tecnico> consultarTecnicoPorIdentificacion(long identificacion);

    public Tecnico crearTecnico(Tecnico tecnico);

    public Tecnico actualizarTecnico(Tecnico tecnico);

    public String eliminarTecnico(Long id);
}
