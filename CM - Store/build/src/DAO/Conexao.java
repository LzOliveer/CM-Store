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
 * @author Luiz Cassol
 */

public class Conexao {
    
    
    private static Connection conn;
    public static String sgdb; /* postgresql ou mysql */
    public static String driver; /* org.postgresql.Driver ou com.jdb.mysql.Driver*/
    public static String ip;
    public static String dataBase;
    public static String user;
    public static String password;
    
    public Conexao(Connection conn) {
        this.conn = conn;
    }

    public static Connection getConexao() throws SQLException, ClassNotFoundException {
        if (conn != null) {
            return conn;
        }

        Class.forName(driver);
        try {
            LeParametros.Ler();
            conn = java.sql.DriverManager.getConnection("jdbc:"+sgdb+"://" + ip +"/"+ dataBase, user, password);
        } catch (IOException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;

    }

    public static void fechaConexao() {
        try {
            conn.close();
            conn = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

   
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {
            getConexao();
            System.out.println("Conectado!");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch(ClassNotFoundException ex){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
