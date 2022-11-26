package View;

import Dados.Funcionario;
import Dados.Paciente;
import Dados.SistemaDao;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnLoginFunc = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnLoginPac = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        btnCadastrar = new javax.swing.JButton();
        btnRecSenha = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Senha:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(500, 160, 100, 30);

        btnLoginFunc.setBackground(new java.awt.Color(19, 148, 205));
        btnLoginFunc.setForeground(new java.awt.Color(0, 0, 0));
        btnLoginFunc.setText("Login funcionario");
        btnLoginFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginFuncActionPerformed(evt);
            }
        });
        getContentPane().add(btnLoginFunc);
        btnLoginFunc.setBounds(680, 220, 130, 50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Usuario:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(490, 120, 100, 30);

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(570, 120, 190, 30);

        btnLoginPac.setBackground(new java.awt.Color(19, 148, 205));
        btnLoginPac.setForeground(new java.awt.Color(0, 0, 0));
        btnLoginPac.setText(" Login paciente");
        btnLoginPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginPacActionPerformed(evt);
            }
        });
        getContentPane().add(btnLoginPac);
        btnLoginPac.setBounds(510, 220, 140, 50);

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(txtSenha);
        txtSenha.setBounds(570, 160, 190, 30);

        btnCadastrar.setBackground(new java.awt.Color(19, 148, 205));
        btnCadastrar.setForeground(new java.awt.Color(0, 0, 0));
        btnCadastrar.setText("Fazer cadastro");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar);
        btnCadastrar.setBounds(610, 290, 120, 40);

        btnRecSenha.setBackground(new java.awt.Color(242, 242, 242));
        btnRecSenha.setForeground(new java.awt.Color(255, 0, 0));
        btnRecSenha.setText("Esqueci minha senha");
        btnRecSenha.setBorder(null);
        btnRecSenha.setBorderPainted(false);
        btnRecSenha.setContentAreaFilled(false);
        btnRecSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRecSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(btnRecSenha);
        btnRecSenha.setBounds(570, 340, 190, 30);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/login.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 830, 420);

        setSize(new java.awt.Dimension(844, 421));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginPacActionPerformed
        //Instanciando objeto paciente
        Paciente paciente = new Paciente();

        //Setando usuario e senho o obj paciente
        paciente.setUsuario(txtUsuario.getText());
        paciente.setSenha(txtSenha.getText());

        try {

            //Padrão para fazer a query no bd
            SistemaDao dao = new SistemaDao();
            ResultSet resultado;

            //Validando usuario e senha
            resultado = dao.validarPaciente(paciente);

            //Se existir
            if (resultado.next()) {

                //Buscando o id do paciente
                paciente.setIdPaciente(Integer.parseInt(resultado.getString("idpaciente")));

                //Abrindo a tela menu
                Menu tela = new Menu(false, paciente.getIdPaciente(), null);
                tela.setVisible(true);

            } else {

                //Caso usuário e senha não combinem
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválido");
            }

            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnLoginPacActionPerformed

    private void btnLoginFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginFuncActionPerformed

        //Instanciando objeto funcionario
        Funcionario funcionario = new Funcionario();

        //Passando os valores txt para o objeto
        funcionario.setUsuario(txtUsuario.getText());
        funcionario.setSenha(txtSenha.getText());

        try {

            SistemaDao dao = new SistemaDao();
            ResultSet resultado;

            //Validando funcionario
            resultado = dao.validarFuncionario(funcionario);

            //Se existir
            if (resultado.next()) {

                //Setando o id e cargo no objeto funcionario
                funcionario.setIdFuncionario(Integer.parseInt(resultado.getString("idfuncionario")));
                funcionario.setCargo(resultado.getString("cargo"));

                //Abrindo a tela Muno
                Menu tela = new Menu(true, funcionario.getIdFuncionario(), funcionario.getCargo());
                tela.setVisible(true);

            } else {

                //Caso não exista o funcionario
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválido");

            }

            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnLoginFuncActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        CadastroPaciente cadastroPac = new CadastroPaciente();
        cadastroPac.setVisible(true);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnRecSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecSenhaActionPerformed
        RecuperarSenha rs = new RecuperarSenha();
        rs.setVisible(true);
    }//GEN-LAST:event_btnRecSenhaActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnLoginFunc;
    private javax.swing.JButton btnLoginPac;
    private javax.swing.JButton btnRecSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
