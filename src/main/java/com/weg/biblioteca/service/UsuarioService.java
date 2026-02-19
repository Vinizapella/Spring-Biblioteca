package com.weg.biblioteca.service;

import com.weg.biblioteca.model.Usuario;
import com.weg.biblioteca.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

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

    public List<Usuario>usuarios()throws SQLException{
        try {
            return usuarioRepositorio.usuarios();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Usuario listaUsuarioPorId(long id)throws SQLException{
        try {
            return usuarioRepositorio.procuraUsuarioPorId(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Usuario atualizaUsuario(Usuario usuario, long id)throws SQLException{
        usuario.setId(id);
        usuarioRepositorio.atualizaUsuario(usuario);
        return usuario;
    }

    public void deletarusuario(long id)throws SQLException{
        try {
            usuarioRepositorio.deletarUsuariop(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
