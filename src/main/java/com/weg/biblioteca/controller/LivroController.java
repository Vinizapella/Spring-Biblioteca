package com.weg.biblioteca.controller;

import com.weg.biblioteca.dto.livro.LivroRequestDto;
import com.weg.biblioteca.dto.livro.LivroResponseDto;
import com.weg.biblioteca.model.Livro;
import com.weg.biblioteca.service.LivroService;
import jakarta.validation.Valid;
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
    public LivroResponseDto salvaLivro(
            @Valid @RequestBody LivroRequestDto livroRequestDto){
        try {
            return livroService.salvarLivro(livroRequestDto);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<LivroResponseDto> listaLivro(){
        try {
            return livroService.retornarLivro();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public LivroResponseDto procuraLivroPorId(
            @PathVariable long id
    ){
        try {
            return livroService.retornarPorId(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public LivroResponseDto atualizaLivro(
            @PathVariable long id,
            @Valid @RequestBody LivroRequestDto livroRequestDto
    ){
        try {
            return livroService.atualizarLivro(livroRequestDto, id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deletarlivro(
            @PathVariable long id
    ){
        try {
            livroService.deletarLivro(id);
        }catch (SQLException e ){
            throw new RuntimeException(e.getMessage());
        }
    }

}
