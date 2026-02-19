package com.weg.biblioteca.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "";
    private static final String USUARIO = "root";
    private static final String SENHA = "mysqlPW";

    public static Connection conectar()throws SQLException{
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

}
