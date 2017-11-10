package DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edimar - sem leitura de txt;
 * @author Luiz Cassol - add leitura de dados;
 */
public class Conexao {
    
    private static Connection conn;
    public static String sgdb = "postgresql";
    public static String driver = "org.postgresql.Driver";
    public static String ip = "localhost/";
    public static String dataBase = "CM-Store";
    public static String user = "postgres";
    public static String password = "0926";
    
    public Conexao(Connection conn) {
        Conexao.conn = conn;
    }

    public static Connection getConexao() throws SQLException, ClassNotFoundException {

        if (conn != null) {
            return conn;
        }

        Class.forName(driver);
        try {
            LeParametros.Ler();
        } catch (IOException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn = java.sql.DriverManager.getConnection("jdbc:"+sgdb+"://" + ip +"/"+ dataBase, user, password);
        return conn;

    }

    public static void fechaConexao() {
        try {
            conn.close();
            conn = null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            getConexao();
            System.out.println("Conectado!");
            System.exit(0);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}