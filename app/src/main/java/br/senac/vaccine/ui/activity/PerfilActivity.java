package br.senac.vaccine.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.senac.vaccine.R;

public class PerfilActivity extends AppCompatActivity {

    private EditText edNome;
    private EditText edNascimento;
    private EditText edSexo;
    private EditText edEndereco;
    private EditText edEmail;
    private EditText edTelefone;
    private EditText edAlergias;
    private Button btSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_perfil);

        edNome = findViewById(R.id.activity_perfil_edit_nome);
        edNascimento = findViewById(R.id.activity_perfil_edit_nascimento);
        edSexo = findViewById(R.id.activity_perfil_edit_sexo);
        edEndereco = findViewById(R.id.activity_perfil_edit_endereco);
        edEmail = findViewById(R.id.activity_perfil_edit_email);
        edTelefone = findViewById(R.id.activity_perfil_edit_telefone);
        edAlergias = findViewById(R.id.activity_perfil_edit_alergias);
        btSalvar = findViewById(R.id.activity_perfil_bt_salvar);

        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String ultimoUsuario = sharedPreferences.getString("UltimoUsuario", "");

        if (!ultimoUsuario.isEmpty()) {
            edNome.setText(sharedPreferences.getString("Nome_" + ultimoUsuario, ""));
            edNascimento.setText(sharedPreferences.getString("Nascimento_" + ultimoUsuario, ""));
            edSexo.setText(sharedPreferences.getString("Sexo_" + ultimoUsuario, ""));
            edEndereco.setText(sharedPreferences.getString("Endereco_" + ultimoUsuario, ""));
            edEmail.setText(sharedPreferences.getString("Email_" + ultimoUsuario, ""));
            edTelefone.setText(sharedPreferences.getString("Telefone_" + ultimoUsuario, ""));
            edAlergias.setText(sharedPreferences.getString("Alergias_" + ultimoUsuario, ""));
        }

        btSalvar.setOnClickListener(v -> {
            String nome = edNome.getText().toString();
            String nascimento = edNascimento.getText().toString();
            String sexo = edSexo.getText().toString();
            String endereco = edEndereco.getText().toString();
            String email = edEmail.getText().toString();
            String telefone = edTelefone.getText().toString();
            String alergias = edAlergias.getText().toString();

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Nome_" + ultimoUsuario, nome);
            editor.putString("Nascimento_" + ultimoUsuario, nascimento);
            editor.putString("Sexo_" + ultimoUsuario, sexo);
            editor.putString("Endereco_" + ultimoUsuario, endereco);
            editor.putString("Email_" + ultimoUsuario, email);
            editor.putString("Telefone_" + ultimoUsuario, telefone);
            editor.putString("Alergias_" + ultimoUsuario, alergias);
            editor.apply();

            Toast.makeText(this, "Alterações salvas com sucesso!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
