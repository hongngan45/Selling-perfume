package com.example.bandodientu;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

public class QLGioHang {
    private Context context;
    private dlsanpham dlSanPham;

    public QLGioHang(Context context) {
        this.context = context;
        this.dlSanPham = new dlsanpham(context);
    }

    public void insertSP(SanPham item) {//Thêm sản phẩm vào giỏ hàng
        ArrayList<SanPham> splist = getListCard();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < splist.size(); i++) {
            if (splist.get(i).getTitle().equals(item.getTitle())) {
                existAlready = true;
                n = i;
                break;
            }
        }

        if (existAlready) {
            splist.get(n).setNumberInCart(item.getNumberInCart());
        } else {
            splist.add(item);
        }

        dlSanPham.putListObject("CardList", splist);
        Toast.makeText(context, "Thêm Vào giỏ hàng thành công !", Toast.LENGTH_SHORT).show();

    }

    public ArrayList<SanPham> getListCard() {
        return dlSanPham.getListObject("CardList");
    }

    //Tăng số sản phẩm
    public void plusNumberSP(ArrayList<SanPham> splist, int position, TDsoSP changeNumberItemsListener) {
        splist.get(position).setNumberInCart(splist.get(position).getNumberInCart() + 1);
        dlSanPham.putListObject("CardList", splist);
        changeNumberItemsListener.changed();
    }

    //Giảm số sản phẩm
    public void MinusNumerSP(ArrayList<SanPham> splist, int position, TDsoSP changeNumberItemsListener) {
        if (splist.get(position).getNumberInCart() == 1) {
            splist.remove(position);
        } else {
            splist.get(position).setNumberInCart(splist.get(position).getNumberInCart() - 1);
        }
        dlSanPham.putListObject("CardList", splist);
        changeNumberItemsListener.changed();
    }

    public long getTotalFee() {
        ArrayList<SanPham> splist2 = getListCard();
        long fee = 0;
        for (int i = 0; i < splist2.size(); i++) {
            fee = fee + (splist2.get(i).getFee() * splist2.get(i).getNumberInCart());
        }
        return fee;
    }

}
