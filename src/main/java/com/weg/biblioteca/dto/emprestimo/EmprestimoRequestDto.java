package com.weg.biblioteca.dto.emprestimo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.util.Date;

public record EmprestimoRequestDto (
        @NotNull(message = "O id do livro nao pode ser nulo")
        long livro_id,
        @NotNull(message = "O id do usuario nao pode ser nulo")
        long usuario_id,
        @NotNull(message = "Data de empréstimo é obrigatória")
        @PastOrPresent(message = "A data de empréstimo não pode ser futura")
        @JsonFormat(pattern = "yyyy-MM-dd")
        Date data_emprestimo,
        @NotNull(message = "Data de devolução é obrigatória")
        @FutureOrPresent(message = "A data de devolução não pode ser anterior a hoje")
        @JsonFormat(pattern = "yyyy-MM-dd")
        Date data_devolucao
){
}
