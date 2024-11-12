package br.senac.vaccine.model;

public class Login {
    private String usuario;
    private String senha;

    // Construtor
    public Login(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    // Métodos getter e setter para usuario
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    // Métodos getter e setter para senha
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
