package com.example.bandodientu;

import android.annotation.SuppressLint;
import android.content.Context;
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

public class DsGioHangAdapter extends RecyclerView.Adapter<DsGioHangAdapter.ViewHolder> {
    private ArrayList<SanPham> splist;
    private QLGioHang quanlygiohang;
    private TDsoSP thaydoisoluong;

    public DsGioHangAdapter(ArrayList<SanPham> listsp, Context context, TDsoSP thaydoi) {

        this.splist = listsp;
        quanlygiohang = new QLGioHang(context);
        this.thaydoisoluong = thaydoi;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.sanpham_giohang, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tensp.setText(splist.get(position).getTitle());

        Locale localeVN = new Locale("vi", "VN");//Định dạng kiểu số việt nam
        NumberFormat en = NumberFormat.getInstance(localeVN);
        String feeEachItem1 = en.format(Long.valueOf(splist.get(position).getFee()));
        holder.giasp.setText(feeEachItem1);

        long tongtien = Math.round((splist.get(position).getNumberInCart() * splist.get(position).getFee()));
        String totalEachItem1 = en.format(Long.valueOf(tongtien));
        holder.tongtiensp.setText(totalEachItem1);
        holder.soluong.setText(String.valueOf(splist.get(position).getNumberInCart()));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(splist.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.anhsp);

//sự kiện ấn nút cộng
        holder.plusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quanlygiohang.plusNumberSP(splist, position, new TDsoSP() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        thaydoisoluong.changed();
                    }
                });
            }
        });
//sự kiện ấn nút trừ
        holder.minusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quanlygiohang.MinusNumerSP(splist, position, new TDsoSP() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        thaydoisoluong.changed();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return splist.size();
    }

    //Ánh xạ
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tensp, giasp;
        ImageView anhsp, plusItem, minusItem;
        TextView tongtiensp, soluong;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tensp = itemView.findViewById(R.id.tensp);
            giasp = itemView.findViewById(R.id.giasp);
            anhsp = itemView.findViewById(R.id.anhsp);
            tongtiensp = itemView.findViewById(R.id.tongtiensp);
            soluong = itemView.findViewById(R.id.soluong);
            plusItem = itemView.findViewById(R.id.plusCardBtn);
            minusItem = itemView.findViewById(R.id.minusCardBtn);
        }
    }
}