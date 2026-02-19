package com.weg.biblioteca.service;

import com.weg.biblioteca.model.Emprestimo;
import com.weg.biblioteca.repositorio.EmprestimoRepositorio;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmprestimoService {

    private EmprestimoRepositorio emprestimoRepositorio;

    public EmprestimoService(EmprestimoRepositorio emprestimoRepositorio){
        this.emprestimoRepositorio = emprestimoRepositorio;
    }

    public Emprestimo salvaEmprestimo(Emprestimo emprestimo)throws SQLException{
        return emprestimoRepositorio.salvarEmprestimo(emprestimo);
    }

    public List<Emprestimo>emprestimos()throws SQLException{
        return emprestimoRepositorio.emprestimos();
    }

    public Emprestimo buscaId(long id)throws SQLException{
        return emprestimoRepositorio.buscaEmprestimo(id);
    }

    public Emprestimo atualizaEmprestimo(Emprestimo emprestimo, long id)throws SQLException{
        emprestimo.setId(1);
        emprestimoRepositorio.atualizaEmprestimo(emprestimo);
        return emprestimo;
    }

    public void delete(long id)throws SQLException{
        emprestimoRepositorio.delete(id);
    }

}
