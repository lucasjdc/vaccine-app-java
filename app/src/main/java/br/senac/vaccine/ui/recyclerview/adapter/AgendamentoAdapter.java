package br.senac.vaccine.ui.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import br.senac.vaccine.R;
import br.senac.vaccine.model.Agendamento;

public class AgendamentoAdapter extends RecyclerView.Adapter<AgendamentoAdapter.AgendamentoViewHolder> {
    private final List<Agendamento> agendamentos;
    private final OnDeleteClickListener onDeleteClickListener;

    public interface OnDeleteClickListener {
        void onDeleteClick(int position);
    }

    public AgendamentoAdapter(List<Agendamento> agendamentos, OnDeleteClickListener onDeleteClickListener) {
        this.agendamentos = agendamentos;
        this.onDeleteClickListener = onDeleteClickListener;
    }

    @NonNull
    @Override
    public AgendamentoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_agendamento, parent, false);
        return new AgendamentoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AgendamentoViewHolder holder, int position) {
        Agendamento agendamento = agendamentos.get(position);
        holder.vacinaNome.setText(agendamento.getVacina());
        holder.dataHorario.setText(agendamento.getData() + " - " + agendamento.getHorario());

        holder.excluirButton.setOnClickListener(v -> onDeleteClickListener.onDeleteClick(position));
    }

    @Override
    public int getItemCount() {
        return agendamentos.size();
    }

    static class AgendamentoViewHolder extends RecyclerView.ViewHolder {
        TextView vacinaNome;
        TextView dataHorario;
        Button excluirButton;

        public AgendamentoViewHolder(@NonNull View itemView) {
            super(itemView);
            vacinaNome = itemView.findViewById(R.id.text_view_vacina_nome);
            dataHorario = itemView.findViewById(R.id.text_view_data_horario);
            excluirButton = itemView.findViewById(R.id.button_excluir);
        }
    }
}
