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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Senha:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 100, 100, 30);

        btnLoginFunc.setText("Login funcionario");
        btnLoginFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginFuncActionPerformed(evt);
            }
        });
        getContentPane().add(btnLoginFunc);
        btnLoginFunc.setBounds(200, 160, 130, 50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Usuario:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 60, 100, 30);
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(140, 60, 190, 30);

        btnLoginPac.setText(" Login paciente");
        btnLoginPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginPacActionPerformed(evt);
            }
        });
        getContentPane().add(btnLoginPac);
        btnLoginPac.setBounds(40, 160, 140, 50);
        getContentPane().add(txtSenha);
        txtSenha.setBounds(140, 100, 190, 30);

        btnCadastrar.setText("Fazer cadastro");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar);
        btnCadastrar.setBounds(130, 220, 120, 30);

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
        btnRecSenha.setBounds(80, 20, 230, 20);

        setSize(new java.awt.Dimension(416, 308));
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
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
