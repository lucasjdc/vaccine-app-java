package br.senac.vaccine.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import br.senac.vaccine.R;

public class AgendamentosActivity extends AppCompatActivity {

    private TextView textVacina;
    private TextView textData;
    private TextView textHorario;
    private EditText editNovoPosto;
    private EditText editNovaData;
    private EditText editNovoHorario;
    private EditText editNovaVacina;
    private Button btAgendar;
    private Button btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_agendamento);

        textVacina = findViewById(R.id.activity_agendamento_text_vacina);
        textData = findViewById(R.id.activity_agendamento_text_data);
        textHorario = findViewById(R.id.activity_agendamento_text_horario);
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

           textVacina.setText("Vacina: " + novaVacina);
           textData.setText("Data: " + novaData);
           textHorario.setText("Horário: " + novoHorario);

        });

        btVoltar.setOnClickListener(v ->{
            Intent intent = new Intent(AgendamentosActivity.this, MenuActivity.class);
            startActivity(intent);
            finish();
        });
    }
}

