package com.weg.biblioteca.mapper;

import com.weg.biblioteca.dto.usuario.UsuarioRequestDto;
import com.weg.biblioteca.dto.usuario.UsuarioResponseDto;
import com.weg.biblioteca.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(
        UsuarioRequestDto requestDto
    ){
        return new Usuario(
                requestDto.nome(),
                requestDto.email()
        );
    }

    public UsuarioResponseDto toResponse(Usuario usuario){
        return new UsuarioResponseDto(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }
}
