package com.weg.biblioteca.repositorio;

import com.weg.biblioteca.model.Usuario;
import com.weg.biblioteca.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepositorio {

    public Usuario criarUsuario(Usuario usuario)throws SQLException {
        String sql = """
                INSERT 
                INTO
                usuario(
                nome,
                email)
                VALUES
                (?, ?)
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                usuario.setId(rs.getLong(1));
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario>usuarios()throws SQLException{
        String sql = """
                SELECT
                id,
                nome,
                email
                FROM
                usuario
                """;
        List<Usuario>usuarios = new ArrayList<>();
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                Usuario usuario = new Usuario(id, nome, email);
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    public Usuario procuraUsuarioPorId(long id)throws SQLException{
        String sql = """
                SELECT
                id,
                nome,
                email
                FROM
                usuario
                WHERE
                id = ?
                """;
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                long identidade = rs.getLong("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                Usuario usuario = new Usuario(identidade, nome, email);
                return usuario;
            }
            return null;
        }
    }

    public void atualizaUsuario(Usuario usuario)throws SQLException{
        String sql = """
                UPDATE
                usuario
                SET 
                nome = ?,
                email = ?
                WHERE
                id = ?
                """;
        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setLong(3, usuario.getId());
            stmt.executeUpdate();
        }
    }

    public void deletarUsuariop(long id)throws SQLException{
        String sql = """
                DELETE
                FROM
                usuario
                WHERE
                id = ?
                """;
        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}
