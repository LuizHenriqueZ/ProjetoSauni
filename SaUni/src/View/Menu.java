package View;

import Dados.Funcionario;

public class Menu extends javax.swing.JFrame {

    private String cargo;
    private boolean funcionario;
    private int userId;

    //Metodo construtor
    public Menu(boolean funcionario, int userId, String cargo) {
        initComponents();

        //Atribuindo valores a variavel global
        this.funcionario = funcionario;
        this.userId = userId;
        this.cargo = cargo;

        //Chamando função
        definirAcesso();
    }

    //Definindo o nível de acesso do usuário
    private void definirAcesso() {
        //Se for funcionario
        if (funcionario == true) {

            //Habilita esse botão e desabilita o menu de administrador
            btnListaDoencas.setVisible(true);
            mnuAdmin.setVisible(false);

            //Se for Administrador
            if (cargo.equalsIgnoreCase("Administrador")) {

                //Habilita o menu de administrador
                mnuAdmin.setVisible(true);

            }

        } else {

            //Se nem funcionário for não habilita esses botões
            mnuAdmin.setVisible(false);
            btnListaDoencas.setVisible(false);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTeste = new javax.swing.JButton();
        btnAlterarDadosC = new javax.swing.JButton();
        btnListaDoencas = new javax.swing.JButton();
        btnAgenda = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuAdmin = new javax.swing.JMenu();
        itmAddFuncionario = new javax.swing.JMenuItem();
        itmDelFuncionario = new javax.swing.JMenuItem();

        getContentPane().setLayout(null);

        btnTeste.setText("Fazer teste");
        btnTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTesteActionPerformed(evt);
            }
        });
        getContentPane().add(btnTeste);
        btnTeste.setBounds(40, 40, 120, 40);

        btnAlterarDadosC.setText("Alterar dados cadastrais");
        btnAlterarDadosC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarDadosCActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterarDadosC);
        btnAlterarDadosC.setBounds(40, 200, 180, 60);

        btnListaDoencas.setText("Lista de doenças");
        btnListaDoencas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaDoencasActionPerformed(evt);
            }
        });
        getContentPane().add(btnListaDoencas);
        btnListaDoencas.setBounds(40, 140, 150, 40);

        btnAgenda.setText("Agenda");
        btnAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgenda);
        btnAgenda.setBounds(40, 90, 120, 40);

        mnuAdmin.setText("Admin");

        itmAddFuncionario.setText("Adicionar funcionário");
        itmAddFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmAddFuncionarioActionPerformed(evt);
            }
        });
        mnuAdmin.add(itmAddFuncionario);

        itmDelFuncionario.setText("Deletar");
        itmDelFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmDelFuncionarioActionPerformed(evt);
            }
        });
        mnuAdmin.add(itmDelFuncionario);

        jMenuBar1.add(mnuAdmin);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(416, 361));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Abrindo tela da lista dos dados das doenças
    private void btnListaDoencasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaDoencasActionPerformed
        DadosDoencas dds = new DadosDoencas();
        dds.setVisible(true);
    }//GEN-LAST:event_btnListaDoencasActionPerformed

    //Abrindo tela do teste de doenças
    private void btnTesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTesteActionPerformed
        TesteDoenca td = new TesteDoenca();
        td.setVisible(true);
    }//GEN-LAST:event_btnTesteActionPerformed

    //Abrindo a tela da agenda
    private void btnAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendaActionPerformed
        Agenda agenda = new Agenda(funcionario, userId);
        agenda.setVisible(true);
    }//GEN-LAST:event_btnAgendaActionPerformed

    //Abrinda a tela de alteração dos dados
    private void btnAlterarDadosCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarDadosCActionPerformed
        AlterarDados ad = new AlterarDados(funcionario, userId);
        ad.setVisible(true);
    }//GEN-LAST:event_btnAlterarDadosCActionPerformed

    //Abrindo tela de adicionar funcionários
    private void itmAddFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAddFuncionarioActionPerformed
        TelaUsuario tu = new TelaUsuario(true);
        tu.setVisible(true);
    }//GEN-LAST:event_itmAddFuncionarioActionPerformed

    //Abrindo tela para deletar funcionarios
    private void itmDelFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmDelFuncionarioActionPerformed
        TelaUsuario tu = new TelaUsuario(false);
        tu.setVisible(true);
    }//GEN-LAST:event_itmDelFuncionarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgenda;
    private javax.swing.JButton btnAlterarDadosC;
    private javax.swing.JButton btnListaDoencas;
    private javax.swing.JButton btnTeste;
    private javax.swing.JMenuItem itmAddFuncionario;
    private javax.swing.JMenuItem itmDelFuncionario;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnuAdmin;
    // End of variables declaration//GEN-END:variables
}
