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

    public boolean cadastra(Funcionario fun) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO funcionario(cpf,rg,pis,nct,nome,endereco,telefone,celular,sexo,senha,categoria) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setString(1, fun.getCpf());
            ps.setString(2, fun.getRg());
            ps.setString(3, fun.getPis());
            ps.setString(4, fun.getNct());
            ps.setString(5, fun.getNome());
            ps.setString(6, fun.getEnd());
            ps.setString(7, fun.getTel());
            ps.setString(8, fun.getCel());
            ps.setString(9, fun.getSexo());
            ps.setString(10, fun.getPass());
            ps.setInt(11, fun.getCat());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Funcionário " + fun.getNome() + " cadastrado(a) com sucesso!", "CM - Store 1.0 | Aviso - Gerenciador de Funcionários", JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro, cadastro não realizado! Verifique os dados informados.\n\n" + "Erro SQL:\n" + ex, "CM - Store 1.0 | Erro - Gerenciador de Funcionários", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }

    }

    public boolean edita(Funcionario fun) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE funcionario SET cpf = ?,rg = ?,pis = ?,nct = ?,nome = ?,endereco = ?,telefone = ?,celular = ?,sexo = ?,senha = ?,categoria = ? where codigo = ? or cpf = ?";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setString(1, fun.getCpf());
            ps.setString(2, fun.getRg());
            ps.setString(3, fun.getPis());
            ps.setString(4, fun.getNct());
            ps.setString(5, fun.getNome());
            ps.setString(6, fun.getEnd());
            ps.setString(7, fun.getTel());
            ps.setString(8, fun.getCel());
            ps.setString(9, fun.getSexo());
            ps.setString(10, fun.getPass());
            ps.setInt(11, fun.getCat());
            ps.setString(13, fun.getCpf());
            ps.setInt(12, fun.getCod());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastro do(a) Funcionário(a) " + fun.getNome() + " editado com sucesso!", "CM - Store 1.0 | Aviso - Gerenciador de Funcionários", JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro, edição do cadastro não realizada! Verifique os dados informados.\n\n" + "Erro SQL:\n" + ex, "CM - Store 1.0 | Erro - Gerenciador de Funcionários", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }
    }

    public boolean exclui(Funcionario fun) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM funcionario where cod=? or cpf=? or rg=?";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setInt(1, fun.getCod());
            ps.setString(2, fun.getCpf());
            ps.setString(3, fun.getRg());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Exclusão do cadastro do(a) funcionário(a) " + fun.getNome() + " realizada com sucesso!", "CM - Store 1.0 | Aviso - Gerenciador de Funcionários", JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro, exclusão do cadastro não realizada! Verifique os dados informados.\n\n" + "Erro SQL:\n" + ex, "CM - Store 1.0 | Erro - Gerenciador de Funcionários", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }
    }
}
