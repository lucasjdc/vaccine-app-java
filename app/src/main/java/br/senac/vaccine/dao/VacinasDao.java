package br.senac.vaccine.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.senac.vaccine.model.Vacina;

public class VacinasDao {
    private static final List<Vacina> vacinas = new ArrayList<>();

    static {
        vacinas.add(new Vacina(
                "Febre amarela",
                "Centro",
                "12/11/2024",
                "não precisa"
        ));
    }

    public void adiciona(Vacina vacina) {
        vacinas.add(vacina);
    }

    public List<Vacina> buscaTodos() {
        return Collections.unmodifiableList(vacinas);
    }
}
