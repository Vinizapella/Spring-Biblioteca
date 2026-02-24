package com.weg.biblioteca.controller;


import com.weg.biblioteca.dto.usuario.UsuarioRequestDto;
import com.weg.biblioteca.dto.usuario.UsuarioResponseDto;
import com.weg.biblioteca.model.Usuario;
import com.weg.biblioteca.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PutMapping
    public UsuarioResponseDto criaUsuario(
            @RequestBody UsuarioRequestDto usuarioRequestDto
    ){
        try {
            return usuarioService.salvarUsuario(usuarioRequestDto);
        }catch (SQLException e ){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<UsuarioResponseDto> mostraUsuarios(){
        try {
            return usuarioService.usuarios();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public UsuarioResponseDto mostraUsuarioPorId(
            @PathVariable long id
    ){
        try {
            return usuarioService.listaUsuarioPorId(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public UsuarioResponseDto atualizarUsuario(
            @PathVariable long id,
            @RequestBody UsuarioRequestDto usuarioRequestDto
    ){
        try {
            return usuarioService.atualizaUsuario(usuarioRequestDto, id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(
            @PathVariable long id
    ){
        try {
            usuarioService.deletarusuario(id);
        }catch (SQLException e ){
            throw new RuntimeException(e.getMessage());
        }
    }
}
