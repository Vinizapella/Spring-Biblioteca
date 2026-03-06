package com.weg.biblioteca.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequestDto (
        @NotBlank(message = "O nome é obrigatorio")
        @Size(min = 20, max = 50, message = "O nome deve ter no minimo de 3 caracteres e no maximo 50 caracteres")
        String nome,
        @NotBlank(message = "Email é obrigatorio")
        @Email(message = "Email invalido")
        String email
){
}
