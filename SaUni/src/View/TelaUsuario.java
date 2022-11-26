package View;

import Dados.Funcionario;
import Dados.SistemaDao;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class TelaUsuario extends javax.swing.JFrame {

    public TelaUsuario(boolean adicionar) {
        initComponents();

        if (adicionar == true) {
            telaAdicionar();
        } else {
            preencherIdFuncionario();
            telaExcluir();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        cmbSexo = new javax.swing.JComboBox<>();
        txtCpf = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        txtTelefone = new javax.swing.JTextField();
        lblCargo = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        txtCargo = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCargoExcluir = new javax.swing.JTextField();
        lblCargoExcluir = new javax.swing.JLabel();
        lblEmailExcluir = new javax.swing.JLabel();
        txtEmailExcluir = new javax.swing.JTextField();
        txtCpfExcluir = new javax.swing.JTextField();
        lblCpfExcluir = new javax.swing.JLabel();
        lblNomeExcluir = new javax.swing.JLabel();
        txtNomeExcluir = new javax.swing.JTextField();
        cmbIdFuncionario = new javax.swing.JComboBox<>();
        lblIDFunc = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setResizable(false);
        getContentPane().setLayout(null);

        lblUsuario.setForeground(new java.awt.Color(0, 0, 0));
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsuario.setText("Usuario:");
        getContentPane().add(lblUsuario);
        lblUsuario.setBounds(480, 140, 110, 20);

        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Masculino", "Feminino", "Outro" }));
        getContentPane().add(cmbSexo);
        cmbSexo.setBounds(610, 230, 140, 22);
        getContentPane().add(txtCpf);
        txtCpf.setBounds(610, 200, 140, 22);
        getContentPane().add(txtEmail);
        txtEmail.setBounds(610, 290, 140, 22);

        lblEmail.setForeground(new java.awt.Color(0, 0, 0));
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmail.setText("Email:");
        getContentPane().add(lblEmail);
        lblEmail.setBounds(480, 290, 110, 20);
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(610, 140, 140, 22);

        lblTelefone.setForeground(new java.awt.Color(0, 0, 0));
        lblTelefone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTelefone.setText("Telefone:");
        getContentPane().add(lblTelefone);
        lblTelefone.setBounds(480, 260, 110, 20);

        btnAdicionar.setBackground(new java.awt.Color(19, 148, 205));
        btnAdicionar.setForeground(new java.awt.Color(0, 0, 0));
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionar);
        btnAdicionar.setBounds(630, 370, 90, 40);
        getContentPane().add(txtTelefone);
        txtTelefone.setBounds(610, 260, 140, 22);

        lblCargo.setForeground(new java.awt.Color(0, 0, 0));
        lblCargo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCargo.setText("Cargo:");
        getContentPane().add(lblCargo);
        lblCargo.setBounds(480, 320, 110, 20);

        lblCPF.setForeground(new java.awt.Color(0, 0, 0));
        lblCPF.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCPF.setText("CPF:");
        getContentPane().add(lblCPF);
        lblCPF.setBounds(480, 200, 110, 20);

        lblSexo.setForeground(new java.awt.Color(0, 0, 0));
        lblSexo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSexo.setText("Sexo:");
        getContentPane().add(lblSexo);
        lblSexo.setBounds(480, 230, 110, 20);
        getContentPane().add(txtSenha);
        txtSenha.setBounds(610, 170, 140, 22);
        getContentPane().add(txtCargo);
        txtCargo.setBounds(610, 320, 140, 22);

        lblSenha.setForeground(new java.awt.Color(0, 0, 0));
        lblSenha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSenha.setText("Senha:");
        getContentPane().add(lblSenha);
        lblSenha.setBounds(480, 170, 110, 20);

        lblNome.setForeground(new java.awt.Color(0, 0, 0));
        lblNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNome.setText("Nome:");
        getContentPane().add(lblNome);
        lblNome.setBounds(480, 110, 110, 20);
        getContentPane().add(txtNome);
        txtNome.setBounds(610, 110, 140, 22);

        txtCargoExcluir.setEditable(false);
        getContentPane().add(txtCargoExcluir);
        txtCargoExcluir.setBounds(130, 290, 160, 30);

        lblCargoExcluir.setForeground(new java.awt.Color(0, 0, 0));
        lblCargoExcluir.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCargoExcluir.setText("Cargo:");
        getContentPane().add(lblCargoExcluir);
        lblCargoExcluir.setBounds(-20, 290, 140, 30);

        lblEmailExcluir.setForeground(new java.awt.Color(0, 0, 0));
        lblEmailExcluir.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmailExcluir.setText("Email:");
        getContentPane().add(lblEmailExcluir);
        lblEmailExcluir.setBounds(-20, 250, 140, 30);

        txtEmailExcluir.setEditable(false);
        getContentPane().add(txtEmailExcluir);
        txtEmailExcluir.setBounds(130, 250, 160, 30);

        txtCpfExcluir.setEditable(false);
        getContentPane().add(txtCpfExcluir);
        txtCpfExcluir.setBounds(130, 210, 160, 30);

        lblCpfExcluir.setForeground(new java.awt.Color(0, 0, 0));
        lblCpfExcluir.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCpfExcluir.setText("CPF:");
        getContentPane().add(lblCpfExcluir);
        lblCpfExcluir.setBounds(-20, 210, 140, 30);

        lblNomeExcluir.setForeground(new java.awt.Color(0, 0, 0));
        lblNomeExcluir.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNomeExcluir.setText("Nome:");
        getContentPane().add(lblNomeExcluir);
        lblNomeExcluir.setBounds(-20, 170, 140, 30);

        txtNomeExcluir.setEditable(false);
        getContentPane().add(txtNomeExcluir);
        txtNomeExcluir.setBounds(130, 170, 160, 30);

        cmbIdFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIdFuncionarioActionPerformed(evt);
            }
        });
        getContentPane().add(cmbIdFuncionario);
        cmbIdFuncionario.setBounds(130, 130, 160, 30);

        lblIDFunc.setForeground(new java.awt.Color(0, 0, 0));
        lblIDFunc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIDFunc.setText("ID do funcionário:");
        getContentPane().add(lblIDFunc);
        lblIDFunc.setBounds(20, 130, 110, 30);

        btnExcluir.setBackground(new java.awt.Color(19, 148, 205));
        btnExcluir.setForeground(new java.awt.Color(0, 0, 0));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir);
        btnExcluir.setBounds(160, 360, 90, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/tela usuario .png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 794, 490);

        setSize(new java.awt.Dimension(809, 498));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed

        Funcionario funcionario = new Funcionario();

        try {
            SistemaDao dao = new SistemaDao();

            //Recebendo os valores dos txt no objeto funcionario
            funcionario.setNome(txtNome.getText());
            funcionario.setUsuario(txtUsuario.getText());
            funcionario.setSenha(txtSenha.getText());
            funcionario.setCpf(txtCpf.getText());
            funcionario.setSexo(cmbSexo.getSelectedItem().toString());
            funcionario.setTelefone(txtTelefone.getText());
            funcionario.setEmail(txtEmail.getText());
            funcionario.setCargo(txtCargo.getText());

            //Vendo se nenhum campo obrigatório ficou vazio
            if (funcionario.getNome().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo nome deve ser preenchido!");
                return;
            }

            if (funcionario.getUsuario().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo usuario deve ser preenchido!");
                return;
            }

            if (funcionario.getSenha().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo senha deve ser preenchido!");
                return;
            }

            if (funcionario.getCpf().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo CPF deve ser preenchido!");
                return;
            }

            if (funcionario.getSexo().equals("")) {
                JOptionPane.showMessageDialog(null, "O campo sexo deve ser preenchido!");
                return;
            }

            if (funcionario.getEmail().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo email deve ser preenchido!");
                return;
            }

            if (funcionario.getCargo().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo cargo deve ser preenchido!");
                return;
            }

            //Cadastrando funcionario
            dao.cadastrarFuncionario(funcionario);

            //Confirmando que foi cadastrado e fechando a tela
            JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso!");
            dispose();

            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void telaAdicionar() {
        lblNome.setVisible(true);
        lblUsuario.setVisible(true);
        lblSenha.setVisible(true);
        lblCPF.setVisible(true);
        lblSexo.setVisible(true);
        lblTelefone.setVisible(true);
        lblEmail.setVisible(true);
        lblCargo.setVisible(true);
        txtNome.setVisible(true);
        txtUsuario.setVisible(true);
        txtSenha.setVisible(true);
        txtCpf.setVisible(true);
        cmbSexo.setVisible(true);
        txtTelefone.setVisible(true);
        txtEmail.setVisible(true);
        txtCargo.setVisible(true);
        btnAdicionar.setVisible(true);

        lblIDFunc.setVisible(false);
        lblNomeExcluir.setVisible(false);
        lblCpfExcluir.setVisible(false);
        lblEmailExcluir.setVisible(false);
        lblCargoExcluir.setVisible(false);
        cmbIdFuncionario.setVisible(false);
        txtNomeExcluir.setVisible(false);
        txtCpfExcluir.setVisible(false);
        txtEmailExcluir.setVisible(false);
        txtCargoExcluir.setVisible(false);
        btnExcluir.setVisible(false);
    }

    private void telaExcluir() {
        lblIDFunc.setVisible(true);
        lblNomeExcluir.setVisible(true);
        lblCpfExcluir.setVisible(true);
        lblEmailExcluir.setVisible(true);
        lblCargoExcluir.setVisible(true);
        cmbIdFuncionario.setVisible(true);
        txtNomeExcluir.setVisible(true);
        txtCpfExcluir.setVisible(true);
        txtEmailExcluir.setVisible(true);
        txtCargoExcluir.setVisible(true);
        btnExcluir.setVisible(true);

        lblNome.setVisible(false);
        lblUsuario.setVisible(false);
        lblSenha.setVisible(false);
        lblCPF.setVisible(false);
        lblSexo.setVisible(false);
        lblTelefone.setVisible(false);
        lblEmail.setVisible(false);
        lblCargo.setVisible(false);
        txtNome.setVisible(false);
        txtUsuario.setVisible(false);
        txtSenha.setVisible(false);
        txtCpf.setVisible(false);
        cmbSexo.setVisible(false);
        txtTelefone.setVisible(false);
        txtEmail.setVisible(false);
        txtCargo.setVisible(false);
        btnAdicionar.setVisible(false);
    }

    private void cmbIdFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIdFuncionarioActionPerformed

        //Se o cmb for vazio não faz nada
        if (cmbIdFuncionario.getSelectedItem() == null) {
            return;   //Para de rodar se for vazio
        }

        try {

            //Instanciando obj funcionario
            Funcionario funcionario = new Funcionario();
            SistemaDao dao = new SistemaDao();

            //String para converted o cmb
            String id;

            //Recebendo o id e setando no obj funcionario
            id = cmbIdFuncionario.getSelectedItem().toString();
            funcionario.setIdFuncionario(Integer.parseInt(id));

            //Setar todas as informações dentro do obj
            funcionario = dao.filtrarFuncionario(funcionario);

            //Se tiver ocorrido tudo bem
            if (funcionario != null) {

                //Definir os txt com os valores do obj funcionario
                txtNomeExcluir.setText(funcionario.getNome());
                txtCpfExcluir.setText(funcionario.getCpf());
                txtEmailExcluir.setText(funcionario.getEmail());
                txtCargoExcluir.setText(funcionario.getCargo());
            } else {

                JOptionPane.showMessageDialog(null, "Funcionario não existe");
                return;

            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_cmbIdFuncionarioActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {

            //Instanciando obj funcionario
            Funcionario funcionario = new Funcionario();
            SistemaDao dao = new SistemaDao();

            //Variavel para converter o cmb e setando o id no  obj
            String id;
            id = cmbIdFuncionario.getSelectedItem().toString();
            funcionario.setIdFuncionario(Integer.parseInt(id));

            //Usando o ID para pegar o funcionario e depois usa-lo de parametro para exclui-lo
            funcionario = dao.filtrarFuncionario(funcionario);

            //Excluindo o funcionario
            dao.excluirFuncionario(funcionario);

            //Confirmando Exclusão e fechando a tela
            JOptionPane.showMessageDialog(null, "Funcionario excluido com sucesso!");
            dispose();

            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void preencherIdFuncionario() {
        try {
            SistemaDao dao = new SistemaDao();

            //Busca todos os id de funcionario
            int id;
            ResultSet resultado = dao.listarIdFuncionario();

            //Primeiro item fica vazio
            cmbIdFuncionario.addItem(null);

            //fazer até chegar no final da tabela (enquanto tiver próximo id)
            while (resultado.next()) {
                id = resultado.getInt("idfuncionario");
                cmbIdFuncionario.addItem(String.valueOf(id));
            }

            //Padrão
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JComboBox<String> cmbIdFuncionario;
    private javax.swing.JComboBox<String> cmbSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCargoExcluir;
    private javax.swing.JLabel lblCpfExcluir;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailExcluir;
    private javax.swing.JLabel lblIDFunc;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeExcluir;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtCargoExcluir;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtCpfExcluir;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmailExcluir;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeExcluir;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
