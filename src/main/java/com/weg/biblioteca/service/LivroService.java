package com.weg.biblioteca.service;

import com.weg.biblioteca.model.Livro;
import com.weg.biblioteca.repositorio.LivroRepositorio;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LivroService {

    private LivroRepositorio livroRepositorio;

    public LivroService(LivroRepositorio livroRepositorio){
        this.livroRepositorio = livroRepositorio;
    }

    public Livro salvarLivro(Livro livro)throws SQLException{
        return livroRepositorio.cadastrarLivro(livro);
    }

    public List<Livro> retornarLivro()throws SQLException{
        return livroRepositorio.livros();
    }

}
