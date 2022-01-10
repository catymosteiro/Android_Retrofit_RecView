package edu.upc.dsa.tracks.IO;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import edu.upc.dsa.tracks.R;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder>{

    Context context;
    List<Track> list;

    public RecycleAdapter (Context contexto, List<Track> lista){
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
        //Picasso.get().load(R.drawable.logo).into(holder.imageView);
        Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(holder.imageView);
        Log.d("prueba", "onBindViewHolder" + list.get(position).getId());
        holder.text1.setText(list.get(position).getId());
        holder.text2.setText(list.get(position).getTitle())
        ;
        holder.text3.setText(list.get(position).getSinger());
        Track track = list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView text1;
        TextView text2;
        TextView text3;
        ConstraintLayout main;
        public ViewHolder(@NonNull View vista) {
            super(vista);
            imageView = vista.findViewById(R.id.image);
            text1 = vista.findViewById(R.id.id_rec);
            text2 = vista.findViewById(R.id.title_rec);
            text3 = vista.findViewById(R.id.singer_rec);
            //main = vista.findViewById(R.id.MainRecycle);
        }
    }
}
