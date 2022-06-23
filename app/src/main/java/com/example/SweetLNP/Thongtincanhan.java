package com.example.SweetLNP;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Thongtincanhan extends AppCompatActivity {
    DBH DB;
    TextView ten, namsinh, gioitinh, diachi, sdt, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtincanhan);

        ten = findViewById(R.id.ten);
        namsinh = findViewById(R.id.namsinh);
        gioitinh = findViewById(R.id.gioitinh);
        diachi = findViewById(R.id.diachi);
        sdt = findViewById(R.id.sdt);
        email = findViewById(R.id.email);

        Intent i = getIntent();
        String username=i.getStringExtra("user");

        DB = new DBH(this);

        Cursor db = DB.GetData1("SELECT * FROM thongtin where username=?",username);
        while (db.moveToNext()) {
            String ten1 = db.getString(1);
            String namsinh1 = db.getString(2);
            String gioitinh1 = db.getString(3);
            String diachi1 = db.getString(4);
            String sdt1 = db.getString(5);
            String email1 = db.getString(6);

            if(ten1==null){
                ten.setText("Chưa thêm tên");
            }
            else{
                ten.setText(ten1);
            }
            if(namsinh1==null){
                namsinh.setText("Chưa thêm năm sinh");
            }
            else{
                namsinh.setText(namsinh1);
            }
            if(gioitinh1==null){
                gioitinh.setText("Chưa thêm giới tính");
            }
            else{
                gioitinh.setText(gioitinh1);
            }
            if(diachi1==null){
                diachi.setText("Chưa thêm địa chỉ");
            }
            else{
                diachi.setText(diachi1);
            }
            if(sdt1==null){
                sdt.setText("Chưa thêm điện thoại");
            }
            else{
                sdt.setText(sdt1);
            }
            if(email1==null){
                email.setText("Chưa thêm email");
            }
            else{
                email.setText(email1);
            }

        }


        TextView sua = findViewById(R.id.sua);
        TextView dangxuat = findViewById(R.id.dangxuat);

        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getApplicationContext(), ThongTin.class);
                intent.putExtra("user", username);
                startActivity(intent);
            }
        });
        dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Thongtincanhan.this, DangNhap.class));
            }
        });

    }
}