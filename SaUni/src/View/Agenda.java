package View;

import Dados.Consulta;
import Dados.Funcionario;
import Dados.Paciente;
import Dados.SistemaDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Agenda extends javax.swing.JFrame {

    boolean funcionario;
    int userId;

    public Agenda(boolean funcionario, int userId) {
        this.funcionario = funcionario;
        this.userId = userId;

        initComponents();
        validarPreencherAgenda();

        if (funcionario == true) {
            preencherCmb();
        }

    }

    private void preencherAgendaFuncionario() {
        try {
            //Busca todas as consultas
            SistemaDao dao;
            dao = new SistemaDao();
            ResultSet resultado = dao.listarAgenda();

            //3 - Carregar as consultas na tabela tblAgenda
            DefaultTableModel tblModelo;
            tblModelo = (DefaultTableModel) tblAgenda.getModel();
            tblModelo.setRowCount(0); //limpa a tabela

            //fazer até chegar no final da tabela (enquanto tiver próxima consulta)
            while (resultado.next()) {
                Object dados[] = {
                    resultado.getInt("idagendamento"),
                    resultado.getString("data_consulta"),
                    resultado.getString("paciente.nome"),
                    resultado.getString("funcionario.nome")
                };

                tblModelo.addRow(dados);
            }

            //Limpa os dois comboBox
            cmbPaciente.setSelectedItem(null);
            cmbMedico.setSelectedItem(null);

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void preencherAgendaPaciente() {
        try {
            //Busca todas as consultadas desse paciente
            SistemaDao dao;
            dao = new SistemaDao();

            //Instanciando objeto paciente
            Paciente paciente = new Paciente();

            //Setando o id do paciente
            paciente.setIdPaciente(userId);

            //Buscando todas as consultas desse paciente
            ResultSet resultado = dao.listarAgendaPaciente(paciente);

            //3 - Carregar as consultas na tabela tblConsultas
            DefaultTableModel tblModelo;
            tblModelo = (DefaultTableModel) tblAgenda.getModel();
            tblModelo.setRowCount(0); //limpa a tabela

            //fazer até chegar no final da tabela (enquanto tiver próxima consulta)
            while (resultado.next()) {
                Object dados[] = {
                    resultado.getInt("idagendamento"),
                    resultado.getString("data_consulta"),
                    resultado.getString("paciente.nome"),
                    resultado.getString("funcionario.nome")
                };

                tblModelo.addRow(dados);
            }

            //Limpa os dois comboBox
            cmbPaciente.setSelectedItem(null);
            cmbMedico.setSelectedItem(null);

            //padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAgenda = new javax.swing.JTable();
        btnAlterarAgenda = new javax.swing.JButton();
        btnAgendar = new javax.swing.JButton();
        btnDeletarAgenda = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        lblFiltrar = new javax.swing.JLabel();
        cmbPaciente = new javax.swing.JComboBox<>();
        btnSemFiltro = new javax.swing.JButton();
        cmbMedico = new javax.swing.JComboBox<>();
        btnFuncionario = new javax.swing.JButton();
        btnPaciente = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().setLayout(null);

        tblAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID da consulta", "Data", "Paciente", "Doutor"
            }
        ));
        jScrollPane3.setViewportView(tblAgenda);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(90, 180, 640, 402);

        btnAlterarAgenda.setText("Alterar data agendamento");
        btnAlterarAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarAgendaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterarAgenda);
        btnAlterarAgenda.setBounds(20, 20, 170, 30);

        btnAgendar.setText("Agendar consulta");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgendar);
        btnAgendar.setBounds(570, 70, 220, 30);

        btnDeletarAgenda.setText("Cancelar/deletar agendamento");
        btnDeletarAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarAgendaActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeletarAgenda);
        btnDeletarAgenda.setBounds(570, 20, 220, 30);

        btnAtualizar.setText("Atualizar agenda");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar);
        btnAtualizar.setBounds(20, 70, 170, 30);

        lblFiltrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFiltrar.setText("Filtrar por");
        getContentPane().add(lblFiltrar);
        lblFiltrar.setBounds(340, 10, 70, 16);

        getContentPane().add(cmbPaciente);
        cmbPaciente.setBounds(220, 110, 120, 20);

        btnSemFiltro.setText("Sem filtro");
        btnSemFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSemFiltroActionPerformed(evt);
            }
        });
        getContentPane().add(btnSemFiltro);
        btnSemFiltro.setBounds(310, 40, 140, 22);

        getContentPane().add(cmbMedico);
        cmbMedico.setBounds(440, 110, 120, 20);

        btnFuncionario.setText("Filtrar por funcionario");
        btnFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnFuncionario);
        btnFuncionario.setBounds(420, 140, 160, 22);

        btnPaciente.setText("Filtrar por paciente");
        btnPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnPaciente);
        btnPaciente.setBounds(200, 140, 160, 22);

        setSize(new java.awt.Dimension(857, 636));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarAgendaActionPerformed
        AlterarData ad = new AlterarData();
        ad.setVisible(true);
    }//GEN-LAST:event_btnAlterarAgendaActionPerformed

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        Agendar agendar = new Agendar();
        agendar.setVisible(true);
    }//GEN-LAST:event_btnAgendarActionPerformed

    private void btnDeletarAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarAgendaActionPerformed
        try {

            //Instanciando objetos
            SistemaDao dao = new SistemaDao();
            Consulta consulta = new Consulta();

            //id digitado
            String id;

            id = JOptionPane.showInputDialog(null, "Qual o id do agendamento que você quer cancelar?");
            if (id == null) {
                return;
            }

            //Setando o Id do agendamento
            consulta.setIdAgendamento(Integer.parseInt(id));

            //Validando se a consulta existe
            consulta = dao.validarAgendamento(consulta);
            if (consulta != null) {

                //Deletando e confirmando  que foi deletado
                dao.deletarAgendamento(consulta);
                JOptionPane.showMessageDialog(null, "Agendamento cancelado/deletado com sucesso!");

            } else {

                //Não existe esse agendamento
                JOptionPane.showMessageDialog(null, "ID de agendamento inválido");
                return;

            }

            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnDeletarAgendaActionPerformed

    private void validarPreencherAgenda() {
        //Se for funcionario
        if (funcionario == true) {
            preencherAgendaFuncionario();
            lblFiltrar.setVisible(true);
            btnSemFiltro.setVisible(true);
            cmbPaciente.setVisible(true);
            cmbMedico.setVisible(true);
            btnPaciente.setVisible(true);
            btnFuncionario.setVisible(true);
        } else {
            preencherAgendaPaciente();
            lblFiltrar.setVisible(false);
            btnSemFiltro.setVisible(false);
            cmbPaciente.setVisible(false);
            cmbMedico.setVisible(false);
            btnPaciente.setVisible(false);
            btnFuncionario.setVisible(false);
        }
    }

    private void preencherCmb() {
        try {
            //Busca todos os Medicos
            String nome;
            SistemaDao dao = new SistemaDao();
            ResultSet resultado = dao.listarMedicos();

            //Deixando o primeiro item vazio
            cmbMedico.addItem(null);

            //fazer até chegar no final da tabela (enquanto tiver próximo medico)
            while (resultado.next()) {
                nome = resultado.getString("nome");
                cmbMedico.addItem(nome);
            }

            //Pegando todos os pacientes
            resultado = dao.listarPaciente();

            //Deixando o primeiro item vazio
            cmbPaciente.addItem(null);

            //fazer até chegar no final da tabela (enquanto tiver próximo paciente)
            while (resultado.next()) {
                nome = resultado.getString("nome");
                cmbPaciente.addItem(nome);
            }

            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        validarPreencherAgenda();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnSemFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSemFiltroActionPerformed
        preencherAgendaFuncionario();
    }//GEN-LAST:event_btnSemFiltroActionPerformed

    private void btnFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionarioActionPerformed
        try {
            //Iniciando tudo
            String nomeFuncionario;
            SistemaDao dao = new SistemaDao();
            ResultSet resultado;

            //Analisando se o item do cmb não é vazio
            if (cmbMedico.getSelectedItem() == null) {
                return;
            }

            //Pegando o item selecionando do cmbSintoma
            nomeFuncionario = cmbMedico.getSelectedItem().toString();

            //Instanciando objeto sintoma
            Funcionario funcionario = new Funcionario();

            //Setando o nome do sintoma
            funcionario.setNome(nomeFuncionario);

            //3 - Carregar dados  da tabela
            DefaultTableModel tblModelo;
            tblModelo = (DefaultTableModel) tblAgenda.getModel();
            tblModelo.setRowCount(0); //limpa a tabela

            //Buscando a query usando  o filtro do nome do sintoma
            resultado = dao.listarAgendaFuncionarioPorNome(funcionario);

            //Se tiver achado preenche a tabela
            while (resultado.next()) {
                Object dados[] = {
                    resultado.getInt("idagendamento"),
                    resultado.getString("data_consulta"),
                    resultado.getString("paciente.nome"),
                    resultado.getString("funcionario.nome")};
                tblModelo.addRow(dados);
            }

            //Limpa o outro comboBox
            cmbPaciente.setSelectedItem(null);

            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnFuncionarioActionPerformed

    private void btnPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacienteActionPerformed
        try {
            //Iniciando tudo
            String nomePaciente;
            SistemaDao dao = new SistemaDao();
            ResultSet resultado;

            //Analisando se o item do cmb não é vazio
            if (cmbPaciente.getSelectedItem() == null) {
                return;
            }

            //Pegando o item selecionando do cmbSintoma
            nomePaciente = cmbPaciente.getSelectedItem().toString();

            //Instanciando objeto sintoma
            Paciente paciente = new Paciente();

            //Setando o nome do sintoma
            paciente.setNome(nomePaciente);

            //3 - Carregar dados  da tabela
            DefaultTableModel tblModelo;
            tblModelo = (DefaultTableModel) tblAgenda.getModel();
            tblModelo.setRowCount(0); //limpa a tabela

            //Buscando a query usando  o filtro do nome do sintoma
            resultado = dao.listarAgendaPacientePorNome(paciente);

            //Se tiver achado preenche a tabela
            while (resultado.next()) {
                Object dados[] = {
                    resultado.getInt("idagendamento"),
                    resultado.getString("data_consulta"),
                    resultado.getString("paciente.nome"),
                    resultado.getString("funcionario.nome")};
                tblModelo.addRow(dados);
            }

            //Limpa o outro comboBox
            cmbMedico.setSelectedItem(null);

            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnPacienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnAlterarAgenda;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnDeletarAgenda;
    private javax.swing.JButton btnFuncionario;
    private javax.swing.JButton btnPaciente;
    private javax.swing.JButton btnSemFiltro;
    private javax.swing.JComboBox<String> cmbMedico;
    private javax.swing.JComboBox<String> cmbPaciente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblFiltrar;
    private javax.swing.JTable tblAgenda;
    // End of variables declaration//GEN-END:variables
}
