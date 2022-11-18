package Dados;

public class Paciente {

    private int idPaciente; //Não permite alterção
    private String usuario;
    private String senha;
    private String nome;
    private String cpf; // Unico
    private String sexo;
    private String telefone; //Pode ser nulo
    private String email; // Unico

    //Construtor
    public Paciente() {
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idpaciente) {
        this.idPaciente = idpaciente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
