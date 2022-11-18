package View;

import Dados.Doenca;
import Dados.Sintoma;
import Dados.SistemaDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TesteDoenca extends javax.swing.JFrame {

    public TesteDoenca() {
        initComponents();
        preencherTabela();
        preencherCmbSintomasDoencas();

    }

    private void preencherTabela() {
        try {
            //Busca todos os Relacionamento D/S
            SistemaDao dao;
            dao = new SistemaDao();
            ResultSet resultado;

            resultado = dao.listarDoencasSintomas();

            //3 - Carregar os relacionamento D/S na tabela tblDoenca
            DefaultTableModel tblModelo;
            tblModelo = (DefaultTableModel) tblDoenca.getModel();
            tblModelo.setRowCount(0); //limpa a tabela

            //fazer até chegar no final da tabela (enquanto tiver próximo relacionamento D/S)
            while (resultado.next()) {
                Object dados[] = {
                    resultado.getString("nomedoenca"),
                    resultado.getString("nomesintoma"),};
                tblModelo.addRow(dados);
            }

            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void preencherCmbSintomasDoencas() {
        try {
            //Busca todos os sintomas
            String nome;
            SistemaDao dao = new SistemaDao();
            ResultSet resultado = dao.listarSintomas();

            //Deixando o primeiro item vazio
            cmbSintoma.addItem(null);

            //fazer até chegar no final da tabela (enquanto tiver próximo sintoma)
            while (resultado.next()) {
                nome = resultado.getString("nomesintoma");
                cmbSintoma.addItem(nome);
            }

            //Pegando todos as doenças
            resultado = dao.listarDoencas();

            //Deixando o primeiro item vazio
            cmbDoenca.addItem(null);

            //fazer até chegar no final da tabela (enquanto tiver próxima doença)
            while (resultado.next()) {
                nome = resultado.getString("nomedoenca");
                cmbDoenca.addItem(nome);
            }

            //Padrão
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
        tblDoenca = new javax.swing.JTable();
        cmbSintoma = new javax.swing.JComboBox<>();
        btnSintoma = new javax.swing.JButton();
        cmbDoenca = new javax.swing.JComboBox<>();
        btnDoenca = new javax.swing.JButton();
        btnSemFiltro = new javax.swing.JButton();

        getContentPane().setLayout(null);

        tblDoenca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doença", "Sintoma"
            }
        ));
        jScrollPane1.setViewportView(tblDoenca);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 130, 560, 275);

        getContentPane().add(cmbSintoma);
        cmbSintoma.setBounds(50, 40, 110, 30);

        btnSintoma.setText("Filtrar por sintoma");
        btnSintoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSintomaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSintoma);
        btnSintoma.setBounds(40, 90, 140, 22);

        getContentPane().add(cmbDoenca);
        cmbDoenca.setBounds(440, 40, 110, 30);

        btnDoenca.setText("Filtrar por doença");
        btnDoenca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoencaActionPerformed(evt);
            }
        });
        getContentPane().add(btnDoenca);
        btnDoenca.setBounds(430, 90, 140, 22);

        btnSemFiltro.setText("Sem filtro");
        btnSemFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSemFiltroActionPerformed(evt);
            }
        });
        getContentPane().add(btnSemFiltro);
        btnSemFiltro.setBounds(230, 90, 140, 22);

        setSize(new java.awt.Dimension(631, 465));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSintomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSintomaActionPerformed
        try {

            //Iniciando tudo
            String nomeSintoma;
            SistemaDao dao = new SistemaDao();
            ResultSet resultado;

            //Pegando o item selecionando do cmbSintoma
            nomeSintoma = cmbSintoma.getSelectedItem().toString();

            //Analisando se o item do cmb não é vazio
            if (cmbSintoma.getSelectedItem() == null) {
                return;
            }

            //Instanciando objeto sintoma
            Sintoma sintoma = new Sintoma();

            //Setando o nome do sintoma
            sintoma.setNomeSintoma(nomeSintoma);

            //3 - Carregar dados  da tabela
            DefaultTableModel tblModelo;
            tblModelo = (DefaultTableModel) tblDoenca.getModel();
            tblModelo.setRowCount(0); //limpa a tabela

            //Buscando a query usando  o filtro do nome do sintoma
            resultado = dao.listarDoencasPorSintoma(sintoma);

            //Se tiver achado preenche a tabela
            while (resultado.next()) {
                Object dados[] = {
                    resultado.getString("nomedoenca"),
                    resultado.getString("nomesintoma"),};
                tblModelo.addRow(dados);
            }

            //Limpa o outro comboBox
            cmbDoenca.setSelectedIndex(0);

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnSintomaActionPerformed

    private void btnDoencaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoencaActionPerformed
        try {
            //Padrão
            String nomeDoenca;
            SistemaDao dao = new SistemaDao();
            ResultSet resultado;

            //Pegando o conteu do cmb 
            nomeDoenca = cmbDoenca.getSelectedItem().toString();

            //Analisando quantos combo box estão com filtro
            if (cmbDoenca.getSelectedItem() == null) {
                return;
            }

            //instanciando objeto doenca     
            Doenca doenca = new Doenca();

            //Setando nome no objeto
            doenca.setNomeDoenca(nomeDoenca);

            //3 - Carregar os usuários na tabela tblUsuarios
            DefaultTableModel tblModelo;
            tblModelo = (DefaultTableModel) tblDoenca.getModel();
            tblModelo.setRowCount(0); //limpa a tabela

            //Listando os sintomas
            resultado = dao.listarSintomasPorDoenca(doenca);

            //Enquanto existir
            while (resultado.next()) {
                Object dados[] = {
                    resultado.getString("nomedoenca"),
                    resultado.getString("nomesintoma"),};
                tblModelo.addRow(dados);
            }

            //Limpando o cmbSintoma
            cmbSintoma.setSelectedIndex(0);

            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnDoencaActionPerformed

    private void btnSemFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSemFiltroActionPerformed
        try {
            //Padrão
            SistemaDao dao = new SistemaDao();
            ResultSet resultado;

            //3 - Carregar os relacionamento D/S na tabela tblDoenca
            DefaultTableModel tblModelo;
            tblModelo = (DefaultTableModel) tblDoenca.getModel();
            tblModelo.setRowCount(0); //limpa a tabela

            //Listando os relacionamentos D/S
            resultado = dao.listarDoencasSintomas();
            while (resultado.next()) {
                Object dados[] = {
                    resultado.getString("nomedoenca"),
                    resultado.getString("nomesintoma"),};
                tblModelo.addRow(dados);
            }

            //Limpando os cmb
            cmbSintoma.setSelectedIndex(0);
            cmbDoenca.setSelectedIndex(0);

            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnSemFiltroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoenca;
    private javax.swing.JButton btnSemFiltro;
    private javax.swing.JButton btnSintoma;
    private javax.swing.JComboBox<String> cmbDoenca;
    private javax.swing.JComboBox<String> cmbSintoma;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDoenca;
    // End of variables declaration//GEN-END:variables
}
