package View;

import Dados.Funcionario;
import Dados.Paciente;
import Dados.SistemaDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AlterarDados extends javax.swing.JFrame {

    private int userId;
    private boolean funcionario;

    //Método construtor
    public AlterarDados(boolean funcionario, int userId) {
        initComponents();

        //Passando os dados para as variaveis globais
        this.funcionario = funcionario;
        this.userId = userId;

        preencherCampos();
        definirFuncionario();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblExcluirConta = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lblIdFuncionario = new javax.swing.JLabel();
        cmbIdFuncionario = new javax.swing.JComboBox<>();
        txtNomeFuncionario = new javax.swing.JTextField();
        txtCargoAtual = new javax.swing.JTextField();
        btnConcluir = new javax.swing.JButton();
        btnExcluirConta = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Alterar usuario:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 100, 110, 20);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Alterar senha:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 140, 100, 20);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Alterar nome:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 180, 100, 20);

        lblExcluirConta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblExcluirConta.setForeground(new java.awt.Color(255, 51, 51));
        lblExcluirConta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExcluirConta.setText("Deseja excluir sua conta?");
        getContentPane().add(lblExcluirConta);
        lblExcluirConta.setBounds(450, 50, 200, 20);

        lblCargo.setForeground(new java.awt.Color(0, 0, 0));
        lblCargo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCargo.setText("Alterar cargo:");
        getContentPane().add(lblCargo);
        lblCargo.setBounds(80, 400, 90, 20);

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Alterar telefone:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 220, 110, 20);
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(180, 100, 180, 22);
        getContentPane().add(txtSenha);
        txtSenha.setBounds(180, 140, 180, 22);
        getContentPane().add(txtNome);
        txtNome.setBounds(180, 180, 180, 22);
        getContentPane().add(txtTelefone);
        txtTelefone.setBounds(180, 220, 180, 22);
        getContentPane().add(txtEmail);
        txtEmail.setBounds(180, 262, 180, 30);

        lblIdFuncionario.setForeground(new java.awt.Color(0, 0, 0));
        lblIdFuncionario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIdFuncionario.setText("Qual o id no funcionario:");
        getContentPane().add(lblIdFuncionario);
        lblIdFuncionario.setBounds(80, 320, 140, 16);

        cmbIdFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIdFuncionarioActionPerformed(evt);
            }
        });
        getContentPane().add(cmbIdFuncionario);
        cmbIdFuncionario.setBounds(130, 350, 70, 22);

        txtNomeFuncionario.setEditable(false);
        getContentPane().add(txtNomeFuncionario);
        txtNomeFuncionario.setBounds(210, 350, 90, 22);

        txtCargoAtual.setEditable(false);
        getContentPane().add(txtCargoAtual);
        txtCargoAtual.setBounds(310, 350, 90, 22);

        btnConcluir.setBackground(new java.awt.Color(19, 148, 205));
        btnConcluir.setForeground(new java.awt.Color(0, 0, 0));
        btnConcluir.setText("Concluir");
        btnConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnConcluir);
        btnConcluir.setBounds(320, 460, 110, 40);

        btnExcluirConta.setBackground(new java.awt.Color(19, 148, 205));
        btnExcluirConta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcluirConta.setForeground(new java.awt.Color(0, 0, 0));
        btnExcluirConta.setText("Excluir");
        btnExcluirConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirContaActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluirConta);
        btnExcluirConta.setBounds(510, 90, 90, 30);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Alterar email:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 260, 110, 30);

        txtCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCargo);
        txtCargo.setBounds(180, 400, 180, 22);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/alterar dados.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 640, 530);

        setSize(new java.awt.Dimension(651, 537));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Definindo o nivel de acesso
    private void definirFuncionario() {
        try {

            //Padrão
            SistemaDao dao = new SistemaDao();

            //Verificando se é um funcionario
            if (funcionario == true) {

                //Instânciando objeto funcionário
                Funcionario funcionario = new Funcionario();

                //Setando o id dele
                funcionario.setIdFuncionario(userId);

                //Fazendo uma busca para saber o cargo do  funcionario
                funcionario = dao.filtrarFuncionario(funcionario);

                if (funcionario.getCargo().equalsIgnoreCase("Administrador")) {
                    lblCargo.setVisible(true);
                    txtCargo.setVisible(true);
                    lblIdFuncionario.setVisible(true);
                    cmbIdFuncionario.setVisible(true);
                    txtNomeFuncionario.setVisible(true);
                    txtCargoAtual.setVisible(true);
                    lblExcluirConta.setVisible(false);
                    btnExcluirConta.setVisible(false);
                    preencherIdFuncionario();
                }else{
                lblCargo.setVisible(false);
                txtCargo.setVisible(false);
                lblIdFuncionario.setVisible(false);
                cmbIdFuncionario.setVisible(false);
                txtNomeFuncionario.setVisible(false);
                txtCargoAtual.setVisible(false);
                lblExcluirConta.setVisible(false);
                btnExcluirConta.setVisible(false);
                
                }

            } else {
                lblCargo.setVisible(false);
                txtCargo.setVisible(false);
                lblIdFuncionario.setVisible(false);
                cmbIdFuncionario.setVisible(false);
                txtNomeFuncionario.setVisible(false);
                txtCargoAtual.setVisible(false);
                lblExcluirConta.setVisible(true);
                btnExcluirConta.setVisible(true);
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    //Colocando o id de todos os funcionarios em um cmb
    private void cmbIdFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIdFuncionarioActionPerformed
        if (cmbIdFuncionario.toString().equals("")) {
            return; //Caso não for selecionado nada, não vai acontecer nada
        }
        try {
            String converterCmb;

            //Padrão
            SistemaDao dao = new SistemaDao();
            converterCmb = cmbIdFuncionario.getSelectedItem().toString();

            //Instanciando novo obj funcionario
            Funcionario funcionario = new Funcionario();

            //Buscando funcionario pelo ID
            funcionario.setIdFuncionario(Integer.parseInt(converterCmb));
            funcionario = dao.filtrarFuncionario(funcionario);

            if (funcionario != null) {

                //Preenchendo os txt com o nome e o cargo do funcionario selecionado
                txtNomeFuncionario.setText(funcionario.getNome());
                txtCargoAtual.setText(funcionario.getCargo());

            } else {

                //Caso de algo errado
                JOptionPane.showMessageDialog(null, "Algo deu errado!");
                return;

            }

            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }


    }//GEN-LAST:event_cmbIdFuncionarioActionPerformed

    //Concluindo alteração
    private void btnConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirActionPerformed

        if (txtUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Usuario não pode estar vazio");
            txtUsuario.requestFocus();
            return;
        }
        if (txtEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Email não pode estar vazio");
            txtEmail.requestFocus();
            return;
        }
        if (txtSenha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Senha não pode estar vazia");
            txtSenha.requestFocus();
            return;
        }
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome não pode estar vazio");
            txtNome.requestFocus();
            return;
        }

        try {

            SistemaDao dao = new SistemaDao();

            //Se for funcionario
            if (funcionario == true) {

                //Instanciando objeto funcionario
                Funcionario funcionario = new Funcionario();

                //Setando alterações no objeto
                funcionario.setIdFuncionario(userId);
                funcionario.setUsuario(txtUsuario.getText());
                funcionario.setSenha(txtSenha.getText());
                funcionario.setNome(txtNome.getText());
                funcionario.setTelefone(txtTelefone.getText());
                funcionario.setCargo(txtCargo.getText());
                funcionario.setEmail(txtEmail.getText());

                //Trocando o usuario de Funcionario
                if (!funcionario.getUsuario().isEmpty()) {
                    dao.alterarUsuarioFuncionario(funcionario);
                }

                //Trocando Senha de Funcionario
                if (!funcionario.getSenha().isEmpty()) {
                    dao.alterarSenhaFuncionario(funcionario);
                }

                //Trocando Nome de Funcionario
                if (!funcionario.getNome().isEmpty()) {
                    dao.alterarNomeFuncionario(funcionario);
                }

                //Trocando Telefone de Funcionario
                dao.alterarTelefoneFuncionario(funcionario);

                //Trocando Email de Funcionario
                if (!funcionario.getEmail().isEmpty()) {
                    dao.alterarEmailFuncionario(funcionario);
                }

                if (cmbIdFuncionario.getSelectedItem() != null) {
                    if (funcionario.getCargo() != txtCargoAtual.getText() && !funcionario.getCargo().isEmpty()) {

                        //Criando váriavel para converter o cmb para string, para depois converter em int para o ID
                        String converterCmb;
                        converterCmb = cmbIdFuncionario.getSelectedItem().toString();
                        funcionario.setIdFuncionario(Integer.parseInt(converterCmb)); //Tomar cuidado para não estar antes do resto e prejudicar a alteração padrão

                        //alterando cargo
                        dao.alterarCargo(funcionario);
                    } else {
                        JOptionPane.showMessageDialog(null, "Cargo não alterado");
                    }

                }

            } else {

                //Instanciando objeto paciente
                Paciente paciente = new Paciente();
                paciente.setIdPaciente(userId);
                paciente.setUsuario(txtUsuario.getText());
                paciente.setSenha(txtSenha.getText());
                paciente.setNome(txtNome.getText());
                paciente.setTelefone(txtTelefone.getText());
                paciente.setEmail(txtEmail.getText());

                //Trocando o usuario do Paciente
                if (!paciente.getUsuario().isEmpty()) {
                    dao.alterarUsuarioPaciente(paciente);
                }

                //Trocando Senha do Paciente
                if (!paciente.getSenha().isEmpty()) {
                    dao.alterarSenhaPaciente(paciente);
                }

                //Trocando Nome do Paciente
                if (!paciente.getNome().isEmpty()) {
                    dao.alterarNomePaciente(paciente);
                }

                //Trocando Telefone do Paciente
                if (!paciente.getTelefone().isEmpty()) {
                    dao.alterarTelefonePaciente(paciente);
                }

                //Trocando Email do Paciente
                if (!paciente.getEmail().isEmpty()) {
                    dao.alterarEmailPaciente(paciente);
                }

            }

            //Confirmação de alteração e fechamento da tela
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
            dispose();

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnConcluirActionPerformed

    private void btnExcluirContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirContaActionPerformed
        try {
            SistemaDao dao = new SistemaDao();

            //Instanciando objeto paciente e setando id
            Paciente paciente = new Paciente();
            paciente.setIdPaciente(userId);

            //Excluindo conta
            dao.excluirPaciente(paciente);

            //Confirmando exclusão e fechando software
            JOptionPane.showMessageDialog(null, "Você excluiu sua conta com sucesso!");
            System.exit(0);

            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnExcluirContaActionPerformed

    private void txtCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargoActionPerformed

    private void preencherCampos() {
        try {

            //Padrão
            SistemaDao dao = new SistemaDao();

            //Verificando se é funcionario
            if (funcionario == true) {

                //Instanciando objeto funcionario e setando id
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(userId);

                //Filtrando qual funcionario é
                funcionario = dao.filtrarFuncionario(funcionario);

                //Se não tiver dado problema
                if (funcionario != null) {
                    txtUsuario.setText(funcionario.getUsuario());
                    txtSenha.setText(funcionario.getSenha());
                    txtNome.setText(funcionario.getNome());
                    txtTelefone.setText(funcionario.getTelefone());
                    txtEmail.setText(funcionario.getEmail());

                } else {

                    JOptionPane.showMessageDialog(null, "Funcionario não existe");
                    return;

                }

            } else {

                //Instanciando objeto paciente e setando id
                Paciente paciente = new Paciente();
                paciente.setIdPaciente(userId);

                //Filtrando qual paciente é
                paciente = dao.filtrarPaciente(paciente);

                //Se não tiver dado problema
                if (paciente != null) {
                    txtUsuario.setText(paciente.getUsuario());
                    txtSenha.setText(paciente.getSenha());
                    txtNome.setText(paciente.getNome());
                    txtTelefone.setText(paciente.getTelefone());
                    txtEmail.setText(paciente.getEmail());
                } else {

                    JOptionPane.showMessageDialog(null, "Paciente não existe");
                    return;
                }
            }

            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void preencherIdFuncionario() {
        try {
            String idFuncionario;
            SistemaDao dao = new SistemaDao();

            //Busca todos os usuários
            ResultSet resultado = dao.listarIdFuncionario();

            //Adicionar primeiro item vazio
            cmbIdFuncionario.addItem(null);

            //fazer até chegar no final da tabela (enquanto tiver próximo usuário)
            while (resultado.next()) {
                idFuncionario = resultado.getString("idfuncionario");
                cmbIdFuncionario.addItem(idFuncionario);
            }

            //Padrão    
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConcluir;
    private javax.swing.JButton btnExcluirConta;
    private javax.swing.JComboBox<String> cmbIdFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblExcluirConta;
    private javax.swing.JLabel lblIdFuncionario;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtCargoAtual;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeFuncionario;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
