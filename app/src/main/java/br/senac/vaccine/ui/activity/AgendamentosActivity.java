package br.senac.vaccine.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.senac.vaccine.R;
import br.senac.vaccine.model.Agendamento;
import br.senac.vaccine.ui.recyclerview.adapter.AgendamentoAdapter;

public class AgendamentosActivity extends AppCompatActivity {


    private EditText editNovoPosto;
    private EditText editNovaData;
    private EditText editNovoHorario;
    private EditText editNovaVacina;
    private Button btAgendar;
    private Button btVoltar;

    private RecyclerView recyclerView;
    private AgendamentoAdapter adapter;
    private List<Agendamento> agendamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_agendamento);

        agendamentos = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view_agendamentos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new AgendamentoAdapter(agendamentos, position -> {
            agendamentos.remove(position);
            adapter.notifyItemRemoved(position);
        });

        recyclerView.setAdapter(adapter);


        editNovoPosto = findViewById(R.id.activity_agendamento_edit_novo_posto);
        editNovaData = findViewById(R.id.activity_agendamento_edit_nova_data);
        editNovoHorario = findViewById(R.id.activity_agendamento_edit_novo_horario);
        editNovaVacina = findViewById(R.id.activity_agendamento_edit_nova_vacina);
        btAgendar = findViewById(R.id.activity_agendamento_bt_agendar);
        btVoltar = findViewById(R.id.activity_agendamento_bt_voltar);

        btAgendar.setOnClickListener(v -> {
            String novoPosto = editNovoPosto.getText().toString();
            String novaData = editNovaData.getText().toString();
            String novoHorario = editNovoHorario.getText().toString();
            String novaVacina = editNovaVacina.getText().toString();



            agendamentos.add(new Agendamento(novaVacina, novaData, novoHorario));
            adapter.notifyDataSetChanged();

            editNovoPosto.setText("");
            editNovaData.setText("");
            editNovoHorario.setText("");
            editNovaVacina.setText("");

        });

        btVoltar.setOnClickListener(v ->{
            Intent intent = new Intent(AgendamentosActivity.this, MenuActivity.class);
            startActivity(intent);
            finish();
        });
    }
}

