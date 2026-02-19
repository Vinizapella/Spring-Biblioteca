package com.weg.biblioteca.service;

import com.weg.biblioteca.model.Emprestimo;
import com.weg.biblioteca.repositorio.EmprestimoRepositorio;
import com.weg.biblioteca.repositorio.LivroRepositorio;
import com.weg.biblioteca.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@Service
public class EmprestimoService {

    private EmprestimoRepositorio emprestimoRepositorio;

    private LivroRepositorio livroRepositorio;

    private UsuarioRepositorio usuarioRepositorio;


    public EmprestimoService(EmprestimoRepositorio emprestimoRepositorio, LivroRepositorio livroRepositorio, UsuarioRepositorio usuarioRepositorio){
        this.emprestimoRepositorio = emprestimoRepositorio;
        this.livroRepositorio = livroRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public Emprestimo salvaEmprestimo(Emprestimo emprestimo)throws SQLException{
        try{
            livroRepositorio.procuraPorId(emprestimo.getLivro_id());
        }catch (SQLException e ){
            throw new RuntimeException(e.getMessage());
        }
        try {
            usuarioRepositorio.procuraUsuarioPorId(emprestimo.getUsuario_id());
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

        if (emprestimoRepositorio.emprestimoUsuario(emprestimo.getLivro_id())){
            throw new RuntimeException("Livro foi emprestado");
        }

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

    public void devolucao(long id, Date data_devolucao)throws SQLException {
        if (emprestimoRepositorio.buscaEmprestimo(id)==null){
            throw new RuntimeException("Emprestimo nao existe");
        }
        emprestimoRepositorio.salvaDevolucao(id, data_devolucao);
    }


}
