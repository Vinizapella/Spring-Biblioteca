package com.weg.biblioteca.repositorio;

import com.weg.biblioteca.model.Livro;
import com.weg.biblioteca.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LivroRepositorio {

    public Livro cadastrarLivro(Livro livro)throws SQLException{
        String sql = """
                INSERT
                INTO
                livro(
                titulo,
                autor,
                ano_publicacao)
                VALUES
                (?, ?, ?)
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                stmt.setString(1, livro.getTitulo());
                stmt.setString(2, livro.getAutor());
                stmt.setInt(3, livro.getAno_publicacao());
                stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                livro.setId(rs.getInt(1));
                return livro;
            }
        }
        return null;
    }

    public List<Livro>livros()throws SQLException{
        String sql = """
                SELECT 
                id,
                titulo,
                autor,
                ano_publicacao
                FROM
                livro
                """;
        List<Livro>livros = new ArrayList<>();
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int ano_publicacao = rs.getInt("ano_publicacao");
                Livro livro = new Livro(id, titulo, autor, ano_publicacao);
                livros.add(livro);
            }
        }
        return livros;
    }

    public Livro procuraPorId(long id)throws SQLException{
        String sql = """
                SELECT
                id,
                titulo,
                autor,
                ano_publicacao
                FROM
                livro
                WHERE
                id = ?
                """;
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                long identidade = rs.getLong("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int ano_publicacao = rs.getInt("ano_publicacao");
                Livro livro = new Livro(identidade, titulo, autor, ano_publicacao);
                return livro;
            }
            return null;
        }
    }

}
