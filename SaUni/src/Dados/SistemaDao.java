package Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class SistemaDao {

    private Connection conectado;
    private PreparedStatement st;
    private ResultSet resultado;
    private final String url = "jdbc:mysql://localhost:3306/saunibd";
    private final String user = "root";
    private final String senha = "1234";

    //Conectar com o banco de dados
    private void conectar() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conectado = DriverManager.getConnection(url, user, senha);
    }

    //Validar login de paciente
    public ResultSet validarPaciente(Paciente paciente) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM paciente WHERE usuario = ? AND senha = ?");
        st.setString(1, paciente.getUsuario());
        st.setString(2, paciente.getSenha());
        resultado = st.executeQuery();  //Executa o SELECT 
        return resultado;
    }

    //Validar login de funcionario
    public ResultSet validarFuncionario(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM funcionario WHERE usuario = ? AND senha = ?");
        st.setString(1, funcionario.getUsuario());
        st.setString(2, funcionario.getSenha());
        resultado = st.executeQuery();  //Executa o SELECT 
        return resultado;

    }

    //Validar Sintoma no bd
    public Sintoma validarSintoma(Sintoma sintoma) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM sintoma WHERE idsintoma = ?");
        st.setInt(1, sintoma.getIdSintoma());
        resultado = st.executeQuery();
        if (resultado.next()) {
            Sintoma objSintoma = new Sintoma();
            objSintoma.setIdSintoma(resultado.getInt("idsintoma"));
            objSintoma.setNomeSintoma(resultado.getString("nomesintoma"));
            return objSintoma;
        } else {
            return null;
        }

    }

    //Validar doença no bd
    public Doenca validarDoenca(Doenca doenca) throws ClassNotFoundException, SQLException {
        //Conectando no bd
        conectar();

        //Fazendo uma query
        st = conectado.prepareStatement("SELECT * FROM doenca WHERE iddoenca = ?");
        st.setInt(1, doenca.getIdDoenca());
        resultado = st.executeQuery();

        //Se o resultado da query existir
        if (resultado.next()) {
            //Instancia um novo objeto e faz ele receber todas as informações na query
            Doenca objDoenca = new Doenca();
            objDoenca.setIdDoenca(resultado.getInt("iddoenca"));
            objDoenca.setNomeDoenca(resultado.getString("nomedoenca"));
            //Retorna objeto com as informações
            return objDoenca;
        } else {
            //Se o resultado da query for negativo retorna nulo
            return null;
        }

    }

    //Validar Usuario no bd
    public String validarContaExistente(Paciente paciente) throws ClassNotFoundException, SQLException {
        conectar();
        String existe = "";

        st = conectado.prepareStatement("SELECT * FROM paciente WHERE usuario = ?");
        st.setString(1, paciente.getUsuario());
        resultado = st.executeQuery();

        //Se achar um usuario igual ao digitado
        if (resultado.next()) {

            existe = "Usuário já existente";

        } else if (!resultado.next()) {

            st = conectado.prepareStatement("SELECT * FROM paciente WHERE cpf = ?");
            st.setString(1, paciente.getCpf());
            resultado = st.executeQuery();

            //Se achar um conta com o cpf digitado
            if (resultado.next()) {

                existe = "Esse CPF já possui uma conta";

            } else {

                existe = "prosseguir";

            }
        }
        return existe;
    }

    //Validar Funcionario por cpf
    public ResultSet validarCpfFuncionario(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM funcionario WHERE usuario = ? AND cpf = ?");
        st.setString(1, funcionario.getUsuario());
        st.setString(2, funcionario.getCpf());
        resultado = st.executeQuery();
        return resultado;

    }

    //Validar Paciente por cpf
    public ResultSet validarCpfPaciente(Paciente paciente) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM paciente WHERE usuario = ? AND cpf = ?");
        st.setString(1, paciente.getUsuario());
        st.setString(2, paciente.getCpf());
        resultado = st.executeQuery();
        return resultado;

    }

    //Validar paciente apenas por cpf
    public Paciente validarPacienteApenasCpf(Paciente paciente) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM paciente WHERE  cpf = ?");
        st.setString(1, paciente.getCpf());
        resultado = st.executeQuery();
        if (resultado.next()) {
            Paciente objPaciente = new Paciente();
            objPaciente.setIdPaciente(resultado.getInt("idpaciente"));
            objPaciente.setNome(resultado.getString("nome"));
            objPaciente.setUsuario(resultado.getString("usuario"));
            objPaciente.setSenha(resultado.getString("Senha"));
            objPaciente.setCpf(resultado.getString("cpf"));
            objPaciente.setSexo(resultado.getString("sexo"));
            objPaciente.setTelefone(resultado.getString("telefone"));
            objPaciente.setEmail(resultado.getString("email"));
            return objPaciente;
        } else {
            return null;
        }

    }

    //Validar Agendamento 
    public Consulta validarAgendamento(Consulta consulta) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM consulta WHERE idagendamento = ?");
        st.setInt(1, consulta.getIdAgendamento());
        resultado = st.executeQuery();
        if (resultado.next()) {
            Consulta objConsulta = new Consulta();
            objConsulta.setDataConsulta(resultado.getString("data_consulta"));
            objConsulta.setIdAgendamento(resultado.getInt("idagendamento"));
            objConsulta.setIdPaciente(resultado.getInt("id_paciente"));
            objConsulta.setIdFuncionario(resultado.getInt("id_funcionario"));
            return objConsulta;
        } else {
            return null;
        }
    }

    //Cadastrar paciente
    public void cadastrarPaciente(Paciente paciente) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("INSERT INTO paciente(`usuario`, `senha`, `nome`, `cpf`, `sexo`, `telefone`, `email`) VALUES(?,?,?,?,?,?,?)");
        st.setString(1, paciente.getUsuario());
        st.setString(2, paciente.getSenha());
        st.setString(3, paciente.getNome());
        st.setString(4, paciente.getCpf());
        st.setString(5, paciente.getSexo());
        st.setString(6, paciente.getTelefone());
        st.setString(7, paciente.getEmail());
        st.executeUpdate();
    }

    //Cadastrar Funcionario
    public void cadastrarFuncionario(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("INSERT INTO funcionario (`nome`, `usuario`, `senha`, `cpf`, `sexo`, `telefone`, `email`, `cargo`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        st.setString(1, funcionario.getNome());
        st.setString(2, funcionario.getUsuario());
        st.setString(3, funcionario.getSenha());
        st.setString(4, funcionario.getCpf());
        st.setString(5, funcionario.getSexo());
        st.setString(6, funcionario.getTelefone());
        st.setString(7, funcionario.getEmail());
        st.setString(8, funcionario.getCargo());
        st.executeUpdate();
    }

    //Adicionar dados de uma doença
    public void adicionarDoenca(Doenca doenca) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("INSERT INTO doenca(nomedoenca) VALUES (?)");
        st.setString(1, doenca.getNomeDoenca());
        st.executeUpdate();
    }

    //Adicionar dados de um sintoma
    public void adicionarSintoma(Sintoma sintoma) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("INSERT INTO sintoma(nomesintoma) VALUES (?)");
        st.setString(1, sintoma.getNomeSintoma());
        st.executeUpdate();
    }

    //Adicionar um relacionamento na tabela de rel. doença-sintoma
    public void adicionarRelacionamentoDS(Doenca doenca, Sintoma sintoma) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("INSERT INTO sintomas_doenca(id_doenca, id_sintoma) VALUES (?,?)");
        st.setInt(1, doenca.getIdDoenca());
        st.setInt(2, sintoma.getIdSintoma());
        st.executeUpdate();
    }

    //Adicionar consulta/Agendar
    public void agendarConsulta(Consulta consulta) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("INSERT INTO consulta(`data_consulta`, `id_paciente`, `id_funcionario`) VALUES (?, ?, ?)");
        st.setString(1, consulta.getDataConsulta());
        st.setInt(2, consulta.getIdPaciente());
        st.setInt(3, consulta.getIdFuncionario());
        st.executeUpdate();
    }

    //Listar todas as doenças e sintomas
    public ResultSet listarDoencasSintomas() throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM sintomas_doenca INNER JOIN doenca ON id_doenca = iddoenca INNER JOIN sintoma ON id_sintoma = idsintoma ORDER BY id_doenca ASC");
        resultado = st.executeQuery();
        return resultado;
    }

    //Listar sintomas
    public ResultSet listarSintomas() throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM sintoma ORDER BY idsintoma ASC");
        resultado = st.executeQuery();
        return resultado;
    }

    //Listar paciente
    public ResultSet listarPaciente() throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM paciente ORDER BY nome DESC");
        resultado = st.executeQuery();
        return resultado;
    }

    //Listar doenças
    public ResultSet listarDoencas() throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM doenca ORDER BY iddoenca ASC");
        resultado = st.executeQuery();
        return resultado;
    }

    //Listar cargos
    public ResultSet listarCargo() throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT cargo FROM funcionario GROUP BY cargo");
        resultado = st.executeQuery();
        return resultado;
    }

    //Listar IdFuncionarios
    public ResultSet listarIdFuncionario() throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT idfuncionario FROM funcionario ORDER BY idfuncionario");
        resultado = st.executeQuery();
        return resultado;
    }

    //Listar Agenda
    public ResultSet listarAgenda() throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM consulta INNER JOIN funcionario ON id_funcionario = idfuncionario INNER JOIN paciente ON id_paciente = idpaciente ORDER BY data_consulta ASC");
        resultado = st.executeQuery();
        return resultado;
    }

    //Listar Agenda Paciente
    public ResultSet listarAgendaPaciente(Paciente paciente) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM consulta INNER JOIN funcionario ON id_funcionario = idfuncionario INNER JOIN paciente ON id_paciente = idpaciente WHERE id_paciente = ? ORDER BY idagendamento ASC");
        st.setInt(1, paciente.getIdPaciente());
        resultado = st.executeQuery();
        return resultado;
    }

    //Listar Agenda Paciente por nome
    public ResultSet listarAgendaPacientePorNome(Paciente paciente) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM consulta INNER JOIN funcionario ON id_funcionario = idfuncionario INNER JOIN paciente ON id_paciente = idpaciente WHERE paciente.nome = ? ORDER BY data_consulta ASC");
        st.setString(1, paciente.getNome());
        resultado = st.executeQuery();
        return resultado;
    }

    //Listar Agenda Funcionario por nome
    public ResultSet listarAgendaFuncionarioPorNome(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM consulta INNER JOIN funcionario ON id_funcionario = idfuncionario INNER JOIN paciente ON id_paciente = idpaciente WHERE funcionario.nome = ? ORDER BY funcionario.nome ASC");
        st.setString(1, funcionario.getNome());
        resultado = st.executeQuery();
        return resultado;
    }

    //Filtrar por sintoma
    public ResultSet listarDoencasPorSintoma(Sintoma sintoma) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM sintomas_doenca INNER JOIN doenca ON id_doenca = iddoenca INNER JOIN sintoma ON id_sintoma = idsintoma WHERE nomesintoma = ? ORDER BY id_doenca ASC");
        st.setString(1, sintoma.getNomeSintoma());
        resultado = st.executeQuery();
        return resultado;
    }

    //Filtrar por doença
    public ResultSet listarSintomasPorDoenca(Doenca doenca) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM sintomas_doenca INNER JOIN doenca ON id_doenca = iddoenca INNER JOIN sintoma ON id_sintoma = idsintoma WHERE nomedoenca = ? ORDER BY id_doenca ASC");
        st.setString(1, doenca.getNomeDoenca());
        resultado = st.executeQuery();
        return resultado;
    }

    //Filtrar medicos
    public ResultSet listarMedicos() throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM funcionario WHERE cargo = ?");
        st.setString(1, "Medico");
        resultado = st.executeQuery();
        return resultado;
    }

    //Achar id de uma doença
    public ResultSet acharIDDoenca(String achar) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM doenca WHERE nomedoenca = ?");
        st.setString(1, achar);
        resultado = st.executeQuery();
        return resultado;
    }

    //Achar id de uma sintoma
    public ResultSet acharIDSintoma(String achar) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM sintoma WHERE nomesintoma = ?");
        st.setString(1, achar);
        resultado = st.executeQuery();
        return resultado;
    }

    //Achar ID de funcionario
    public ResultSet acharIdFuncionario(String nome) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM funcionario WHERE nome = ?");
        st.setString(1, nome);
        resultado = st.executeQuery();
        return resultado;

    }

    //Achar funcionario
    public Funcionario filtrarFuncionario(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM funcionario WHERE idfuncionario = ?");
        st.setInt(1, funcionario.getIdFuncionario());
        resultado = st.executeQuery();
        if (resultado.next()) {
            Funcionario objFuncionario = new Funcionario();
            objFuncionario.setIdFuncionario(resultado.getInt("idfuncionario"));
            objFuncionario.setNome(resultado.getString("nome"));
            objFuncionario.setUsuario(resultado.getString("usuario"));
            objFuncionario.setSenha(resultado.getString("Senha"));
            objFuncionario.setCpf(resultado.getString("cpf"));
            objFuncionario.setSexo(resultado.getString("sexo"));
            objFuncionario.setTelefone(resultado.getString("telefone"));
            objFuncionario.setEmail(resultado.getString("email"));
            objFuncionario.setCargo(resultado.getString("cargo"));
            return objFuncionario;
        } else {
            return null;
        }
    }

    //Achar funcionario
    public Funcionario filtrarFuncionarioPorNome(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM funcionario WHERE nome = ?");
        st.setString(1, funcionario.getNome());
        resultado = st.executeQuery();
        if (resultado.next()) {
            Funcionario objFuncionario = new Funcionario();
            objFuncionario.setIdFuncionario(resultado.getInt("idfuncionario"));
            objFuncionario.setNome(resultado.getString("nome"));
            objFuncionario.setUsuario(resultado.getString("usuario"));
            objFuncionario.setSenha(resultado.getString("Senha"));
            objFuncionario.setCpf(resultado.getString("cpf"));
            objFuncionario.setSexo(resultado.getString("sexo"));
            objFuncionario.setTelefone(resultado.getString("telefone"));
            objFuncionario.setEmail(resultado.getString("email"));
            objFuncionario.setCargo(resultado.getString("cargo"));
            return objFuncionario;
        } else {
            return null;
        }
    }

    //Achar paciente
    public Paciente filtrarPaciente(Paciente paciente) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM paciente  WHERE idpaciente = ?");
        st.setInt(1, paciente.getIdPaciente());
        resultado = st.executeQuery();
        if (resultado.next()) {
            Paciente objPaciente = new Paciente();
            objPaciente.setIdPaciente(resultado.getInt("idpaciente"));
            objPaciente.setNome(resultado.getString("nome"));
            objPaciente.setUsuario(resultado.getString("usuario"));
            objPaciente.setSenha(resultado.getString("Senha"));
            objPaciente.setCpf(resultado.getString("cpf"));
            objPaciente.setSexo(resultado.getString("sexo"));
            objPaciente.setTelefone(resultado.getString("telefone"));
            objPaciente.setEmail(resultado.getString("email"));
            return objPaciente;
        } else {
            return null;
        }
    }

    //Excluir doença
    public void excluirDoenca(Doenca doenca) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("DELETE FROM sintomas_doenca WHERE id_doenca = ? ");
        st.setInt(1, doenca.getIdDoenca());
        st.executeUpdate(); //INSERT, UPDATE, DELETE

        st = conectado.prepareStatement("DELETE FROM doenca WHERE iddoenca = ? ");
        st.setInt(1, doenca.getIdDoenca());
        st.executeUpdate(); //INSERT, UPDATE, DELETE

    }

    //Excluir Funcionario
    public void excluirFuncionario(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT cargo FROM funcionario WHERE idfuncionario = ?");
        st.setInt(1, funcionario.getIdFuncionario());
        resultado = st.executeQuery(); //INSERT, UPDATE, DELETE

        if (resultado.next()) {
            if (funcionario.getCargo().equalsIgnoreCase("Medico")) {
                st = conectado.prepareStatement("DELETE FROM consulta WHERE id_funcionario = ?");
                st.setInt(1, funcionario.getIdFuncionario());
                st.executeUpdate(); //INSERT, UPDATE, DELETE
            }
        }

        st = conectado.prepareStatement("DELETE FROM funcionario WHERE idfuncionario = ?");
        st.setInt(1, funcionario.getIdFuncionario());
        st.executeUpdate(); //INSERT, UPDATE, DELETE

    }

    //Excluir conta paciente
    public void excluirPaciente(Paciente paciente) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM consulta WHERE id_paciente = ?");
        st.setInt(1, paciente.getIdPaciente());
        resultado = st.executeQuery(); //INSERT, UPDATE, DELETE

        if (resultado.next()) {
            st = conectado.prepareStatement("DELETE FROM consulta WHERE id_paciente = ?");
            st.setInt(1, paciente.getIdPaciente());
            st.executeUpdate(); //INSERT, UPDATE, DELETE
        }

        st = conectado.prepareStatement("DELETE FROM paciente WHERE idpaciente = ?");
        st.setInt(1, paciente.getIdPaciente());
        st.executeUpdate(); //INSERT, UPDATE, DELETE

    }

    //Excluir sintoma
    public void excluirSintoma(Sintoma sintoma) throws ClassNotFoundException, SQLException {

        //Ver se o sintoma ta na tabela relacionamento
        st = conectado.prepareStatement("SELECT * FROM sintomas_doenca WHERE id_sintoma = ?");
        st.setInt(1, sintoma.getIdSintoma());
        resultado = st.executeQuery();

        //Se sim deletar
        if (resultado.next()) {
            st = conectado.prepareStatement("DELETE FROM sintomas_doenca WHERE id_sintoma = ?");
            st.setInt(1, sintoma.getIdSintoma());
            st.executeUpdate();
        }

        st = conectado.prepareStatement("DELETE FROM sintoma WHERE idsintoma = ? ");
        st.setInt(1, sintoma.getIdSintoma());
        st.executeUpdate(); //INSERT, UPDATE, DELETE

    }

    //Excluir um relacionamento na tabela de rel. doença-sintoma
    public void removerRelacionamentoDS(Doenca doenca, Sintoma sintoma) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("DELETE FROM sintomas_doenca WHERE id_doenca = ?  AND id_sintoma = ?");
        st.setInt(1, doenca.getIdDoenca());
        st.setInt(2, sintoma.getIdSintoma());
        st.executeUpdate();
    }

    //Excluir agendamento
    public void deletarAgendamento(Consulta consulta) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("DELETE FROM consulta WHERE idagendamento = ?");
        st.setInt(1, consulta.getIdAgendamento());
        st.executeUpdate();
    }

    //Alterar data do agendamento
    public void alterarAgendamento(Consulta consulta) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("UPDATE consulta SET `data_consulta` = ? WHERE idagendamento = ?");
        st.setString(1, consulta.getDataConsulta());
        st.setInt(2, consulta.getIdAgendamento());
        st.executeUpdate();
    }

    //Alterar cargo
    public void alterarCargo(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("UPDATE funcionario SET `cargo` = ? WHERE idfuncionario = ?");
        st.setString(1, funcionario.getCargo());
        st.setInt(2, funcionario.getIdFuncionario());
        st.executeUpdate();
    }

    //Alterar Usuario Funcionario
    public void alterarUsuarioFuncionario(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("UPDATE funcionario SET usuario = ? WHERE idfuncionario = ?");
        st.setString(1, funcionario.getUsuario());
        st.setInt(2, funcionario.getIdFuncionario());
        st.executeUpdate();
    }

    //Alterar Senha Funcionario
    public void alterarSenhaFuncionario(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("UPDATE funcionario SET senha = ? WHERE idfuncionario = ?");
        st.setString(1, funcionario.getSenha());
        st.setInt(2, funcionario.getIdFuncionario());
        st.executeUpdate();
    }

    //Alterar Nome Funcionario
    public void alterarNomeFuncionario(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("UPDATE funcionario SET nome = ? WHERE idfuncionario = ?");
        st.setString(1, funcionario.getNome());
        st.setInt(2, funcionario.getIdFuncionario());
        st.executeUpdate();
    }

    //Alterar Telefone Funcionario
    public void alterarTelefoneFuncionario(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("UPDATE funcionario SET telefone = ? WHERE idfuncionario = ?");
        st.setString(1, funcionario.getTelefone());
        st.setInt(2, funcionario.getIdFuncionario());
        st.executeUpdate();
    }

    //Alterar Email Funcionario
    public void alterarEmailFuncionario(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("UPDATE funcionario SET email = ? WHERE idfuncionario = ?");
        st.setString(1, funcionario.getEmail());
        st.setInt(2, funcionario.getIdFuncionario());
        st.executeUpdate();
    }

    //Alterar Usuario Paciente
    public void alterarUsuarioPaciente(Paciente paciente) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("UPDATE paciente SET usuario = ? WHERE idpaciente = ?");
        st.setString(1, paciente.getUsuario());
        st.setInt(2, paciente.getIdPaciente());
        st.executeUpdate();
    }

    //Alterar Senha Paciente
    public void alterarSenhaPaciente(Paciente paciente) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("UPDATE paciente SET senha = ? WHERE idpaciente = ?");
        st.setString(1, paciente.getSenha());
        st.setInt(2, paciente.getIdPaciente());
        st.executeUpdate();
    }

    //Alterar Nome Paciente
    public void alterarNomePaciente(Paciente paciente) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("UPDATE paciente SET nome = ? WHERE idpaciente = ?");
        st.setString(1, paciente.getNome());
        st.setInt(2, paciente.getIdPaciente());
        st.executeUpdate();
    }

    //Alterar Telefone Paciente
    public void alterarTelefonePaciente(Paciente paciente) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("UPDATE paciente SET telefone = ? WHERE idpaciente = ?");
        st.setString(1, paciente.getTelefone());
        st.setInt(2, paciente.getIdPaciente());
        st.executeUpdate();
    }

    //Alterar Email Paciente
    public void alterarEmailPaciente(Paciente paciente) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("UPDATE paciente SET email = ? WHERE idpaciente = ?");
        st.setString(1, paciente.getEmail());
        st.setInt(2, paciente.getIdPaciente());
        st.executeUpdate();
    }

}
