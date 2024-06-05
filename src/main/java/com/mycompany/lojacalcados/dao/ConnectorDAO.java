package com.mycompany.lojacalcados.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectorDAO {
    static String URL = "jdbc:mysql://localhost:3306/lojacalcados";
    static String login = "root";
    static String senha = "p0w2i8spy";
    static Connection conexao = null;
    
    public static Connection AbrirConexao()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL,login, senha);
            return conexao;
        }catch(ClassNotFoundException e){
            System.out.println("Driver não encontrado");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static void FecharConexao()
    {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }     
        }
    }
    
}
