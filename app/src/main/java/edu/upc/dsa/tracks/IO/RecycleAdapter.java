package edu.upc.dsa.tracks.IO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.upc.dsa.tracks.R;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder>{

    Context context;
    ArrayList<Track> list;

    public RecycleAdapter (Context context, ArrayList<Track> list){
        context = context;
        list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.image.setImageResource(list.get(position).image);
        holder.text1.setText(list.get(position).id);
        holder.text2.setText(list.get(position).title);
        holder.text3.setText(list.get(position).singer);
        Track track = list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView text1;
        TextView text2;
        TextView text3;
        ConstraintLayout main;
        public ViewHolder(@NonNull View vista) {
            super(vista);
            image = vista.findViewById(R.id.imageView);
            text1 = vista.findViewById(R.id.id_rec);
            text2 = vista.findViewById(R.id.title_rec);
            text3 = vista.findViewById(R.id.singer_rec);
            main = vista.findViewById(R.id.MainRecycle);
        }
    }
}
