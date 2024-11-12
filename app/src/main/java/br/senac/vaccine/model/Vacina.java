package br.senac.vaccine.model;

public class Vacina {
    private String nomeVacina;
    private String posto;
    private String data;
    private String reforco;

    public Vacina(String nomeVacina, String posto, String data, String reforco) {
        this.nomeVacina = nomeVacina;
        this.posto = posto;
        this.data = data;
        this.reforco = reforco;
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
