package com.weg.biblioteca.repositorio;

import com.weg.biblioteca.model.Livro;
import com.weg.biblioteca.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;

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

}
