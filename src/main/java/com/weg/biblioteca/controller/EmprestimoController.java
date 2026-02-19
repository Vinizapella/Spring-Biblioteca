package com.weg.biblioteca.controller;


import com.weg.biblioteca.model.Emprestimo;
import com.weg.biblioteca.service.EmprestimoService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

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

    @GetMapping
    public List<Emprestimo> listaEmprestimos(){
        try {
            return emprestimoService.emprestimos();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Emprestimo buscaEmprestimo(
            @PathVariable long id
    ){
        try {
            return emprestimoService.buscaId(id);
        }catch (SQLException e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Emprestimo atualiza(
            @PathVariable long id,
            @RequestBody Emprestimo emprestimo
    ){
        try {
            return emprestimoService.atualizaEmprestimo(emprestimo, id);
        }catch (SQLException e ){
            throw new RuntimeException(e.getMessage());
        }
    }

}
