package br.senac.vaccine.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import br.senac.vaccine.R;
import br.senac.vaccine.dao.VacinasDao;
import br.senac.vaccine.model.Vacina;

public class CarteiraActivity extends AppCompatActivity {

    private EditText edVacina;
    private EditText edPosto;
    private EditText edData;
    private EditText edReforco;
    private Button btSalvar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_carteira);

        edVacina = findViewById(R.id.activity_carteira_edit_vacina);
        edPosto = findViewById(R.id.activity_carteira_edit_posto);
        edData = findViewById(R.id.activity_carteira_edit_data);
        edReforco = findViewById(R.id.activity_carteira_edit_reforco);
        btSalvar = findViewById(R.id.activity_carteira_btSalvar);

        // Adicionar a nova vacina à lista
        btSalvar.setOnClickListener(v -> {
            String vacina = edVacina.getText().toString();
            String posto = edPosto.getText().toString();
            String data = edData.getText().toString();
            String reforco = edReforco.getText().toString();

            // Verificar se vacina e data não estão vazios
            if (vacina.isEmpty() || data.isEmpty()) {
                Toast.makeText(CarteiraActivity.this, "Por favor, preencha o campo vacina e data", Toast.LENGTH_SHORT).show();
                return;
            }

            // Criar o objeto Vacina
            Vacina novaVacina = new Vacina(vacina, posto, data, reforco);

            // Salvar a vacina usando o DAO
            VacinasDao dao = new VacinasDao();
            dao.adiciona(novaVacina);
        });
    }
}

