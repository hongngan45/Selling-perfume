package com.example.SweetLNP;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.Locale;

public class ChitietSanpham extends AppCompatActivity {
    private TextView themvaogiohang;
    private TextView tensp, giasp, thongtinsp, sosp;
    private ImageView plusBtn, minusBtn, anhsp;
    private SanPham object;
    private int soluong = 1;
    private QLGioHang quanlygiohang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet_sanpham);

        quanlygiohang = new QLGioHang(this);

        initView();//ánh xạ
        getBundle();//hiển thị và xử lý sự kiện
    }

    private void getBundle() {
        object = (SanPham) getIntent().getSerializableExtra("object");//Lấy dữ liệu object

        int drawableResourceId = this.getResources().getIdentifier(object.getPic(), "drawable", this.getPackageName());

        Glide.with(this)//Hiển thị ảnh ra image anhsp
                .load(drawableResourceId)
                .into(anhsp);

        tensp.setText(object.getTitle());//hiển thị tên sản phẩm ra text tensp

        Locale localeVN = new Locale("vi", "VN");//Định dạng sang số kiểu của nước việt nam
        NumberFormat en = NumberFormat.getInstance(localeVN);

        String gia = en.format(Long.valueOf(object.getFee()));//Định dạng
        giasp.setText(gia+"đ");
        thongtinsp.setText(object.getDescription());//hiển thị thông tin sản phẩm ra text thongtinsp
        sosp.setText(String.valueOf(soluong));//hiển thị số lượng ra text sosp

        //sự kiện nhấn nút cộng
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soluong = soluong + 1;
                sosp.setText(String.valueOf(soluong));//hiển thị số lượng ra text sosp
            }
        });

        //sự kiện nhấn nút trừ
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (soluong > 1) {
                    soluong = soluong - 1;
                }
                sosp.setText(String.valueOf(soluong));//hiển thị số lượng ra text sosp
            }
        });

        //sự kiện nhấn nút thêm vào giỏ hàng
        themvaogiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberInCart(soluong);//thêm số lượng
                quanlygiohang.insertSP(object);//thêm sản phẩm
            }
        });
    }
//ánh xạ
    private void initView() {
        themvaogiohang = findViewById(R.id.themvaogiohang);
        tensp = findViewById(R.id.tensp);
        giasp = findViewById(R.id.giasp);
        thongtinsp = findViewById(R.id.thongtinsp);
        sosp = findViewById(R.id.sosp);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        anhsp = findViewById(R.id.anhsp);
    }
}