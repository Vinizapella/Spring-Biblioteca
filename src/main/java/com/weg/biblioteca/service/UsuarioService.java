package com.weg.biblioteca.service;

import com.weg.biblioteca.dto.usuario.UsuarioRequestDto;
import com.weg.biblioteca.dto.usuario.UsuarioResponseDto;
import com.weg.biblioteca.mapper.UsuarioMapper;
import com.weg.biblioteca.model.Usuario;
import com.weg.biblioteca.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepositorio usuarioRepositorio;

    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepositorio usuarioRepositorio, UsuarioMapper usuarioMapper){
        this.usuarioRepositorio = usuarioRepositorio;
        this.usuarioMapper = usuarioMapper;
    }

    public UsuarioResponseDto salvarUsuario(UsuarioRequestDto usuarioRequestDto)throws SQLException{
        try {
            Usuario usuario = usuarioMapper.toEntity(usuarioRequestDto);
            Usuario usuarioSalvo = usuarioRepositorio.criarUsuario(usuario);
            UsuarioResponseDto usuarioResponseDto = usuarioMapper.toResponse(usuarioSalvo);
            return usuarioResponseDto;

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
