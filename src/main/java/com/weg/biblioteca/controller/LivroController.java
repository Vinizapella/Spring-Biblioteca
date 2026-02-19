package com.weg.biblioteca.controller;

import com.weg.biblioteca.model.Livro;
import com.weg.biblioteca.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private LivroService livroService;

    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }

    @PostMapping
    public Livro salvaLivro(
             @RequestBody Livro livro)throws SQLException{
        try {
            return livroService.salvarLivro(livro);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
