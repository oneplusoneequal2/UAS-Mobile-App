package id.ac.umn.uas_mobileapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<TransaksiData> items;

    public MyAdapter(Context context, List<TransaksiData> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.typeView.setText(items.get(position).getKategori());
        holder.nominalView.setText(String.valueOf(items.get(position).getNominal()));
        holder.imageView.setImageResource(items.get(position).getImage());
        holder.dateView.setText(String.valueOf(items.get(position).getTanggal()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
