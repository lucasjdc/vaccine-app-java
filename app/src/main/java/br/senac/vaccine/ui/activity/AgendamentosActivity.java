package br.senac.vaccine.ui.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import br.senac.vaccine.R;

public class AgendamentosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_agendamento);
    }
}

