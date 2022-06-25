package com.example.SweetLNP;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class TTHoaDonAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ttdonhang>  tthdlist;

    public TTHoaDonAdapter(Context context, int layout, List<ttdonhang> tthdlist) {
        this.context = context;
        this.layout = layout;
        this.tthdlist = tthdlist;
    }

    @Override
    public int getCount() {
        return tthdlist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView tenkh, diachi, sdt, tongtien, ngaydh;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view ==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            holder.tenkh=(TextView) view.findViewById(R.id.tenkh);
            holder.diachi=(TextView) view.findViewById(R.id.diachi);
            holder.sdt=(TextView) view.findViewById(R.id.sdt);

            holder.tongtien=(TextView) view.findViewById(R.id.tongtien);
            holder.ngaydh=(TextView) view.findViewById(R.id.ngaydh);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        ttdonhang ttdh = tthdlist.get(i);
        holder.ngaydh.setText(ttdh.getNgaydh());
        holder.tenkh.setText(ttdh.getTenkh());
        holder.diachi.setText(ttdh.getDiachi());
        holder.sdt.setText(ttdh.getSdt());
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat en = NumberFormat.getInstance(localeVN);

        String tongtien1 = en.format(Long.valueOf(ttdh.getTongtien()));
        holder.tongtien.setText(tongtien1+" đ");
        return view;
    }
}
