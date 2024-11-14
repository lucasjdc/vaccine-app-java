
package br.senac.vaccine.model;

public class Agendamento {
    private String vacina;
    private String data;
    private String horario;

    public Agendamento(String vacina, String data, String horario) {
        this.vacina = vacina;
        this.data = data;
        this.horario = horario;
    }

    public String getVacina() { return vacina; }
    public String getData() { return data; }
    public String getHorario() { return horario; }
}
