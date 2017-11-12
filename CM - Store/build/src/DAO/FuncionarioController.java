/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Funcionario;
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
public class FuncionarioController {

    Icon erro = new ImageIcon((Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/Erro.png"))));
    Icon ok = new ImageIcon((Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/certo_1.png"))));

    public boolean cadastra(Funcionario func) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO funcionario(cpf,rg,pis,n_ct,nome,endereco,telefone,celular,sexo,senha,categoria) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setString(1, func.getCpf());
            ps.setString(2, func.getRg());
            ps.setString(3, func.getPis());
            ps.setString(4, func.getNct());
            ps.setString(5, func.getNome());
            ps.setString(6, func.getEnd());
            ps.setString(7, func.getTel());
            ps.setString(8, func.getCel());
            ps.setString(9, func.getSexo());
            ps.setString(10, func.getPass());
            ps.setString(11, func.getCat());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Funcionário " + func.getNome() + " cadastrado(a) com sucesso!", "Creative Mind Corporation - CM Store v1 | Aviso - Cadastro de Funcionários", JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro, cadastro não realizado! Verifique os dados informados.\n\n" + "Erro SQL:\n" + ex, "Creative Mind Corporation - CM Store v1 | Erro - Cadastro de Funcionários", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }

    }

    public boolean edita(Funcionario func) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE funcionario SET cpf = ?,rg = ?,pis = ?,n_ct = ?,nome = ?,endereco = ?,telefone = ?,celular = ?,sexo = ?,senha = ?,categoria = ? where codigo = ? or cpf = ?";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setString(1, func.getCpf());
            ps.setString(2, func.getRg());
            ps.setString(3, func.getPis());
            ps.setString(4, func.getNct());
            ps.setString(5, func.getNome());
            ps.setString(6, func.getEnd());
            ps.setString(7, func.getTel());
            ps.setString(8, func.getCel());
            ps.setString(9, func.getSexo());
            ps.setString(10, func.getPass());
            ps.setString(11, func.getCat());
            ps.setString(13, func.getCpf());
            ps.setString(12, func.getCod());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastro do(a) Funcionário(a) " + func.getNome() + " editado com sucesso!", "Creative Mind Corporation - CM Store v1 | Aviso - Cadastro de Funcionários", JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro, edição do cadastro não realizada! Verifique os dados informados.\n\n" + "Erro SQL:\n" + ex, "Creative Mind Corporation - CM Store v1 | Erro - Cadastro de Funcionários", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }
    }

    public boolean exclui(Funcionario func) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM funcionario where cod=? or cpf=? or rg=?";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setString(1, func.getCod());
            ps.setString(2, func.getCpf());
            ps.setString(3, func.getRg());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Exclusão do cadastro do(a) funcionário(a) " + func.getNome() + " realizada com sucesso!", "Creative Mind Corporation - CM Store v1 | Aviso - Cadastro de Funcionários", JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro, exclusão do cadastro não realizada! Verifique os dados informados.\n\n" + "Erro SQL:\n" + ex, "Creative Mind Corporation - CM Store v1 | Erro - Cadastro de Funcionários", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }
    }
}
