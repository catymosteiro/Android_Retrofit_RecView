package edu.upc.dsa.tracks.IO;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.upc.dsa.tracks.R;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder>{

    Context context;
    List<Repositorio> list;

    public RecycleAdapter (Context contexto, List<Repositorio> lista){
        context = contexto;
        list = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.elemento_track, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("prueba", "onBindViewHolder" + list.get(position).getLenguaje());
        holder.text1.setText(list.get(position).getLenguaje());
        holder.text2.setText(list.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView text1;
        TextView text2;
        ConstraintLayout main;
        public ViewHolder(@NonNull View vista) {
            super(vista);
            text1 = vista.findViewById(R.id.lenguaje_rec);
            text2 = vista.findViewById(R.id.nombre_rec);
            //main = vista.findViewById(R.id.MainRecycle);
        }
    }
}
