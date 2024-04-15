package com.cccmant.api_mantenimientos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cccmant.api_mantenimientos.model.Tecnico;
import com.cccmant.api_mantenimientos.repository.TecnicosRepository;

@Service
public class TecnicoServiceImpl implements TecnicosService {

    @Autowired
    private TecnicosRepository repository;

    @Override
    public List<Tecnico> consultarTecnicos() {
        return repository.findAll();
    }

    @Override
    public Optional<Tecnico> consultarTecnico(Long id, String email) {
        if (id == null && email == null) {
            return Optional.empty();
        }

        if (id == null) {
            List<Tecnico> lista = repository.findByCorreo(email);
            return Optional.of(lista.get(0));
        }
        return repository.findById(id);
    }

    @Override
    public Tecnico crearTecnico(Tecnico tecnico) {
        Optional<Tecnico> consultarParaCrear = repository.findById(tecnico.getIdentificacion());
        if (consultarParaCrear.isPresent()) {
            return null;
        }
        List<Tecnico> tecnicos = repository.findByCorreo(tecnico.getEmail());
        if (tecnicos.size() > 0) {
            return tecnicos.get(0);
        }
        return repository.save(tecnico);
    }

    @Override
    public Tecnico actualizarTecnico(Tecnico tecnico) {
        Optional<Tecnico> consultarParaActualizar = repository.findById(tecnico.getIdentificacion());
        if (consultarParaActualizar.isPresent()) {
            return repository.save(tecnico);
        }
        return null;
    }

    @Override
    public String eliminarTecnico(Long id) {
        Optional<Tecnico> consultarParaEliminar = repository.findById(id);
        if (consultarParaEliminar.isPresent()) {
            repository.delete(consultarParaEliminar.get());
            return "El registro ha sido eliminado correctamente";
        }
        return "La orden no se encontro, no se puede eliminar";
    }
}
