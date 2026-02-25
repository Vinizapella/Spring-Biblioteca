package com.weg.biblioteca.mapper;

import com.weg.biblioteca.dto.livro.LivroRequestDto;
import com.weg.biblioteca.dto.livro.LivroResponseDto;
import com.weg.biblioteca.model.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {

    public Livro toEntit(
            LivroRequestDto livroRequestDTO
    ){
        return new Livro(
                livroRequestDTO.titulo(),
                livroRequestDTO.autor(),
                livroRequestDTO.ano_publicacao()
        );
    }

    public LivroResponseDto toResponse(
            Livro livro
    ){
        return new LivroResponseDto(
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getAno_publicacao()
        );
    }
}
