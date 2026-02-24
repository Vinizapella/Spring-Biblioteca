package com.weg.biblioteca.service;

import com.weg.biblioteca.dto.usuario.UsuarioRequestDto;
import com.weg.biblioteca.dto.usuario.UsuarioResponseDto;
import com.weg.biblioteca.mapper.UsuarioMapper;
import com.weg.biblioteca.model.Usuario;
import com.weg.biblioteca.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
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

    public List<UsuarioResponseDto>usuarios()throws SQLException{
        try {
            List<Usuario> usuariosDoBanco = usuarioRepositorio.usuarios();
            List<UsuarioResponseDto> listaDto = new ArrayList<>();
            for(Usuario u : usuariosDoBanco){
                UsuarioResponseDto dto = usuarioMapper.toResponse(u);
                listaDto.add(dto);
            }
            return listaDto;
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public UsuarioResponseDto listaUsuarioPorId(long id)throws SQLException{
        try {
            Usuario usuarioEntity = usuarioRepositorio.procuraUsuarioPorId(id);
            UsuarioResponseDto dto = usuarioMapper.toResponse(usuarioEntity);
            return dto;
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public UsuarioResponseDto atualizaUsuario(UsuarioRequestDto usuarioRequestDto, long id)throws SQLException{
        Usuario usuario = usuarioMapper.toEntity(usuarioRequestDto);
        usuario.setId(id);
        usuarioRepositorio.atualizaUsuario(usuario);
        return usuarioMapper.toResponse(usuario);
    }

    public void deletarusuario(long id)throws SQLException{
        try {
            usuarioRepositorio.deletarUsuariop(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
