package com.weg.biblioteca.controller;


import com.weg.biblioteca.model.Usuario;
import com.weg.biblioteca.service.UsuarioService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

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

}
