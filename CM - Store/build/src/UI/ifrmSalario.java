/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.Conexao;
import DAO.SalarioController;
import DTO.Salario;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author luizo
 */
public class ifrmSalario extends javax.swing.JInternalFrame {

    Icon aviso = new ImageIcon((Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icones/Alerta.png"))));
    Icon erro = new ImageIcon((Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icones/Erro.png"))));

    /**
     * Creates new form ifrmSalario
     */
    public ifrmSalario() {
        initComponents();
        list_fun();
        list_sal();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    public void list_fun() {
        String sql = "Select codigo,nome from funcionario";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
            tab_fun.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error, "CM - Store 1.0 | Erro - Gerenciador de Salários", JOptionPane.ERROR_MESSAGE, erro);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ifrmSalario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void list_sal() {
        String sql = "Select * from salario";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
            tab_sal.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error, "CM - Store 1.0 | Erro - Gerenciador de Salários", JOptionPane.ERROR_MESSAGE, erro);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ifrmSalario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void psq_fun() {
        String sql = "Select codigo,nome from funcionario where nome like ?";
        PreparedStatement ps;
        ResultSet rs;
        String sql2 = "Select s.codigo, s.datainicial, s.valor, s.datafinal, s.cod_funcionario from salario s JOIN funcionario f on s.cod_funcionario = f.codigo WHERE f.nome like ?";
        PreparedStatement ps2;
        ResultSet rs2;
        int codfunc;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, psq_fun.getText() + "%");
            rs = ps.executeQuery();
            tab_fun.setModel(DbUtils.resultSetToTableModel(rs));
            try {
                ps2 = Conexao.getConexao().prepareStatement(sql2);
                ps2.setString(1, psq_fun.getText() + "%");
                rs2 = ps2.executeQuery();
                tab_sal.setModel(DbUtils.resultSetToTableModel(rs2));
            } catch (SQLException error) {
                JOptionPane.showMessageDialog(null, error, "CM - Store 1.0 | Erro - Gerenciador de Salários", JOptionPane.ERROR_MESSAGE, erro);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ifrmSalario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error, "CM - Store 1.0 | Erro - Gerenciador de Salários", JOptionPane.ERROR_MESSAGE, erro);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ifrmSalario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void completa_frm() {
        int select2 = tab_sal.getSelectedRow();
        cod.setText(tab_sal.getModel().getValueAt(select2, 4).toString());
        cod_fun.setText(tab_sal.getModel().getValueAt(select2, 3).toString());
        dt_inicial.setText(tab_sal.getModel().getValueAt(select2, 0).toString());
        dt_final.setText(tab_sal.getModel().getValueAt(select2, 2).toString());
        vlr.setText(tab_sal.getModel().getValueAt(select2, 1).toString());
    }

    public void completa_frm2() {
        int select1 = tab_fun.getSelectedRow();
        cod_fun.setText(tab_fun.getModel().getValueAt(select1, 0).toString());
        psq_fun.setText(tab_fun.getModel().getValueAt(select1, 1).toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        psq_fun = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_fun = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab_sal = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cod = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cod_fun = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dt_inicial = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        dt_final = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        vlr = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Gerenciado de Salários | CM - Store 1.0");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/026-cash.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/039-user-6.png"))); // NOI18N
        jLabel1.setText("Nome");

        psq_fun.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        psq_fun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                psq_funKeyReleased(evt);
            }
        });

        tab_fun.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tab_fun.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tab_fun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_funMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab_fun);

        tab_sal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tab_sal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_salMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tab_sal);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Código");

        cod.setEditable(false);
        cod.setBackground(new java.awt.Color(204, 204, 204));
        cod.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cod.setForeground(new java.awt.Color(255, 255, 255));
        cod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cod.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Cód. Funcionário");

        cod_fun.setEditable(false);
        cod_fun.setBackground(new java.awt.Color(204, 204, 204));
        cod_fun.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cod_fun.setForeground(new java.awt.Color(255, 255, 255));
        cod_fun.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cod_fun.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Data Inicial");

        try {
            dt_inicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dt_inicial.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        dt_inicial.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Data Final");

        try {
            dt_final.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dt_final.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        dt_final.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Valor");

        vlr.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("PARA CADASTRAR UMA NOVA ALTERAÇÃO NO SALARIO, SELECIONE UM FUNCIONARIO.");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("PARA EDITAR UMA ALTERAÇÃO SALARIAL SELECIONE A MESMA.");

        jButton1.setBackground(new java.awt.Color(14, 147, 255));
        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/025-add.png"))); // NOI18N
        jButton1.setText("Cadastrar");
        jButton1.setToolTipText("Cadastra uma lteração salarial");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(14, 147, 255));
        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/024-edit.png"))); // NOI18N
        jButton2.setText("Editar");
        jButton2.setToolTipText("Edita uma alteração salarial");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(14, 147, 255));
        jButton3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/023-delete.png"))); // NOI18N
        jButton3.setText("Excluir");
        jButton3.setToolTipText("Exclui uma alteração salarial");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(14, 147, 255));
        jButton4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Limpar.png"))); // NOI18N
        jButton4.setText("Limpar");
        jButton4.setToolTipText("Limpa o formulário");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(14, 147, 255));
        jButton5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/exit.png"))); // NOI18N
        jButton5.setText("Sair");
        jButton5.setToolTipText("Fecha o formulário");
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(psq_fun))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 3, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cod)
                                    .addComponent(dt_inicial)
                                    .addComponent(vlr, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cod_fun)
                                    .addComponent(dt_final, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel8)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4, jButton5});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(psq_fun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cod_fun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dt_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(dt_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(vlr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4, jButton5});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab_funMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_funMouseClicked
        completa_frm2();
    }//GEN-LAST:event_tab_funMouseClicked

    private void tab_salMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_salMouseClicked
        completa_frm();
    }//GEN-LAST:event_tab_salMouseClicked

    private void psq_funKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psq_funKeyReleased
        psq_fun();
    }//GEN-LAST:event_psq_funKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        cod.setText("");
        cod_fun.setText("");
        dt_inicial.setText("");
        dt_final.setText("");
        vlr.setText("");
        psq_fun.setText("");
        list_fun();
        list_sal();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Salario sal = new Salario();
        sal.setCod_fun(Integer.parseInt(cod_fun.getText()));
        sal.setDt_inicial(dt_inicial.getText());
        sal.setDt_final(dt_final.getText());
        sal.setVlr(vlr.getText());
        sal.setNome(psq_fun.getText());

        if ((cod_fun.getText().isEmpty()) || (psq_fun.getText().isEmpty()) || (dt_inicial.getText().isEmpty()) || (dt_final.getText().isEmpty()) || (vlr.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Os campos não podem estar incompletos. Favor preencher todos os campos solicitados e selecionar um funcionário", "CM - Store 1.0 | Aviso - Gerencidor de Salários", JOptionPane.INFORMATION_MESSAGE, aviso);
        } else {

            try {

                SalarioController sc = new SalarioController();
                sc.cadastra(sal);
                cod.setText("");
                cod_fun.setText("");
                dt_inicial.setText("");
                dt_final.setText("");
                vlr.setText("");
                psq_fun.setText("");
                list_fun();
                list_sal();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ifrmFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Salario sal = new Salario();
        sal.setCod_fun(Integer.parseInt(cod_fun.getText()));
        sal.setCod(Integer.parseInt(cod.getText()));
        sal.setNome(psq_fun.getText());
        
        if ((cod.getText().isEmpty()) || (cod_fun.getText().isEmpty()) || (psq_fun.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Os campos não podem estar incompletos. Favor preencher todos os campos solicitados e selecionar uma alteração salarial e um funcionário", "CM - Store 1.0 | Aviso - Gerencidor de Salários", JOptionPane.INFORMATION_MESSAGE, aviso);
        } else {

            try {

                SalarioController sc = new SalarioController();
                sc.exclui(sal);
                cod.setText("");
                cod_fun.setText("");
                dt_inicial.setText("");
                dt_final.setText("");
                vlr.setText("");
                psq_fun.setText("");
                list_fun();
                list_sal();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ifrmFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Salario sal = new Salario();
        sal.setCod_fun(Integer.parseInt(cod_fun.getText()));
        sal.setDt_inicial(dt_inicial.getText());
        sal.setDt_final(dt_final.getText());
        sal.setVlr(vlr.getText());
        sal.setNome(psq_fun.getText());
        sal.setCod(Integer.parseInt(cod.getText()));

        if ((cod.getText().isEmpty()) || (cod_fun.getText().isEmpty()) || (psq_fun.getText().isEmpty()) || (dt_inicial.getText().isEmpty()) || (dt_final.getText().isEmpty()) || (vlr.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Os campos não podem estar incompletos. Favor preencher todos os campos solicitados e selecionar uma alteração salarial e um funcionário", "CM - Store 1.0 | Aviso - Gerencidor de Salários", JOptionPane.INFORMATION_MESSAGE, aviso);
        } else {

            try {

                SalarioController sc = new SalarioController();
                sc.edita(sal);
                cod.setText("");
                cod_fun.setText("");
                dt_inicial.setText("");
                dt_final.setText("");
                vlr.setText("");
                psq_fun.setText("");
                list_fun();
                list_sal();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ifrmFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cod;
    private javax.swing.JTextField cod_fun;
    private javax.swing.JFormattedTextField dt_final;
    private javax.swing.JFormattedTextField dt_inicial;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField psq_fun;
    private javax.swing.JTable tab_fun;
    private javax.swing.JTable tab_sal;
    private javax.swing.JTextField vlr;
    // End of variables declaration//GEN-END:variables
}
