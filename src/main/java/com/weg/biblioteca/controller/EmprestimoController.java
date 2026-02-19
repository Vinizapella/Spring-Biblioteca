package com.weg.biblioteca.controller;


import com.weg.biblioteca.model.Emprestimo;
import com.weg.biblioteca.service.EmprestimoService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RequestMapping("/emprestimo")
@RestController
public class EmprestimoController {

    private EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService){
        this.emprestimoService = emprestimoService;
    }

    @PutMapping
    public Emprestimo adicionaEmprestimo(
            @RequestBody  Emprestimo emprestimo){
        try {
            return emprestimoService.salvaEmprestimo(emprestimo);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
