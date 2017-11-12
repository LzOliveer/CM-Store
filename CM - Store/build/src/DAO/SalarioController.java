/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Salario;
import java.awt.Toolkit;
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
public class SalarioController {

    Icon erro = new ImageIcon((Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/Erro.png"))));
    Icon ok = new ImageIcon((Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/certo_1.png"))));

    public boolean cadastra(Salario sal) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO salario(cod_funcionario, datainicial, datafinal, valor) VALUES(?,?,?,?)";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setInt(1, sal.getCod_fun());
            ps.setString(2, sal.getDt_inicial());
            ps.setString(3, sal.getDt_final());
            ps.setString(4, sal.getVlr());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Salário do funcionário(a) " + sal.getNome() + " cadastrado(a) com sucesso!", "CM - Store 1.0 | Aviso - Gerenciador de Salários", JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro, cadastro não realizado! Verifique os dados informados.\n\n" + "Erro SQL:\n" + ex, "CM - Store 1.0 | Erro - Gerenciador de Salários", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }

    }

    public boolean edita(Salario sal) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE salario SET datainicial = ?, datafinal = ?, valor = ? where codigo = ? or cod_funcionario = ?";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setString(1, sal.getDt_inicial());
            ps.setString(2, sal.getDt_final());
            ps.setString(3, sal.getVlr());
            ps.setInt(4, sal.getCod());
            ps.setInt(5, sal.getCod_fun());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Salário do(a) funcionário(a) " + sal.getNome() + " editado com sucesso!", "CM - Store 1.0 | Aviso - Gerenciador de Salários", JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro, edição do cadastro não realizada! Verifique os dados informados.\n\n" + "Erro SQL:\n" + ex, "CM - Store 1.0 | Erro - Gerenciador de Salários", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }
    }

    public boolean exclui(Salario sal) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM salario where codigo=? or cod_funcionario = ?";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setInt(1, sal.getCod());
            ps.setInt(2, sal.getCod_fun());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Exclusão do cadastro do salário do(a) funcionário(a) " + sal.getNome() + " realizada com sucesso!", "CM - Store 1.0 | Aviso - Gerenciador de Salários", JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro, exclusão do cadastro não realizada! Verifique os dados informados.\n\n" + "Erro SQL:\n" + ex, "CM - Store 1.0 | Erro - Gerenciador de Salários", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }
    }
}
