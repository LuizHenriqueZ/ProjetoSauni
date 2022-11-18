package View;

import Dados.Consulta;
import Dados.Funcionario;
import Dados.Paciente;
import Dados.SistemaDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Agendar extends javax.swing.JFrame {

    public Agendar() {
        initComponents();
        preencherCmbMedicos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        cmbMedicos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();

        getContentPane().setLayout(null);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Para qual data você quer agendar ?");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 130, 190, 16);
        getContentPane().add(txtAno);
        txtAno.setBounds(230, 180, 50, 22);
        getContentPane().add(txtDia);
        txtDia.setBounds(90, 180, 40, 22);
        getContentPane().add(txtMes);
        txtMes.setBounds(160, 180, 40, 22);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("aaaa");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(230, 160, 50, 16);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("dd");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(90, 160, 40, 16);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("mm");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(160, 160, 37, 16);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("/");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(190, 170, 50, 40);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("/");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(120, 170, 50, 40);

        btnConcluir.setText("Concluido");
        btnConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnConcluir);
        btnConcluir.setBounds(255, 230, 90, 40);

        getContentPane().add(cmbMedicos);
        cmbMedicos.setBounds(200, 80, 110, 22);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Selecione um médico:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 80, 140, 20);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Digite seu CPF:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(60, 40, 130, 16);
        getContentPane().add(txtCPF);
        txtCPF.setBounds(200, 40, 110, 22);

        setSize(new java.awt.Dimension(416, 318));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirActionPerformed

        //Se nenhum medico for selecionado
        if (cmbMedicos.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Você não selecionou um médico");
            cmbMedicos.requestFocus();
            return;
        }

        try {
            String data;
            data = txtDia.getText() + "/" + txtMes.getText() + "/" + txtAno.getText();

            //Se data estiver vazia
            if (data.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Você não preencheu a data");
                return;
            }

            //Se não tiver selecionado medico
            if (cmbMedicos.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Você não selecionou um médico");
                return;
            }

            //Se não tiver digitado cpf
            if (txtCPF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Você não preencheu o cpf");
                return;
            }
            //Procedimento padrão
            SistemaDao dao = new SistemaDao();

            //Instanciando os objetos
            Consulta consulta = new Consulta();
            Paciente paciente = new Paciente();
            Funcionario funcionario = new Funcionario();

            //Setando CPF  do paciente
            paciente.setCpf(txtCPF.getText());

            //Setando a data da consulta
            consulta.setDataConsulta(data);

            //Setando o nome do médico
            funcionario.setNome(cmbMedicos.getSelectedItem().toString());

            //Pegando as informações do paciente
            paciente = dao.validarPacienteApenasCpf(paciente);

            //Se o cpf for verdadeiro
            if (paciente.getCpf() != null) {

                //Achando o funcionario e setando todas os campos dele
                funcionario = dao.filtrarFuncionarioPorNome(funcionario);

                //Se não tiver dado nada de errado
                if (funcionario != null) {

                    //Setando o idpaciente e idfuncionario no obj consulta
                    consulta.setIdPaciente(paciente.getIdPaciente());
                    consulta.setIdFuncionario(funcionario.getIdFuncionario());

                    //Agendar consulta
                    dao.agendarConsulta(consulta);

                    //Confirmação que tudo ocorreu bem e fechando a tela
                    JOptionPane.showMessageDialog(null, "Consulta agendada com sucesso!");
                    dispose();

                } else {

                    JOptionPane.showMessageDialog(null, "Funcionario não existe!");
                    return;
                }

            } else {

                JOptionPane.showMessageDialog(null, "Esse CPF não existe");
                return;

            }

            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }


    }//GEN-LAST:event_btnConcluirActionPerformed

    private void preencherCmbMedicos() {
        try {
            //Busca todos os usuários
            String nome;
            SistemaDao dao;
            dao = new SistemaDao();
            ResultSet resultado = dao.listarMedicos();

            //Deixando o primeiro item vazio
            cmbMedicos.addItem(null);

            //fazer até chegar no final da tabela (enquanto tiver próximo usuário)
            while (resultado.next()) {
                nome = resultado.getString("nome");
                cmbMedicos.addItem(nome);
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConcluir;
    private javax.swing.JComboBox<String> cmbMedicos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtMes;
    // End of variables declaration//GEN-END:variables
}
