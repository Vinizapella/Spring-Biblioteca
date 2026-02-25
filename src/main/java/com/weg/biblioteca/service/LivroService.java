package com.weg.biblioteca.service;

import com.weg.biblioteca.dto.livro.LivroRequestDto;
import com.weg.biblioteca.dto.livro.LivroResponseDto;
import com.weg.biblioteca.mapper.LivroMapper;
import com.weg.biblioteca.model.Livro;
import com.weg.biblioteca.repositorio.LivroRepositorio;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    private LivroRepositorio livroRepositorio;

    private LivroMapper livroMapper;

    public LivroService(LivroRepositorio livroRepositorio, LivroMapper livroMapper){
        this.livroRepositorio = livroRepositorio;
        this.livroMapper = livroMapper;
    }

    public LivroResponseDto salvarLivro(LivroRequestDto livroRequestDto)throws SQLException{
        Livro livro = livroMapper.toEntit(livroRequestDto);
        Livro livroSalvo = livroRepositorio.cadastrarLivro(livro);
        LivroResponseDto livroResponseDto = livroMapper.toResponse(livroSalvo);
        return livroResponseDto;
    }

    public List<LivroResponseDto> retornarLivro()throws SQLException{
        List<Livro> livroDoBanco = livroRepositorio.livros();
        List<LivroResponseDto> listaDto = new ArrayList<>();
        for (Livro l : livroDoBanco){
            LivroResponseDto dto = livroMapper.toResponse(l);
            listaDto.add(dto);
        }
        return listaDto;
    }

    public LivroResponseDto retornarPorId(long id)throws SQLException{
        Livro livroEntity = livroRepositorio.procuraPorId(id);
        LivroResponseDto dto = livroMapper.toResponse(livroEntity);
        return dto;
    }

    public LivroResponseDto atualizarLivro(LivroRequestDto livroRequestDto, long id)throws SQLException{
        Livro livro = livroMapper.toEntit(livroRequestDto);
        livro.setId(id);
        livroRepositorio.atualizaLivro(livro);
        return livroMapper.toResponse(livro);
    }

    public void deletarLivro(long id)throws SQLException{
        try {
            livroRepositorio.deletarLivro(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
