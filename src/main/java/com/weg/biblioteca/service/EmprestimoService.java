package com.weg.biblioteca.service;

import com.weg.biblioteca.model.Emprestimo;
import com.weg.biblioteca.repositorio.EmprestimoRepositorio;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class EmprestimoService {

    private EmprestimoRepositorio emprestimoRepositorio;

    public EmprestimoService(EmprestimoRepositorio emprestimoRepositorio){
        this.emprestimoRepositorio = emprestimoRepositorio;
    }

    public Emprestimo salvaEmprestimo(Emprestimo emprestimo)throws SQLException{
        return emprestimoRepositorio.salvarEmprestimo(emprestimo);
    }

}
