package com.weg.biblioteca.service;

import com.weg.biblioteca.model.Usuario;
import com.weg.biblioteca.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UsuarioService {

    private UsuarioRepositorio usuarioRepositorio;

    public UsuarioService(UsuarioRepositorio usuarioRepositorio){
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public Usuario salvarUsuario(Usuario usuario)throws SQLException{
        try {
            return usuarioRepositorio.criarUsuario(usuario);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
