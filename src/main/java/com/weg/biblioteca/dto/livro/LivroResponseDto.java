package com.weg.biblioteca.dto.livro;

public record LivroResponseDto (
        long id,
        String titulo,
        String autor,
        int ano_publicacao
){
}
