package View;

import Dados.Consulta;
import Dados.SistemaDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AlterarData extends javax.swing.JFrame {

    public AlterarData() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtIdAlterar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        txtDia = new javax.swing.JTextField();
        txtMes = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnConcluir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(txtIdAlterar);
        txtIdAlterar.setBounds(140, 170, 110, 22);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Qual o id do agendamento que você quer alterar?");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 130, 280, 20);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Para qual data você quer alterar ?");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 210, 190, 30);
        getContentPane().add(txtAno);
        txtAno.setBounds(250, 270, 50, 22);
        getContentPane().add(txtDia);
        txtDia.setBounds(110, 270, 40, 22);
        getContentPane().add(txtMes);
        txtMes.setBounds(180, 270, 40, 22);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("aaaa");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(250, 250, 50, 16);

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("dd");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(110, 250, 40, 16);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("mm");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(180, 250, 37, 16);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("/");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(210, 260, 50, 40);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("/");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(140, 260, 50, 40);

        btnConcluir.setBackground(new java.awt.Color(19, 148, 205));
        btnConcluir.setForeground(new java.awt.Color(0, 0, 0));
        btnConcluir.setText("Concluido");
        btnConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnConcluir);
        btnConcluir.setBounds(320, 310, 90, 40);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/agenda.png"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 570, 430);

        setSize(new java.awt.Dimension(584, 435));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirActionPerformed

        try {
            String data;

            //Juntando a data
            data = txtDia.getText() + "/" + txtMes.getText() + "/" + txtAno.getText();

            if (data.isEmpty() || txtIdAlterar.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Você não preencheu um dos campos");
                return;
            }

            //Instanciando obj consulta
            Consulta consulta = new Consulta();
            SistemaDao dao = new SistemaDao();

            ResultSet resultado;

            //Setando o Id do agendamento
            consulta.setIdAgendamento(Integer.parseInt(txtIdAlterar.getText()));

            //Validando se existe
            consulta = dao.validarAgendamento(consulta);

            //Validando se existe o agendamento
            if (consulta != null) {

                //Setando a data nova
                consulta.setDataConsulta(data);

                //Alterando agendamento
                dao.alterarAgendamento(consulta);

                //Confirmando e fechando a tela
                JOptionPane.showMessageDialog(null, "Agendamento alterado para: " + consulta.getDataConsulta());
                dispose();

            } else {

                //Mensagem  caso não exista agendamento
                JOptionPane.showMessageDialog(null, "Agendamento não existe");
                return;
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_btnConcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtIdAlterar;
    private javax.swing.JTextField txtMes;
    // End of variables declaration//GEN-END:variables
}
