package com.cccmant.api_mantenimientos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cccmant.api_mantenimientos.model.Ubicacion;
import com.cccmant.api_mantenimientos.repository.UbicacionRepository;

@Service
public class UbicacionServiceImpl implements UbicacionService {

    @Autowired
    UbicacionRepository repository;

    @Override
    public List<Ubicacion> consultar() {
        return repository.findAll();
    }

    @Override
    public Optional<Ubicacion> consultarPorId(Long codigo) {
        if (codigo == null) {
            return Optional.empty();
        }
        return repository.findById(codigo);
    }

    @Override
    public Ubicacion crear(Ubicacion ubicacion) {
        Optional<Ubicacion> ubicacionCrear = repository.findById(ubicacion.getCodigo());
        if (ubicacionCrear.isPresent()) {
            return null;
        }
        return repository.save(ubicacion);
    }

    @Override
    public Ubicacion actualizar(Ubicacion ubicacion) {
        Optional<Ubicacion> ubicacionActualizar = repository.findById(ubicacion.getCodigo());
        if (ubicacionActualizar.isPresent()) {
            return repository.save(ubicacion);
        }
        return null;
    }

    @Override
    public String eliminar(Long codigo) {
        Optional<Ubicacion> ubicacionEliminar = repository.findById(codigo);
        if (ubicacionEliminar.isPresent()) {
            repository.delete(ubicacionEliminar.get());
            return "Registro eliminado correctamente";
        }
        return "Registro no encontrado, no se puede eliminar";

    }
}
