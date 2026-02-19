package com.weg.biblioteca.repositorio;

import com.weg.biblioteca.model.Emprestimo;
import com.weg.biblioteca.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;

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

}
