/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import UI.frmCfgLocal;

/**
 *
 * @author luizo
 */
public class GravaParametros {    

    public static void Grava() throws IOException{
        frmCfgLocal fcg = new frmCfgLocal();
        
        FileWriter fw = new FileWriter("parametros.txt");
        PrintWriter pw = new PrintWriter(fw);
        
        pw.println(fcg.sgdb.getSelectedItem().toString());
        pw.println(fcg.driver.getSelectedItem().toString());
        pw.println(fcg.ip.getText());
        pw.println(fcg.db.getText());
        pw.println(fcg.usr.getText());
        pw.println(fcg.senha.getText());

        fw.close();
        System.out.println("SGDB: "+fcg.sgdb.getSelectedItem().toString());
    }
    
    public static void main(String[] args) throws IOException {
        Grava();
        System.out.printf("Parâmetros salvos com sucesso%n");
    }

    

}
