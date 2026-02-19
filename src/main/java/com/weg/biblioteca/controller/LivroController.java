package com.weg.biblioteca.controller;

import com.weg.biblioteca.model.Livro;
import com.weg.biblioteca.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private LivroService livroService;

    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }

    @PostMapping
    public Livro salvaLivro(
             @RequestBody Livro livro){
        try {
            return livroService.salvarLivro(livro);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<Livro> listaLivro(){
        try {
            return livroService.retornarLivro();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Livro procuraLivroPorId(
            @PathVariable long id
    ){
        try {
            return livroService.retornarPorId(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
