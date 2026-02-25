package com.weg.biblioteca.service;

import com.weg.biblioteca.dto.emprestimo.EmprestimoRequestDto;
import com.weg.biblioteca.dto.emprestimo.EmprestimoResponseDto;
import com.weg.biblioteca.mapper.EmprestimoMapper;
import com.weg.biblioteca.model.Emprestimo;
import com.weg.biblioteca.model.Livro;
import com.weg.biblioteca.model.Usuario;
import com.weg.biblioteca.repositorio.EmprestimoRepositorio;
import com.weg.biblioteca.repositorio.LivroRepositorio;
import com.weg.biblioteca.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmprestimoService {

    private EmprestimoRepositorio emprestimoRepositorio;

    private LivroRepositorio livroRepositorio;

    private UsuarioRepositorio usuarioRepositorio;

    private EmprestimoMapper emprestimoMapper;


    public EmprestimoService(EmprestimoRepositorio emprestimoRepositorio, LivroRepositorio livroRepositorio, UsuarioRepositorio usuarioRepositorio, EmprestimoMapper emprestimoMapper){
        this.emprestimoRepositorio = emprestimoRepositorio;
        this.livroRepositorio = livroRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
        this.emprestimoMapper = emprestimoMapper;
    }

    public EmprestimoResponseDto salvaEmprestimo(EmprestimoRequestDto emprestimoRequestDto) throws SQLException {

        Livro livro = livroRepositorio.procuraPorId(emprestimoRequestDto.livro_id());
        Usuario usuario = usuarioRepositorio.procuraUsuarioPorId(emprestimoRequestDto.usuario_id());

        if (emprestimoRepositorio.emprestimoUsuario(emprestimoRequestDto.livro_id())) {
            throw new RuntimeException("Este livro já está emprestado!");
        }

        Emprestimo emprestimo = emprestimoMapper.toEntity(emprestimoRequestDto);

        Emprestimo emprestimoSalvo = emprestimoRepositorio.salvarEmprestimo(emprestimo);

        return emprestimoMapper.toResponse(emprestimoSalvo);
    }

    public List<EmprestimoResponseDto> emprestimos() throws SQLException {
        List<Emprestimo> listaDoBanco = emprestimoRepositorio.emprestimos();
        List<EmprestimoResponseDto> listaDto = new ArrayList<>();

        for (Emprestimo e : listaDoBanco) {
            listaDto.add(emprestimoMapper.toResponse(e));
        }
        return listaDto;
    }

    public EmprestimoResponseDto buscaId(long id) throws SQLException {
        Emprestimo emprestimo = emprestimoRepositorio.buscaEmprestimo(id);
        return emprestimoMapper.toResponse(emprestimo);
    }

    public EmprestimoResponseDto atualizaEmprestimo(EmprestimoRequestDto emprestimoRequestDto, long id) throws SQLException {
        Emprestimo emprestimo = emprestimoMapper.toEntity(emprestimoRequestDto);
        emprestimo.setId(id);
        emprestimoRepositorio.atualizaEmprestimo(emprestimo);
        return emprestimoMapper.toResponse(emprestimo);
    }

    public void delete(long id) throws SQLException {
        emprestimoRepositorio.delete(id);
    }

    public void devolucao(long id, Date data_devolucao) throws SQLException {
        if (emprestimoRepositorio.buscaEmprestimo(id) == null) {
            throw new RuntimeException("Emprestimo nao existe");
        }
        emprestimoRepositorio.salvaDevolucao(id, data_devolucao);
    }

}
