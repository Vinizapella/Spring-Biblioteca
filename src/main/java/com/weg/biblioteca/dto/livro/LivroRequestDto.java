package com.weg.biblioteca.dto.livro;

import jakarta.validation.constraints.*;

public record LivroRequestDto (
        @NotBlank(message = "Titulo é obrigatorio")
        String titulo,
        @NotBlank(message = "Nome do autor é obrigatorio")
        @Size(min = 1, max = 100, message = "O nome deve se ter no minimo 1 caracter e no maximo 100 caracteres")
        String autor,
        @NotNull(message = "O ano da publicação é obrigatoria")
        @Min(value = 1500, message = "O ano deve ser válido")
        @Max(value = 2025, message = "O ano de publicação não pode ser do futuro")
        int ano_publicacao
){
}
