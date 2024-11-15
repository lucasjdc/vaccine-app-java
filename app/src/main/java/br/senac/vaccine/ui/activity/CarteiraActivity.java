package br.senac.vaccine.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import br.senac.vaccine.R;
import br.senac.vaccine.dao.VacinasDao;
import br.senac.vaccine.database.DBHelper;
import br.senac.vaccine.model.Vacina;

public class CarteiraActivity extends AppCompatActivity {

    private EditText edVacina;
    private EditText edPosto;
    private EditText edData;
    private EditText edReforco;
    private Button btSalvar;

    private VacinasDao vacinasDao; // Adicionando VacinasDao como atributo para reutilização

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_carteira);

        // Inicializa os componentes
        edVacina = findViewById(R.id.activity_carteira_edit_vacina);
        edPosto = findViewById(R.id.activity_carteira_edit_posto);
        edData = findViewById(R.id.activity_carteira_edit_data);
        edReforco = findViewById(R.id.activity_carteira_edit_reforco);
        btSalvar = findViewById(R.id.activity_carteira_btSalvar);

        // Inicializa VacinasDao com DBHelper
        DBHelper dbHelper = new DBHelper(this);
        vacinasDao = new VacinasDao(dbHelper);

        // Configura o botão salvar
        btSalvar.setOnClickListener(v -> salvarVacina());
    }

    private void salvarVacina() {
        String vacina = edVacina.getText().toString().trim();
        String posto = edPosto.getText().toString().trim();
        String data = edData.getText().toString().trim();
        String reforco = edReforco.getText().toString().trim();

        // Validação de campos obrigatórios
        if (vacina.isEmpty() || data.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha o campo vacina e data", Toast.LENGTH_SHORT).show();
            return;
        }

        // Cria uma nova instância de Vacina
        Vacina novaVacina = new Vacina(vacina, posto, data, reforco);

        // Adiciona ao banco de dados
        long id = vacinasDao.adiciona(novaVacina);

        if (id > 0) {
            Toast.makeText(this, "Vacina salva com sucesso!", Toast.LENGTH_SHORT).show();

            // Limpa os campos
            edVacina.setText("");
            edPosto.setText("");
            edData.setText("");
            edReforco.setText("");
        } else {
            Toast.makeText(this, "Erro ao salvar a vacina.", Toast.LENGTH_SHORT).show();
        }
    }
}
