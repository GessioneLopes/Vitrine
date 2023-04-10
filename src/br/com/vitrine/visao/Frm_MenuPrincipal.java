package br.com.vitrine.visao;

import br.com.vitrine.DAO.ModuloConexao;
import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Gessione
 */
public class Frm_MenuPrincipal extends javax.swing.JFrame {

    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;
    
    /**
     * Creates new form Frm_MenuPrincipal
     */
    public Frm_MenuPrincipal() {
        initComponents();
        
        getContentPane().setBackground(Color.WHITE); // Mudar cor de fundo do Background tela Frm_Menu
        conexao = ModuloConexao.conectar();
        
    }
    
    /**
     * Método responsável pela emissão do relatório de Usuários com
     * JasperReports
     */
//    private void relatorioUsuarios() {
//        
//        //chamar o método conexao
//        conexao = ModuloConexao.conectar();
//        //gerando um relatório de Usuários
//        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a emissão deste relatório?", "Atenção!", JOptionPane.YES_NO_OPTION);
//        if (confirma == JOptionPane.YES_OPTION) {
//            //imprimindo relatórios com framework JasperReports
//            try {
//                //Usando a class JasperPrint para preparar a impressão de um relatório
//                JasperPrint print = JasperFillManager.fillReport("C:/Users/Gessione/Documents/NetBeansProjects/Vitrine/src/relatorios/rel_usuarios.jasper", null, conexao);
//                // a linha abaixo exibe o relatório através da classe JasperViewer
//                JasperViewer.viewReport(print, false);
//            } catch (JRException e) {
//                JOptionPane.showMessageDialog(null, e);
//            } finally {
//                try {
//                    conexao.close();
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//            }
//        }
//    }
//    
     /**
     * Método responsável pela emissão do relatório de Clientes com
     * JasperReports
     */
//    private void relatorioClientes() {
//
//        //chamar o método conexao
//        conexao = ModuloConexao.conectar();
//        //gerando um relatório de Clientes
//        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a emissão deste relatório?", "Atenção!", JOptionPane.YES_NO_OPTION);
//        if (confirma == JOptionPane.YES_OPTION) {
//            //imprimindo relatórios com framework JasperReports
//            try {
//                //Usando a class JasperPrint para preparar a impressão de um relatório
//                JasperPrint print = JasperFillManager.fillReport("C:/Users/Gessione/Documents/NetBeansProjects/Vitrine/src/relatorios/rel_clientes.jasper", null, conexao);
//                // a linha abaixo exibe o relatório através da classe JasperViewer
//                JasperViewer.viewReport(print, false);
//            } catch (JRException e) {
//                JOptionPane.showMessageDialog(null, e);
//            } finally {
//                try {
//                    conexao.close();
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//            }
//        }
//    }
    
    /**
     * Método responsável pela emissão do relatório de Ordem de serviço Canceladas
     * JasperReports
     */
//    private void relatorioOrdemServicoCancelada() {
//
//        //chamar o método conexao
//        conexao = ModuloConexao.conectar();
//        //gerando um relatório de Ordem de Serviço Cancelada
//        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a emissão deste relatório?", "Atenção!", JOptionPane.YES_NO_OPTION);
//        if (confirma == JOptionPane.YES_OPTION) {
//            //imprimindo relatórios com framework JasperReports
//            try {
//                //Usando a class JasperPrint para preparar a impressão de um relatório
//                JasperPrint print = JasperFillManager.fillReport("C:/Users/Gessione/Documents/NetBeansProjects/Vitrine/src/relatorios/rel_ordem_servico_cancelada.jasper", null, conexao);
//                // a linha abaixo exibe o relatório através da classe JasperViewer
//                JasperViewer.viewReport(print, false);
//            } catch (JRException e) {
//                JOptionPane.showMessageDialog(null, e);
//            } finally {
//                try {
//                    conexao.close();
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//            }
//        }
//    }
//    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabelusuario = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadCadastro = new javax.swing.JMenu();
        jMenuCadOrdemServico = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jmenuCadFuncionario = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuRelatorio = new javax.swing.JMenu();
        jmenuRelCliente = new javax.swing.JMenuItem();
        jmenuRelServico = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItemUsuario = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuBloquearUsuario = new javax.swing.JMenu();
        jMenuItemAtivarUsuario = new javax.swing.JMenuItem();
        jMenuItemCliente = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vitrine - Menu  ");
        setResizable(false);

        jLabelusuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelusuario.setText("Usuário :");

        jLabelUsuario.setText("Usuario");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("SISTEMA VITRINE");

        jDesktopPane1.setLayer(jLabelusuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 530, Short.MAX_VALUE)
                .addComponent(jLabelusuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelUsuario)
                .addGap(19, 19, 19))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(382, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelusuario)
                    .addComponent(jLabelUsuario)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jMenuCadCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vitrine/icones/mais (5).png"))); // NOI18N
        jMenuCadCadastro.setText("Cadastros");

        jMenuCadOrdemServico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuCadOrdemServico.setText("Cadastro de Cliente");
        jMenuCadOrdemServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadOrdemServicoActionPerformed(evt);
            }
        });
        jMenuCadCadastro.add(jMenuCadOrdemServico);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem12.setText("Cadastro de Produto");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenuCadCadastro.add(jMenuItem12);

        jmenuCadFuncionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        jmenuCadFuncionario.setText("Cadastro de Funcionário");
        jmenuCadFuncionario.setEnabled(false);
        jmenuCadFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuCadFuncionarioActionPerformed(evt);
            }
        });
        jMenuCadCadastro.add(jmenuCadFuncionario);

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem13.setText("Cadastro de Veículo");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenuCadCadastro.add(jMenuItem13);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Cadastro de Fornecedor");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenuCadCadastro.add(jMenuItem4);

        jMenuBar1.add(jMenuCadCadastro);

        jMenuRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vitrine/icones/botao (2).png"))); // NOI18N
        jMenuRelatorio.setText("Relatórios");
        jMenuRelatorio.setEnabled(false);

        jmenuRelCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jmenuRelCliente.setText("Relatório de Clientes");
        jmenuRelCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuRelClienteActionPerformed(evt);
            }
        });
        jMenuRelatorio.add(jmenuRelCliente);

        jmenuRelServico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jmenuRelServico.setText("Relatório Ordens de Serviço por data");
        jMenuRelatorio.add(jmenuRelServico);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Relatório Ordens de Serviço por veículo");
        jMenuRelatorio.add(jMenuItem2);

        jMenuItemUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemUsuario.setText("Relatório Usuários");
        jMenuItemUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuarioActionPerformed(evt);
            }
        });
        jMenuRelatorio.add(jMenuItemUsuario);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem7.setText("Relatório Ordens de Serviço Canceladas");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenuRelatorio.add(jMenuItem7);

        jMenuBar1.add(jMenuRelatorio);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vitrine/icones/barra-de-menu (2).png"))); // NOI18N
        jMenu3.setText("Serviços");

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem10.setText("Cadastrar Ordem de Serviço");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem6.setText("Cancelar Ordem de Serviço");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem8.setText("Cadastrar Meus Serviços");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        jMenuBloquearUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vitrine/icones/seta-de-direcao (2).png"))); // NOI18N
        jMenuBloquearUsuario.setText("Configuração");

        jMenuItemAtivarUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemAtivarUsuario.setText("Gerenciar Usuários");
        jMenuItemAtivarUsuario.setEnabled(false);
        jMenuItemAtivarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAtivarUsuarioActionPerformed(evt);
            }
        });
        jMenuBloquearUsuario.add(jMenuItemAtivarUsuario);

        jMenuItemCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemCliente.setText("Gerenciar Cliente");
        jMenuItemCliente.setEnabled(false);
        jMenuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClienteActionPerformed(evt);
            }
        });
        jMenuBloquearUsuario.add(jMenuItemCliente);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Calculadora ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuBloquearUsuario.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setText("Suporte");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuBloquearUsuario.add(jMenuItem3);

        jMenuBar1.add(jMenuBloquearUsuario);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vitrine/icones/sair (1).png"))); // NOI18N
        jMenu1.setText("Sair Sistema");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem5.setText("Sair");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmenuCadFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuCadFuncionarioActionPerformed
        // Acao chamar tela Cadastrar Usuario pela barra de MenuPrincipal:
        Frm_CadastroFuncionario funcionario = new Frm_CadastroFuncionario();
        funcionario.setVisible(true);

    }//GEN-LAST:event_jmenuCadFuncionarioActionPerformed

    private void jMenuItemAtivarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAtivarUsuarioActionPerformed
       // Acao chamar tela Manutencao Usuario pela barra de MenuPrincipal:
        Frm_ManutencaoUsuario usuario = new Frm_ManutencaoUsuario();
        usuario.setVisible(true);
        
    }//GEN-LAST:event_jMenuItemAtivarUsuarioActionPerformed

    private void jmenuRelClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuRelClienteActionPerformed
        // metódo para emissão de relatórios:
//        relatorioClientes();
       
        
    }//GEN-LAST:event_jmenuRelClienteActionPerformed

    private void jMenuCadOrdemServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadOrdemServicoActionPerformed
        // Acao chamar tela Cliente pela barra de MenuPrincipal:
        Frm_CadastroClientes cliente = new Frm_CadastroClientes();
        cliente.setVisible(true);
    }//GEN-LAST:event_jMenuCadOrdemServicoActionPerformed

    private void jMenuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClienteActionPerformed
        // acao chamar tela Desbloqueio de Cliente pela barra de MenuPrincipal:
        Frm_DesbloqueioCliente cliente = new Frm_DesbloqueioCliente();
        cliente.setVisible(true);
      
    }//GEN-LAST:event_jMenuItemClienteActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
         // acao chamar tela Frm_Suporte:
        Frm_Suporte ajuda = new Frm_Suporte();
        ajuda.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // acao chamar tela Frm_Ordem_Servico:
        Frm_Ordem_Servico servico = new Frm_Ordem_Servico();
        servico.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // acao botao Sair do Menu:
        int sair = JOptionPane.showConfirmDialog(null, "Deseja sair do sistema?", "Atenção!", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            Frm_Login usuario = new Frm_Login();
            usuario.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItemUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuarioActionPerformed
        // metódo para emissão de relatórios:
//        relatorioUsuarios();
    }//GEN-LAST:event_jMenuItemUsuarioActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // acao chamar tela Calculadora:
         Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("calc");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No Windows:Erro ao tentar executar calculadora!");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
         // acao chamar tela Frm_CadastroVeiculo:
        Frm_CadastroVeiculo veiculo = new Frm_CadastroVeiculo();
        veiculo.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // acao chamar tela Frm_CadastroProduto produto:
        Frm_CadastroProduto produto = new Frm_CadastroProduto();
        produto.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
         // acao chamar tela Frm_CadastroFornecedor:
        Frm_CadastroFornecedor fornecedores = new Frm_CadastroFornecedor();
        fornecedores.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // acao char tela Frm_CancelarOrdemServico:
        Frm_CancelarOrdemServico consulta = new Frm_CancelarOrdemServico();
        consulta.setVisible(true);
      
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // acao char tela Frm_CadastroServico:
        Frm_CadastroServicos servico = new Frm_CadastroServicos();
        servico.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // metódo para emissão de relatórios:
//        relatorioOrdemServicoCancelada();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbu;s look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabelusuario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    public static javax.swing.JMenu jMenuBloquearUsuario;
    public static javax.swing.JMenu jMenuCadCadastro;
    private javax.swing.JMenuItem jMenuCadOrdemServico;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    public static javax.swing.JMenuItem jMenuItemAtivarUsuario;
    public static javax.swing.JMenuItem jMenuItemCliente;
    private javax.swing.JMenuItem jMenuItemUsuario;
    public static javax.swing.JMenu jMenuRelatorio;
    public static javax.swing.JMenuItem jmenuCadFuncionario;
    private javax.swing.JMenuItem jmenuRelCliente;
    private javax.swing.JMenuItem jmenuRelServico;
    // End of variables declaration//GEN-END:variables

        }
    

