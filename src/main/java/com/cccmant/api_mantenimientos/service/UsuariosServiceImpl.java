package com.cccmant.api_mantenimientos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cccmant.api_mantenimientos.model.Usuarios;
import com.cccmant.api_mantenimientos.repository.UsuariosRepository;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    UsuariosRepository repository;

    @Override
    public List<Usuarios> consultar() {
        return repository.findAll();
    }

    @Override
    public Optional<Usuarios> consultarUsuario(String nombres, String apellidos) {
        if (nombres == null && apellidos == null) {
            return Optional.empty();
        }
        if (nombres == null) {
            List<Usuarios> lista = repository.findByApellidos(apellidos);
            return Optional.of(lista.get(0));
        }
        return repository.findByNombresO(nombres);
    }

    @Override
    public Optional<Usuarios> consultarUsuarioPorId(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return repository.findById(id);
    }

    @Override
    public Usuarios crear(Usuarios usuario) {
        Optional<Usuarios> consultarParaCrear = repository.findById(usuario.getId());
        if (consultarParaCrear.isPresent()) {
            return null;
        }
        List<Usuarios> usuarios = repository.findByNombres(usuario.getNombres());
        if (usuarios.size() > 0) {
            return usuarios.get(0);
        }
        return repository.save(usuario);
    }

    @Override
    public Usuarios actualizar(Usuarios usuario) {
        Optional<Usuarios> usuarioActualizar = repository.findById(usuario.getId());
        if (usuarioActualizar.isPresent()) {
            return repository.save(usuario);
        }
        return null;
    }

    @Override
    public String eliminar(Long codigo) {
        Optional<Usuarios> consultarEliminar = repository.findById(codigo);
        if (consultarEliminar.isPresent()) {
            repository.delete(consultarEliminar.get());
            return "Registro eliminado correctamente";
        }
        return "Registro no encontrado, no se puede eliminar";
    }
}
