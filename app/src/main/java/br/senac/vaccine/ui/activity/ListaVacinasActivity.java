package br.senac.vaccine.ui.activity;

import br.senac.vaccine.R;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import br.senac.vaccine.dao.VacinasDao;
import br.senac.vaccine.model.Vacina;
import br.senac.vaccine.ui.recyclerview.adapter.ListaVacinasAdapter;

public class ListaVacinasActivity extends AppCompatActivity {

    private VacinasDao dao = new VacinasDao();
    private ListaVacinasAdapter vacinaAdapter;
    private List<Vacina> listaDeVacinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_vacinas);

        listaDeVacinas = dao.buscaTodos();
        vacinaAdapter = new ListaVacinasAdapter(this, listaDeVacinas);

        RecyclerView recyclerViewVacinas = findViewById(R.id.recyclerViewVacinas);
        recyclerViewVacinas.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewVacinas.setAdapter(vacinaAdapter);
    }
}

