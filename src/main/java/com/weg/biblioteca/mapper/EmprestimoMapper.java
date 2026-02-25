package com.weg.biblioteca.mapper;

import com.weg.biblioteca.dto.emprestimo.EmprestimoRequestDto;
import com.weg.biblioteca.dto.emprestimo.EmprestimoResponseDto;
import com.weg.biblioteca.dto.usuario.UsuarioResponseDto;
import com.weg.biblioteca.model.Emprestimo;
import org.springframework.stereotype.Component;

@Component
public class EmprestimoMapper {

    public Emprestimo toEntity(
            EmprestimoRequestDto emprestimoRequestDto
    ){
        return new Emprestimo(
                emprestimoRequestDto.id(),
                emprestimoRequestDto.livro_id(),
                emprestimoRequestDto.usuario_id(),
                emprestimoRequestDto.data_emprestimo(),
                emprestimoRequestDto.data_devolucao()
        );
    }

    public EmprestimoResponseDto toResponse(Emprestimo emprestimo){
        return new EmprestimoResponseDto(
                emprestimo.getId(),
                emprestimo.getLivro_id(),
                emprestimo.getUsuario_id(),
                emprestimo.getData_emprestimo(),
                emprestimo.getData_devolucao()
        );
    }
}
