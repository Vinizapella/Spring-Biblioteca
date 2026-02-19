package com.weg.biblioteca.controller;


import com.weg.biblioteca.model.Usuario;
import com.weg.biblioteca.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/{usuario}")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PutMapping
    public Usuario criaUsuario(
            @RequestBody Usuario usuario){
        try {
            return usuarioService.salvarUsuario(usuario);
        }catch (SQLException e ){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<Usuario> mostraUsuarios(){
        try {
            return usuarioService.usuarios();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Usuario mostraUsuarioPorId(
            @PathVariable long id
    ){
        try {
            return usuarioService.listaUsuarioPorId(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(
            @PathVariable long id,
            @RequestBody Usuario usuario
    ){
        try {
            return usuarioService.atualizaUsuario(usuario, id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
