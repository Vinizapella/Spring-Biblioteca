package com.weg.biblioteca.dto.emprestimo;

import java.util.Date;

public record EmprestimoResponseDto (
        long id,
        long livro_id,
        long usuario_id,
        Date data_emprestimo,
        Date data_devolucao
){
}
