package View;

import Dados.Funcionario;
import Dados.Paciente;
import Dados.SistemaDao;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class RecuperarSenha extends javax.swing.JFrame {

    public RecuperarSenha() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNovaSenha = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbConta = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Digite sua nova senha:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 290, 140, 30);
        getContentPane().add(txtNovaSenha);
        txtNovaSenha.setBounds(300, 290, 140, 30);

        btnConfirmar.setBackground(new java.awt.Color(19, 148, 205));
        btnConfirmar.setForeground(new java.awt.Color(0, 0, 0));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfirmar);
        btnConfirmar.setBounds(240, 340, 130, 30);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Digite seu usuario:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, 170, 110, 30);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Digite seu CPF:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(180, 210, 110, 30);
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(300, 170, 140, 30);
        getContentPane().add(txtCpf);
        txtCpf.setBounds(300, 210, 140, 30);

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Tipo de conta:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(180, 250, 110, 30);

        cmbConta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Paciente", "Funcionario" }));
        getContentPane().add(cmbConta);
        cmbConta.setBounds(300, 250, 140, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/esqueci a senha.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 606, 450);

        setSize(new java.awt.Dimension(621, 456));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        //Criando as variaveis para validar a conta
        String tipoConta;

        //Passando os valores dos txt e do cmb para as variaveis
        tipoConta = cmbConta.getSelectedItem().toString();

        //É obrigatório selecionar o tipo de conta que quer recuperar a senha
        if (tipoConta.equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione um tipo de conta!");
            cmbConta.requestFocus();
            return; //Para a execução do botão
        }

        try {

            SistemaDao dao = new SistemaDao();
            ResultSet resultado;

            //Se o tipo de conta for de Paciente
            if (tipoConta.equalsIgnoreCase("Paciente")) {

                //Usando o método set da minha classe molde do paciente
                Paciente paciente = new Paciente();
                paciente.setUsuario(txtUsuario.getText());
                paciente.setCpf(txtCpf.getText());

                //Validar se o paciente existe e a pessoa realmente sabe o usuário e tem um cpf cadastrado
                resultado = dao.validarCpfPaciente(paciente);

                //Se exister no banco de dados
                if (resultado.next()) {

                    //Pegar o id do paciente
                    paciente.setIdPaciente(Integer.parseInt(resultado.getString("idpaciente")));
                    paciente.setSenha(txtNovaSenha.getText());

                    //Alterando a senha do paciente
                    dao.alterarSenhaPaciente(paciente);

                    //Confirmando que a senha foi alterada e fechando a tela
                    JOptionPane.showMessageDialog(null, "Senha alterada com sucesso");
                    dispose();

                } else {

                    //Caso não exista conta com o CPF e Usuario digitados
                    JOptionPane.showMessageDialog(null, "Usuario e CPF não combinam");
                    limparDados();

                }

            } else {

                //Criando o objeto funcionario e pegando os valores dos txt
                Funcionario funcionario = new Funcionario();
                funcionario.setUsuario(txtUsuario.getText());
                funcionario.setCpf(txtCpf.getText());

                //Caso a conta seja de funcionario
                resultado = dao.validarCpfFuncionario(funcionario);

                //Caso exista funcionario com esse usuario e cpf
                if (resultado.next()) {

                    //Pegando id do funcionario
                    funcionario.setIdFuncionario(Integer.parseInt(resultado.getString("idfuncionario")));
                    funcionario.setSenha(txtNovaSenha.getText());

                    //Alterando a senha do funcionario
                    dao.alterarSenhaFuncionario(funcionario);

                    //Confirmando alteração e fechando a tela
                    JOptionPane.showMessageDialog(null, "Senha alterada com sucesso");
                    dispose();

                } else {

                    //Caso não exista funcionario com o cpf e usuario digitados
                    JOptionPane.showMessageDialog(null, "Usuario e CPF não combinam");
                    limparDados();

                }
            }

            //Catchs padrões
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    public void limparDados() {
        txtCpf.setText("");
        txtNovaSenha.setText("");
        txtUsuario.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> cmbConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtNovaSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
