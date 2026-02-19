package com.weg.biblioteca.repositorio;

import com.weg.biblioteca.model.Emprestimo;
import com.weg.biblioteca.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class EmprestimoRepositorio {

    public Emprestimo salvarEmprestimo(Emprestimo emprestimo)throws SQLException{
        String sql = """
                INSERT 
                INTO
                emprestimo(
                livro_id,
                usuario_id,
                data_emprestimo)
                VALUES
                (?, ?, ?)
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setLong(1, emprestimo.getLivro_id());
            stmt.setLong(2, emprestimo.getUsuario_id());
            stmt.setObject(3, emprestimo.getData_emprestimo());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                emprestimo.setId(rs.getInt(1));
                return emprestimo;
            }
        }
        return null;
    }

    public List<Emprestimo>emprestimos()throws SQLException{
        String sql = """
                SELECT
                id, 
                livro_id,
                usuario_id,
                data_emprestimo,
                data_devolucao
                FROM
                emprestimo
                """;
        List<Emprestimo>emprestimos = new ArrayList<>();
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                long idEmprestimo = rs.getLong("id");
                long idLivro = rs.getLong("livro_id");
                long idUsuario = rs.getLong("usuario_id");
                Date data_emprestimo = rs.getDate("data_emprestimo");
                Date devolucao = rs.getDate("data_devolucao");
                Emprestimo emprestimo = new Emprestimo(idEmprestimo, idLivro, idUsuario, data_emprestimo, devolucao);
                emprestimos.add(emprestimo);
            }
        }
        return emprestimos;
    }

    public Emprestimo buscaEmprestimo(long id)throws SQLException{
        String sql = """
                SELECT
                id, 
                livro_id,
                usuario_id,
                data_emprestimo,
                data_devolucao
                FROM
                emprestimo
                WHERE
                id = ?
                """;
        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                long identidade = rs.getLong("id");
                long idLivro = rs.getLong("livro_id");
                long idUsuario = rs.getLong("usuario_id");
                Date data_emprestimo = rs.getDate("data_emprestimo");
                Date devolucao = rs.getDate("data_devolucao");
                Emprestimo emprestimo = new Emprestimo(identidade, idLivro, idUsuario, data_emprestimo, devolucao);
                return emprestimo;
            }
        }
        return null;
    }

}
