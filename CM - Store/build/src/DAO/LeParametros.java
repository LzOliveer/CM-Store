/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luizo
 */
public class LeParametros {

    public static void Ler() throws FileNotFoundException, IOException {

        FileReader fr = new FileReader("parametros.txt");
        BufferedReader br = new BufferedReader(fr);
        
        Conexao.sgdb = br.readLine();
        Conexao.driver = br.readLine();
        Conexao.ip = br.readLine();
        Conexao.dataBase = br.readLine();
        Conexao.user = br.readLine();
        Conexao.password = br.readLine();
        
        fr.close();
    }

    public static void main(String[] args) {
        try {
            Ler();
            System.out.println(Conexao.sgdb);
        } catch (IOException ex) {
            Logger.getLogger(LeParametros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
