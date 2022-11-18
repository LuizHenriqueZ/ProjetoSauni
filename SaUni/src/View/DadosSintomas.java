package View;

import Dados.Doenca;
import Dados.Sintoma;
import Dados.SistemaDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DadosSintomas extends javax.swing.JFrame {

    //Definindo qual tabela vai aparecer (0 - sintomas) e (1 - doenças)
    private int qualTabela = 0;

    public DadosSintomas() {
        initComponents();
        preencherTabelaSintomas();
        btnListaSintoma.setVisible(false);
        txtTabela.setText("Tabela De Sintomas");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAtualizar = new javax.swing.JButton();
        btnAddSintoma = new javax.swing.JButton();
        btnDelSintoma = new javax.swing.JButton();
        btnDelSintomaDoenca = new javax.swing.JButton();
        btnAddSintomaDoenca = new javax.swing.JButton();
        btnListaDoenca = new javax.swing.JButton();
        btnListaSintoma = new javax.swing.JButton();
        btnExcluirDoenca = new javax.swing.JButton();
        btnAdicionarDoenca = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSintoma = new javax.swing.JTable();
        txtTabela = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar);
        btnAtualizar.setBounds(40, 470, 90, 22);

        btnAddSintoma.setText("Adicionar sintoma");
        btnAddSintoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSintomaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddSintoma);
        btnAddSintoma.setBounds(70, 20, 140, 22);

        btnDelSintoma.setText("Deletar sintoma");
        btnDelSintoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelSintomaActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelSintoma);
        btnDelSintoma.setBounds(70, 50, 140, 22);

        btnDelSintomaDoenca.setText("Remover sintoma de uma doença");
        btnDelSintomaDoenca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelSintomaDoencaActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelSintomaDoenca);
        btnDelSintomaDoenca.setBounds(30, 120, 230, 22);

        btnAddSintomaDoenca.setText("Adicionar sintoma a uma doença");
        btnAddSintomaDoenca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSintomaDoencaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddSintomaDoenca);
        btnAddSintomaDoenca.setBounds(30, 90, 230, 22);

        btnListaDoenca.setText("Lista doenças");
        btnListaDoenca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaDoencaActionPerformed(evt);
            }
        });
        getContentPane().add(btnListaDoenca);
        btnListaDoenca.setBounds(160, 470, 130, 22);

        btnListaSintoma.setText("Lista sintomas");
        btnListaSintoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaSintomaActionPerformed(evt);
            }
        });
        getContentPane().add(btnListaSintoma);
        btnListaSintoma.setBounds(160, 470, 130, 22);

        btnExcluirDoenca.setText("Excluir Doença da lista");
        btnExcluirDoenca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirDoencaActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluirDoenca);
        btnExcluirDoenca.setBounds(50, 210, 170, 22);

        btnAdicionarDoenca.setText("Adicionar Doença a lista");
        btnAdicionarDoenca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarDoencaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionarDoenca);
        btnAdicionarDoenca.setBounds(50, 170, 170, 22);

        tblSintoma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblSintoma);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(360, 30, 290, 470);

        txtTabela.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(txtTabela);
        txtTabela.setBounds(367, 10, 280, 20);

        setSize(new java.awt.Dimension(783, 560));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        if (qualTabela == 0) {
            preencherTabelaSintomas();
        } else {
            preencherTabelaDoencas();
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnAddSintomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSintomaActionPerformed
        try {
            //Criando variaveis e questionando o nome do sintoma
            String nome;
            SistemaDao dao = new SistemaDao();
            Sintoma sintoma = new Sintoma();
            nome = JOptionPane.showInputDialog(null, "Qual é o sintoma?");

            //Se apertar o botão de cancelar
            if (nome == null) {
                return;//Para o script
            }

            //Se não for digitado nenhum nome
            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não é  possível deixar o campo em branco");
                return;//Para o script
            }

            //Setando nome no obj sintoma
            sintoma.setNomeSintoma(nome);

            //Cumpriu os requisitos
            dao.adicionarSintoma(sintoma);

            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnAddSintomaActionPerformed

    private void btnDelSintomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelSintomaActionPerformed
        try {
            //Criando variaveis
            String id;
            SistemaDao dao = new SistemaDao();

            //Perguntando o id do sintoma que será deletado
            id = JOptionPane.showInputDialog(null, "Digite o ID do sintoma que você quer deletar");

            //Caso seja pressionado o botão de cancelar
            if (id == null) {
                return;
            }

            //Instanciando objeto sintoma
            Sintoma sintoma = new Sintoma();

            //Setando id informado
            sintoma.setIdSintoma(Integer.parseInt(id));

            //Verificando se sintoma existe e setando informações no objeto
            sintoma = dao.validarSintoma(sintoma);

            //Se o sintoma existir
            if (sintoma != null) {

                //Excluindo o sintoma e confirmando
                dao.excluirSintoma(sintoma);
                JOptionPane.showMessageDialog(null, "Sintoma excluido com sucesso");

            } else {
                //Caso sintoma não exista
                JOptionPane.showMessageDialog(null, "Sintoma não existe");
            }

            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnDelSintomaActionPerformed

    private void btnAddSintomaDoencaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSintomaDoencaActionPerformed
        try {
            //Iniciando variaveis
            String idDoenca, idSintoma;
            SistemaDao dao = new SistemaDao();

            //Perguntando nome da doença
            idDoenca = JOptionPane.showInputDialog("Qual o id da doença ?");

            //Se tiver apertado o botão de cancelar
            if (idDoenca == null) {
                return; //Parando script
            }

            //Instanciando obj doença
            Doenca doenca = new Doenca();

            //Setando o id da doença no objeto
            doenca.setIdDoenca(Integer.parseInt(idDoenca));

            //Validando se a doença existe
            doenca = dao.validarDoenca(doenca);

            if (doenca != null) { //Se sim

                //Questionando o id do sintoma
                idSintoma = JOptionPane.showInputDialog("Qual o id do sintoma ?");

                //Se tiver cancelado o JOptionPane
                if (idSintoma == null) {
                    return; //Para o script
                }

                //Instanciando o obj sintoma
                Sintoma sintoma = new Sintoma();

                //Setando o id no obj
                sintoma.setIdSintoma(Integer.parseInt(idSintoma));

                //Validando existencia do sintoma
                sintoma = dao.validarSintoma(sintoma);

                //Se o sintoma existir
                if (sintoma != null) {

                    //Criando o relacionamento e confirmando
                    dao.adicionarRelacionamentoDS(doenca, sintoma);
                    JOptionPane.showMessageDialog(null, "Sintoma vinculado com sucesso");

                } else {
                    //Se o sintoma não existir
                    JOptionPane.showMessageDialog(null, "Esse id de sintoma não existe");
                }

            } else {
                //Se a doença não existir
                JOptionPane.showMessageDialog(null, "Esse id de doença não existe");
            }

            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }


    }//GEN-LAST:event_btnAddSintomaDoencaActionPerformed

    private void btnDelSintomaDoencaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelSintomaDoencaActionPerformed
        try {
            String idDoenca, idSintoma;
            SistemaDao dao = new SistemaDao();

            //Pegando o id da doença
            idDoenca = JOptionPane.showInputDialog("Qual o id da doença ?");

            //Se for cancelado
            if (idDoenca == null) {
                return;
            }

            //Instanciando objeto doença
            Doenca doenca = new Doenca();

            //Setando id no objeto
            doenca.setIdDoenca(Integer.parseInt(idDoenca));

            //Pegando todas as informações sobre a doeça com esse id
            doenca = dao.validarDoenca(doenca);

            //Se tiver achado a doença
            if (doenca != null) {

                //Pegando o id do sintoma
                idSintoma = JOptionPane.showInputDialog("Qual o id do sintoma ?");

                //Se tiver cancelado a operação
                if (idSintoma == null) {
                    return;// Parar Script
                }
                //Instanciando obj sintoma
                Sintoma sintoma = new Sintoma();

                //Setando id no objeto sintoma
                sintoma.setIdSintoma(Integer.parseInt(idSintoma));

                //Validando e pegando todas as informações do sintoma com  esse id
                sintoma = dao.validarSintoma(sintoma);

                //Verificando se o sintoma existe
                if (sintoma != null) {

                    //Se sim o sintoma vai ser removido e aparecerá a confirmação
                    dao.removerRelacionamentoDS(doenca, sintoma);
                    JOptionPane.showMessageDialog(null, "Sintoma desvinculado com sucesso");

                } else {
                    //Se o sintoma não existir
                    JOptionPane.showMessageDialog(null, "Esse id de sintoma não existe");
                }

            } else {
                //Se a doença não existe
                JOptionPane.showMessageDialog(null, "Esse id de doença não existe");
            }
            //padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnDelSintomaDoencaActionPerformed

    private void btnListaDoencaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaDoencaActionPerformed
        preencherTabelaDoencas();
        btnListaDoenca.setVisible(false);
        btnListaSintoma.setVisible(true);
        txtTabela.setText("Tabela De Doenças");

    }//GEN-LAST:event_btnListaDoencaActionPerformed

    private void btnListaSintomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaSintomaActionPerformed
        preencherTabelaSintomas();
        btnListaSintoma.setVisible(false);        
        btnListaDoenca.setVisible(true);
        txtTabela.setText("Tabela De Sintomas");
    }//GEN-LAST:event_btnListaSintomaActionPerformed

    private void btnExcluirDoencaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirDoencaActionPerformed
        //Variavel para receber o JOptionPane
        String idDoenca;

        //Pegando o id da doença
        idDoenca = JOptionPane.showInputDialog(null, "Qual o id da doença que deseja excluir?");

        //Se operação for cancelada
        if (idDoenca == null) {
            return;//Parar script
        }

        try {
            SistemaDao dao = new SistemaDao();

            //Instanciando obj doença
            Doenca doenca = new Doenca();

            //Setando id no obj
            doenca.setIdDoenca(Integer.parseInt(idDoenca));

            //Excluindo doença e confirmando
            dao.excluirDoenca(doenca);
            JOptionPane.showMessageDialog(null, "Doença excluida");

            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_btnExcluirDoencaActionPerformed

    private void btnAdicionarDoencaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarDoencaActionPerformed
        try {
            //Conectar ao bd e criando uma variavel para receber o JOptionPane
            SistemaDao dao = new SistemaDao();
            String nome;

            //Perguntar nome doença
            nome = JOptionPane.showInputDialog(null, "Qual o nome da doença que você quer adicionar a lista?");

            //Se operação for cancelada
            if (nome == null) {
                return;//Parar script
            }

            if (nome.isEmpty()) {
                // Se for vazio dá erro
                JOptionPane.showMessageDialog(null, "É necessário identificar a doença por um nome");

            } else {
                //Instanciando objeto doença
                Doenca doenca = new Doenca();

                //Setando o nome da doença
                doenca.setNomeDoenca(nome);

                //Adicionando na tabela doenca e confirmando
                dao.adicionarDoenca(doenca);
                JOptionPane.showMessageDialog(null, "Doença adicionada com sucesso");

            }
            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnAdicionarDoencaActionPerformed

    private void preencherTabelaDoencas() {
        try {
            //Busca todas as doenças
            SistemaDao dao = new SistemaDao();
            ResultSet resultado = dao.listarDoencas();

            //Define que a tabela que deverá aparecer é a tabela doença
            qualTabela = 1;

            //3 - Carregar as doenças na tblSintoma - é a mesma tabela dos sintomas, só muda os dados
            DefaultTableModel tblModelo;
            tblModelo = (DefaultTableModel) tblSintoma.getModel();
            tblModelo.setRowCount(0); //limpa a tabela

            //fazer até chegar no final da tabela (enquanto tiver próxima doença)
            while (resultado.next()) {
                Object dados[] = {
                    resultado.getString("iddoenca"),
                    resultado.getString("nomedoenca")};
                tblModelo.addRow(dados);
            }
            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void preencherTabelaSintomas() {
        try {
            //Busca todos os sintomas
            SistemaDao dao = new SistemaDao();
            ResultSet resultado = dao.listarSintomas();

            //Tabela de sintomas tem o valor 0
            qualTabela = 0;

            //3 - Carregar os sintomas na tabela tblSintoma
            DefaultTableModel tblModelo;
            tblModelo = (DefaultTableModel) tblSintoma.getModel();
            tblModelo.setRowCount(0); //limpa a tabela

            //fazer até chegar no final da tabela (enquanto tiver próximo usuário)
            while (resultado.next()) {
                Object dados[] = {
                    resultado.getString("idsintoma"),
                    resultado.getString("nomesintoma")};
                tblModelo.addRow(dados);
            }

            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSintoma;
    private javax.swing.JButton btnAddSintomaDoenca;
    private javax.swing.JButton btnAdicionarDoenca;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnDelSintoma;
    private javax.swing.JButton btnDelSintomaDoenca;
    private javax.swing.JButton btnExcluirDoenca;
    private javax.swing.JButton btnListaDoenca;
    private javax.swing.JButton btnListaSintoma;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblSintoma;
    private javax.swing.JLabel txtTabela;
    // End of variables declaration//GEN-END:variables
}
