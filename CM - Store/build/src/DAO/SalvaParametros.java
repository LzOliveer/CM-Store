/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import UI.frmConfig;
import java.io.*;

/**
 *
 * @author luizo
 */
public class SalvaParametros {

    public void Grava() throws IOException {
        frmConfig c = new frmConfig();

        FileWriter arq = new FileWriter("ConectaBD.txt");
        PrintWriter print = new PrintWriter(arq);

        print.println(frmConfig.SGDB);
        print.println(frmConfig.DRIVER);
        print.println(frmConfig.IP);
        print.println(frmConfig.DB);
        print.println(frmConfig.USER);
        print.println(frmConfig.PASS);
        
        arq.close();
        
        System.out.println("SGDB: "+frmConfig.SGDB);
    }

}
