package com.example.bandodientu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class SPAdapter extends RecyclerView.Adapter<SPAdapter.ViewHolder> {
    ArrayList<SanPham> dsSanpham;

    public SPAdapter(ArrayList<SanPham> FoodDomains) {
        this.dsSanpham = FoodDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.hienthi_sanpham, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tieude.setText(dsSanpham.get(position).getTitle());

        Locale localeEN = new Locale("vi", "VN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        String gia1 = en.format(Long.valueOf(dsSanpham.get(position).getFee()));
        holder.gia.setText(gia1);

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(dsSanpham.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.anh);

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ChitietSanpham.class);
                intent.putExtra("object", dsSanpham.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dsSanpham.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tieude, gia;
        ImageView anh;
        TextView addBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tieude = itemView.findViewById(R.id.title);
            gia = itemView.findViewById(R.id.fee);
            anh = itemView.findViewById(R.id.pic);
            addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}

