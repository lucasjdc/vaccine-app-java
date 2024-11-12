package br.senac.vaccine.ui.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import br.senac.vaccine.R;
import br.senac.vaccine.model.Vacina;

public class ListaVacinasAdapter extends RecyclerView.Adapter<ListaVacinasAdapter.VacinaViewHolder> {

    private final List<Vacina> vacinas;
    private final Context context;

    public ListaVacinasAdapter(Context context, List<Vacina> vacinas) {
        this.context = context;
        this.vacinas = vacinas;
    }

    @NonNull
    @Override
    public VacinaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_vacina, parent, false);
        return new VacinaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VacinaViewHolder holder, int position) {
        Vacina vacina = vacinas.get(position);
        holder.bind(vacina);
    }

    @Override
    public int getItemCount() {
        return vacinas.size();
    }

    static class VacinaViewHolder extends RecyclerView.ViewHolder {

        private final TextView nomeVacina;
        private final TextView postoVacina;
        private final TextView dataVacina;
        private final TextView reforcoVacina;

        public VacinaViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeVacina = itemView.findViewById(R.id.text_nome_vacina);
            postoVacina = itemView.findViewById(R.id.text_posto_vacina);
            dataVacina = itemView.findViewById(R.id.text_data_vacina);
            reforcoVacina = itemView.findViewById(R.id.text_reforco_vacina);
        }

        public void bind(Vacina vacina) {
            nomeVacina.setText(vacina.getNomeVacina());
            postoVacina.setText(vacina.getPosto());
            dataVacina.setText(vacina.getData());
            reforcoVacina.setText(vacina.getReforco());
        }
    }
}
