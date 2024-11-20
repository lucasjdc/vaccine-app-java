package br.senac.vaccine.ui.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import br.senac.vaccine.R;
import br.senac.vaccine.model.Agendamento;
import br.senac.vaccine.ui.recyclerview.adapter.AgendamentoAdapter;
import br.senac.vaccine.util.NotificationHelper;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;

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


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 1);
            }
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

            NotificationHelper.createNotificationChannel(AgendamentosActivity.this);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NotificationHelper.CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_notification)
                    .setContentTitle("Novo Agendamento")
                    .setContentText("Vacina: " + novaVacina + " em " + novaData + " às " + novoHorario)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            Intent intent = new Intent(this, AgendamentosActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
            builder.setContentIntent(pendingIntent);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(1, builder.build());

        });

        btVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(AgendamentosActivity.this, MenuActivity.class);
            startActivity(intent);
            finish();
        });
    }
}

