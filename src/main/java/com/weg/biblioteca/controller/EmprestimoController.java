package com.weg.biblioteca.controller;


import com.weg.biblioteca.dto.emprestimo.EmprestimoRequestDto;
import com.weg.biblioteca.dto.emprestimo.EmprestimoResponseDto;
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
    public EmprestimoResponseDto adicionaEmprestimo(
            @RequestBody EmprestimoRequestDto emprestimoRequestDto){
        try {
            return emprestimoService.salvaEmprestimo(emprestimoRequestDto);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<EmprestimoResponseDto> listaEmprestimos(){
        try {
            return emprestimoService.emprestimos();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public EmprestimoResponseDto buscaEmprestimo(
            @PathVariable long id
    ){
        try {
            return emprestimoService.buscaId(id);
        }catch (SQLException e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public EmprestimoResponseDto atualiza(
            @PathVariable long id,
            @RequestBody EmprestimoRequestDto emprestimoRequestDto
    ){
        try {
            return emprestimoService.atualizaEmprestimo(emprestimoRequestDto, id);
        }catch (SQLException e ){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable long id
    ){
        try {
            emprestimoService.delete(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}/devolucao")
    public void devolucao(
            @PathVariable long id,
            @RequestBody Emprestimo emprestimo
    ){
        try {
            emprestimoService.devolucao(id, emprestimo.getData_devolucao());
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
