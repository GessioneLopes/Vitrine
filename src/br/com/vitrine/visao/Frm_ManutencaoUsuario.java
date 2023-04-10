package br.com.vitrine.visao;

import br.com.vitrine.DAO.ModuloConexao;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Gessione
 */
public class Frm_ManutencaoUsuario extends javax.swing.JFrame {

    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;

    /**
     * Creates new form Frm_AlterarUsuario
     */
    public Frm_ManutencaoUsuario() {
        initComponents();
        
         jButtonCadastrar.setEnabled(true);
         jButtonEditar.setEnabled(false);
         jButtonInativar.setEnabled(false);
         jButtonAtivar.setEnabled(false);
         jButtonLimpar.setEnabled(true);
         
        
        formatarTelefone();
        getContentPane().setBackground(Color.WHITE); // Mudar cor de fundo do Background tela Frm_AlterarUsuario
    }

    /**
     * Método responsável por adicionar um novo usuário
     */
    private void CadastrarUsuario() {
        String sql = "insert into tbusuarios(usuario,telefone,login,senha,perfil) values (?,?,?,?,?)";
        try {
            conexao = ModuloConexao.conectar();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, jTextFieldNome.getText());
            pst.setString(2, jFormattedTextFieldtelefone.getText());
            pst.setString(3, jTextFieldusuario.getText());
            String captura = new String(jPasswordFieldsenha.getPassword());
            pst.setString(4, captura);
            pst.setString(5, jComboBoxperfil.getSelectedItem().toString());
            if ((jTextFieldNome.getText().isEmpty()) || (jFormattedTextFieldtelefone.getText().isEmpty()) || (jTextFieldusuario.getText().isEmpty()) || (jPasswordFieldsenha.getPassword().length == 0) || jComboBoxperfil.getSelectedItem().equals("Selecione")) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário Cadastrado com sucesso");
                    limpar();
                }
            }
        } catch (SQLIntegrityConstraintViolationException e1) {
            JOptionPane.showMessageDialog(null, "Login em uso.\nEscolha outro login.");
            jTextFieldusuario.setText(null);
            jTextFieldusuario.requestFocus();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    /**
     * Método responsável pela pesquisa de usuario pelo nome com filtro
     */
    private void PesquisarUsuario() {
        String sql = "select * from tbusuarios where usuario like?";
        try {
            conexao = ModuloConexao.conectar();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, jTextFieldNome.getText() + "%");
            rs = pst.executeQuery();
            jTableUsuario.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    /**
     * método usado para setar os campos de texto com o conteúdo da tabela
     * Usuario
     */
    private void setarCampos() {
        int setar = jTableUsuario.getSelectedRow();
        jTextFieldCodigo.setText(jTableUsuario.getModel().getValueAt(setar, 0).toString());
        jTextFieldNome.setText(jTableUsuario.getModel().getValueAt(setar, 1).toString());
        jFormattedTextFieldtelefone.setText(jTableUsuario.getModel().getValueAt(setar, 2).toString());
        jTextFieldusuario.setText(jTableUsuario.getModel().getValueAt(setar, 3).toString());
        jPasswordFieldsenha.setText(jTableUsuario.getModel().getValueAt(setar, 4).toString());
        jComboBoxperfil.setSelectedItem(jTableUsuario.getModel().getValueAt(setar, 5).toString());
        

    }
    
    /**
     * Método responsável por Ativar um usuario
     */
    private void ativarUsuario() {
        int confirma = JOptionPane.showConfirmDialog(null, "Confirma Ativar este usuário?", "Atenção!", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "update tbusuarios set situacao = 'ATIVO' where id_usuario = ?";
            try {
                conexao = ModuloConexao.conectar();
                pst = conexao.prepareStatement(sql);
                pst.setString(1, jTextFieldCodigo.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usuário Desbloqueado com sucesso!!");
                limpar();
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }

     /**
     * Método responsável por Inativar um Usuario
     */
    private void InativarUsuario() {
        int confirma = JOptionPane.showConfirmDialog(null, "Confirma Inativar este Usuário?", "Atenção!", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "update tbusuarios set situacao = 'INATIVO' where id_usuario = ?";
            try {
                conexao = ModuloConexao.conectar();
                pst = conexao.prepareStatement(sql);
                pst.setString(1, jTextFieldCodigo.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usuário Inativado com sucesso!!");
                limpar();
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }
    
       /**
     * Método responsável pela edição dos dados do usuário incluindo a senha
     */
    private void editarUsuarioSenha() {
        String sql = "update tbusuarios set usuario=?,telefone=?,login=?,senha=?,perfil=? where id_usuario=?";
        try {
            conexao = ModuloConexao.conectar();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, jTextFieldNome.getText());
            pst.setString(2, jFormattedTextFieldtelefone.getText());
            pst.setString(3, jTextFieldusuario.getText());
            String captura = new String(jPasswordFieldsenha.getPassword());
            pst.setString(4, captura);
            pst.setString(5, jComboBoxperfil.getSelectedItem().toString());
            pst.setString(6, jTextFieldCodigo.getText());
            if ((jTextFieldCodigo.getText().isEmpty()) || (jTextFieldNome.getText().isEmpty()) || (jTextFieldusuario.getText().isEmpty()) || (jPasswordFieldsenha.getPassword().length == 0) || jComboBoxperfil.getSelectedItem().equals(" ")) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!!");
            } else {
                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Senha do Usuário alterada com sucesso!!");
                    limpar();
                }
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    /**
     * Método responsável pela edição dos dados do usuário sem modificar a senha
     */
    private void editarUsuario() {
        String sql = "update tbusuarios set usuario=?,telefone=?,login=?,perfil=? where id_usuario=?";
        try {
            conexao = ModuloConexao.conectar();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, jTextFieldNome.getText());
            pst.setString(2, jFormattedTextFieldtelefone.getText());
            pst.setString(3, jTextFieldusuario.getText());
            pst.setString(4, jComboBoxperfil.getSelectedItem().toString());
            pst.setString(5, jTextFieldCodigo.getText());
            if ((jTextFieldCodigo.getText().isEmpty())||(jTextFieldNome.getText().isEmpty()) || (jFormattedTextFieldtelefone.getText().isEmpty())||(jTextFieldusuario.getText().isEmpty())|| jComboBoxperfil.getSelectedItem().equals(" ")) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!!");
            } else {
                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!!");
                    limpar();
                }
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

     
    /**
     * Método responsável por limpar os campos e gerenciar os componentes
     */
    private void limpar() {
        jTextFieldCodigo.setText(null);
        jTextFieldNome.setText(null);
        jTextFieldusuario.setText(null);
        jPasswordFieldsenha.setText(null);
        jComboBoxperfil.setSelectedItem("Selecione");
        jFormattedTextFieldtelefone.setText(null);
        jCheckBoxalterarsenha.setSelected(false);
        jCheckBoxalterarsenha.setVisible(true);
        jCheckBoxalterarsenha.setEnabled(true);
        jButtonAtivar.setEnabled(true);
        jButtonCadastrar.setEnabled(true);
        jButtonEditar.setEnabled(true);
        jButtonInativar.setEnabled(true);
        jTextFieldNome.requestFocus();
        ((DefaultTableModel) jTableUsuario.getModel()).setRowCount(0);
     
        
    }
    
    
    /**
     * Método responsável por formatar campo Telefone
     */
    private void formatarTelefone() {
        try {
            MaskFormatter mask = new MaskFormatter("##-#####-####");
            mask.install(jFormattedTextFieldtelefone);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto.", "ERRO", JOptionPane.ERROR);
        }
    }
   
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jButtonAtivar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuario = new javax.swing.JTable();
        jLabeljLabeltelefone = new javax.swing.JLabel();
        jFormattedTextFieldtelefone = new javax.swing.JFormattedTextField();
        jButtonInativar = new javax.swing.JButton();
        jButtonCadastrar = new javax.swing.JButton();
        jCheckBoxalterarsenha = new javax.swing.JCheckBox();
        jLabelperfil = new javax.swing.JLabel();
        jComboBoxperfil = new javax.swing.JComboBox<>();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldusuario = new javax.swing.JTextField();
        jLabelsenha = new javax.swing.JLabel();
        jPasswordFieldsenha = new javax.swing.JPasswordField();
        jButtonEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vitrine - Gestão de Perfil de Usuários");
        setResizable(false);

        jLabelCodigo.setText("Código :");

        jTextFieldCodigo.setEditable(false);
        jTextFieldCodigo.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCodigo.setOpaque(false);

        jButtonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vitrine/icones/icons8-pesquisar-24.png"))); // NOI18N
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jLabelNome.setText("Nome   :");

        jTextFieldNome.setToolTipText("Pesquisar aqui...");
        jTextFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyReleased(evt);
            }
        });

        jButtonAtivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vitrine/icones/atualizada (2).png"))); // NOI18N
        jButtonAtivar.setText("Ativar");
        jButtonAtivar.setToolTipText("Ativar");
        jButtonAtivar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        jButtonAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtivarActionPerformed(evt);
            }
        });

        jButtonLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vitrine/icones/fechar (2).png"))); // NOI18N
        jButtonLimpar.setText("Limpar");
        jButtonLimpar.setToolTipText("Limpar");
        jButtonLimpar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jTableUsuario = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jTableUsuario.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jTableUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Telefone", "Usuário", "Senha", "Perfil", "Status"
            }
        ));
        jTableUsuario.setFocusable(false);
        jTableUsuario.setShowHorizontalLines(false);
        jTableUsuario.setShowVerticalLines(false);
        jTableUsuario.getTableHeader().setResizingAllowed(false);
        jTableUsuario.getTableHeader().setReorderingAllowed(false);
        jTableUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUsuarioMouseClicked(evt);
            }
        });
        jTableUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableUsuarioKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableUsuario);

        jLabeljLabeltelefone.setText("Telefone :");

        jFormattedTextFieldtelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldtelefoneKeyReleased(evt);
            }
        });

        jButtonInativar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vitrine/icones/excluir (2).png"))); // NOI18N
        jButtonInativar.setText("Inativar");
        jButtonInativar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        jButtonInativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInativarActionPerformed(evt);
            }
        });

        jButtonCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vitrine/icones/mais (5).png"))); // NOI18N
        jButtonCadastrar.setText("Salvar");
        jButtonCadastrar.setToolTipText("Salvar");
        jButtonCadastrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jCheckBoxalterarsenha.setText("Alterar Senha");
        jCheckBoxalterarsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxalterarsenhaActionPerformed(evt);
            }
        });

        jLabelperfil.setText("Perfil       :");

        jComboBoxperfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Administrador", "Usuario Padrao" }));
        jComboBoxperfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jComboBoxperfil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBoxperfilKeyReleased(evt);
            }
        });

        jLabelUsuario.setText("Usuário:");

        jTextFieldusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldusuarioKeyReleased(evt);
            }
        });

        jLabelsenha.setText("Senha:");

        jPasswordFieldsenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldsenhaKeyReleased(evt);
            }
        });

        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vitrine/icones/editar (2).png"))); // NOI18N
        jButtonEditar.setText("Editar");
        jButtonEditar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonInativar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButtonAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNome)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelUsuario)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabelsenha)
                                .addGap(16, 16, 16)
                                .addComponent(jPasswordFieldsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelCodigo)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabeljLabeltelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFormattedTextFieldtelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelperfil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxperfil, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jCheckBoxalterarsenha)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabelCodigo))
                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNome)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextFieldtelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabeljLabeltelefone))
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jPasswordFieldsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxperfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelperfil, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelUsuario)
                            .addComponent(jLabelsenha))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxalterarsenha)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonInativar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBoxperfil, jFormattedTextFieldtelefone, jPasswordFieldsenha, jTextFieldNome, jTextFieldusuario});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        // acao botao Pesquisar:
       PesquisarUsuario();
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        // acao botao Limpar:
        limpar();
       
        jButtonEditar.setEnabled(false);
        jButtonInativar.setEnabled(false);
        jButtonAtivar.setEnabled(false);
        
        
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtivarActionPerformed
        // acao Ativar Usuario:
        ativarUsuario();
        limpar();
        PesquisarUsuario();
         
     
    }//GEN-LAST:event_jButtonAtivarActionPerformed

    private void jTableUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsuarioMouseClicked
        // acao para setar dados na tabela:
        setarCampos();
        jButtonEditar.setEnabled(true);
        jButtonInativar.setEnabled(true);
        jButtonAtivar.setEnabled(true);
       
       
    }//GEN-LAST:event_jTableUsuarioMouseClicked

    private void jTableUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableUsuarioKeyReleased
        // acao para setar dados na tabela:
         setarCampos();
    }//GEN-LAST:event_jTableUsuarioKeyReleased

    private void jTextFieldNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeKeyReleased
         // acao botao Pesquisar e acao para pular do campo Nome para Telefone com a Tecla Enter:
           PesquisarUsuario();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jFormattedTextFieldtelefone.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldNomeKeyReleased

    private void jButtonInativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInativarActionPerformed
        // acao botao Inativar Usuario:
           InativarUsuario();
           PesquisarUsuario();
    }//GEN-LAST:event_jButtonInativarActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        // acao botao adicionar novo usuario:
         CadastrarUsuario();
         PesquisarUsuario();
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jCheckBoxalterarsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxalterarsenhaActionPerformed
        jPasswordFieldsenha.setText(null);
        jPasswordFieldsenha.requestFocus();
        jPasswordFieldsenha.setEnabled(true);
        jCheckBoxalterarsenha.setEnabled(false);        
    }//GEN-LAST:event_jCheckBoxalterarsenhaActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // acao botão Editar e Alterar Senha:
         if (jCheckBoxalterarsenha.isSelected()) {
            editarUsuarioSenha();
        } else {
            editarUsuario();
        }
         PesquisarUsuario();

    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jFormattedTextFieldtelefoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldtelefoneKeyReleased
         // acao para pular do campo Telefone para Usuario com a Tecla Enter:
          if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextFieldusuario.requestFocus();
        }
    }//GEN-LAST:event_jFormattedTextFieldtelefoneKeyReleased

    private void jTextFieldusuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldusuarioKeyReleased
        // acao para pular do campo Usuario para Senha com a Tecla Enter:
          if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jPasswordFieldsenha.requestFocus();
        }
        
    }//GEN-LAST:event_jTextFieldusuarioKeyReleased

    private void jPasswordFieldsenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldsenhaKeyReleased
        // acao para pular do campo Senha para Perfil com a Tecla Enter:
          if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jComboBoxperfil.requestFocus();
          }
    }//GEN-LAST:event_jPasswordFieldsenhaKeyReleased

    private void jComboBoxperfilKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxperfilKeyReleased
        // acao para pular do campo Perfil para Nome com a Tecla Enter:
          if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextFieldNome.requestFocus();
          }
    }//GEN-LAST:event_jComboBoxperfilKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Frm_ManutencaoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_ManutencaoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_ManutencaoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_ManutencaoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_ManutencaoUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtivar;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonInativar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JCheckBox jCheckBoxalterarsenha;
    private javax.swing.JComboBox<String> jComboBoxperfil;
    private javax.swing.JFormattedTextField jFormattedTextFieldtelefone;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabeljLabeltelefone;
    private javax.swing.JLabel jLabelperfil;
    private javax.swing.JLabel jLabelsenha;
    private javax.swing.JPasswordField jPasswordFieldsenha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuario;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldusuario;
    // End of variables declaration//GEN-END:variables
}
