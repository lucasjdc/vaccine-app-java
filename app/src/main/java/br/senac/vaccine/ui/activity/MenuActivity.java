package br.senac.vaccine.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import br.senac.vaccine.R;

public class MenuActivity extends AppCompatActivity {
    private Button btPerfil;
    private Button btCarteira;
    private Button btAgendamentos;
    private Button btVacina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_menu);

        btPerfil = findViewById(R.id.btPerfil);
        btCarteira = findViewById(R.id.btCarteira);
        btAgendamentos = findViewById(R.id.btAgendamentos);
        btVacina = findViewById(R.id.btListaVacinas);

        btPerfil.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, PerfilActivity.class);
            startActivity(intent);
        });

        btCarteira.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, CarteiraActivity.class);
            startActivity(intent);
        });

        btAgendamentos.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, AgendamentosActivity.class);
            startActivity(intent);
        });

        btVacina.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, ListaVacinasActivity.class);
            startActivity(intent);
        });
    }
}
