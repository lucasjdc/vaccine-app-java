package br.senac.vaccine.model;

public class Vacina {
    private int id;
    private String nomeVacina;
    private String posto;
    private String data;
    private String reforco;
    private String codigoUsuario;

    // Construtor sem ID
    public Vacina(String nomeVacina, String posto, String data, String reforco, String codigoUsuario) {
        this.nomeVacina = nomeVacina;
        this.posto = posto;
        this.data = data;
        this.reforco = reforco;
        this.codigoUsuario = codigoUsuario;
    }

    // Construtor com ID
    public Vacina(int id, String nomeVacina, String posto, String data, String reforco, String codigoUsuario) {
        this.id = id;
        this.nomeVacina = nomeVacina;
        this.posto = posto;
        this.data = data;
        this.reforco = reforco;
        this.codigoUsuario = codigoUsuario;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public int getId() {
        return id;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public String getPosto() {
        return posto != null ? posto : "Posto não informado";
    }

    public String getData() {
        return data != null ? data : "Data não informada";
    }

    public String getReforco() {
        return reforco != null ? reforco : "Reforço não informado";
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setReforco(String reforco) {
        this.reforco = reforco;
    }
}
