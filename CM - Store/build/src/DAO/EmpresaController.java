/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.awt.Toolkit;
import DTO.Empresa;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author luizo
 */
public class EmpresaController {
     Icon erro = new ImageIcon((Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/alert-octagon.png"))));
    Icon ok = new ImageIcon((Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/certo.png"))));
    public boolean cadastra(Empresa emp) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO loja(cnpj,ie,razao_social,nome,endereco,telefone,site) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setString(1, emp.getCNPJ());
            ps.setString(2, emp.getIE());
            ps.setString(3, emp.getRAZAO());
            ps.setString(4, emp.getNOME());
            ps.setString(5, emp.getEND());
            ps.setString(6, emp.getFONE());
            ps.setString(7, emp.getSITE());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Empresa "+emp.getNOME()+" cadastrada com sucesso!", "CM Store v1 | Aviso - Cadastro de Empresa", JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,  "Erro, cadastro não realizado! Verifique os dados informados.\n\n" + "Erro SQL:\n" + ex, "CM Store v1 | Erro - Cadastro de Empresa", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }

    }
    
    public boolean edita(Empresa emp) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE loja SET cnpj = ?,ie = ?,razao_social = ?,nome = ?,endereco = ?,telefone = ?,site = ? where codigo = ? or cnpj = ?";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setString(1, emp.getCNPJ());
            ps.setString(2, emp.getIE());
            ps.setString(3, emp.getRAZAO());
            ps.setString(4, emp.getNOME());
            ps.setString(5, emp.getEND());
            ps.setString(6, emp.getFONE());
            ps.setString(7, emp.getSITE());
            ps.setInt(8, emp.getCOD());
            ps.setString(9, emp.getCNPJ());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastro da empresa " + emp.getNOME() + " editado com sucesso!","CM Store v1 | Aviso - Cadastro de Empresa",JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,  "Erro, edição do cadastro não realizada! Verifique os dados informados.\n\n" + "Erro SQL:\n" + ex, "CM Store v1 | Erro - Cadastro de Empresa", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }
    }
    
    public boolean exclui(Empresa emp) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM loja where cnpj=? or ie=? or codigo=?";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setString(1, emp.getCNPJ());
            ps.setString(2, emp.getIE());
            ps.setInt(3, emp.getCOD());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Exclusão do cadastro da empresa " + emp.getNOME() + " realizada com sucesso!","CM Store v1 | Aviso - Cadastro de Empresa",JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,  "Erro, exclusão do cadastro não realizada! Verifique os dados informados.\n\n" + "Erro SQL:\n" + ex, "CM Store v1 | Erro - Cadastro de Empresa", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }
    }
}
