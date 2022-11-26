package View;

import Dados.SistemaDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DadosDoencas extends javax.swing.JFrame {

    public DadosDoencas() {
        initComponents();
        preencherTabela();
    }

    private void preencherTabela() {
        try {
            //Busca todos os relacionamento de doença e sintoma
            SistemaDao dao;
            dao = new SistemaDao();
            ResultSet resultado = dao.listarDoencasSintomas();

            //3 - Carregar os relacionamento d/s na tabela tblDoenca
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAltSintomas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoenca = new javax.swing.JTable();
        btnAtualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setResizable(false);
        getContentPane().setLayout(null);

        btnAltSintomas.setBackground(new java.awt.Color(19, 148, 205));
        btnAltSintomas.setForeground(new java.awt.Color(0, 0, 0));
        btnAltSintomas.setText("Adicionar/Alterar sintomas e doenças");
        btnAltSintomas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltSintomasActionPerformed(evt);
            }
        });
        getContentPane().add(btnAltSintomas);
        btnAltSintomas.setBounds(40, 100, 240, 30);

        tblDoenca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doença", "Sintoma"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDoenca);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 140, 570, 350);

        btnAtualizar.setBackground(new java.awt.Color(19, 148, 205));
        btnAtualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar);
        btnAtualizar.setBounds(440, 100, 120, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/dados doenca .png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 630, 520);

        setSize(new java.awt.Dimension(641, 526));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        preencherTabela();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnAltSintomasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltSintomasActionPerformed
        DadosSintomas ds = new DadosSintomas();
        ds.setVisible(true);
    }//GEN-LAST:event_btnAltSintomasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAltSintomas;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDoenca;
    // End of variables declaration//GEN-END:variables
}
