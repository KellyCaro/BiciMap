package com.example.BiciMap.servicio;


import com.example.BiciMap.interfaz.IUsuario;
import com.example.BiciMap.interfazService.IUsuarioServicio;
import com.example.BiciMap.modelo.Usuarios;
import com.example.BiciMap.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioServicio {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private IUsuario data;

    @Override
    public List<Usuarios> listar() {
        return (List<Usuarios>) usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuarios> listarId(int id) {
        return Optional.empty();
    }

    @Override
    public Usuarios save(Usuarios p) {
        return p;
    }

    @Override
    public void delete(int id) {

    }


}
