package com.example.bandodientu;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Hoadon extends AppCompatActivity {
    DBH DB;
    ListView listview;
    ArrayList<ttdonhang> arrayList;
    TTHoaDonAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoadon);
        Intent i = getIntent();//Lấy giữ liệu được truyền đến
        String username =i.getStringExtra("user");

        listview = (ListView)  findViewById(R.id.listhd);
        arrayList = new ArrayList<>();
        adapter = new TTHoaDonAdapter(this, R.layout.tthoadon, arrayList);
        listview.setAdapter(adapter);
        DB = new DBH(this);

        Cursor db = DB.GetData1("SELECT * FROM donhang where username=?",username);
        if(db.getCount()>0){
            while (db.moveToNext()){//Con trỏ sẽ trỏ từng dòng 1
                String tenkh = db.getString(1);
                String diachi = db.getString(2);
                String sdt = db.getString(3);
                Long tongtien = db.getLong(4);
                String ngaydh = db.getString(5);
                arrayList.add(new ttdonhang(tenkh, diachi, sdt, tongtien,ngaydh));//thêm vào mảng
            }
            adapter.notifyDataSetChanged();//load lại dữ liệu trong giao diện
        }else{
            Toast.makeText(Hoadon.this, "Chưa có hóa đơn nào!", Toast.LENGTH_SHORT).show();
        }

        bottomNavigation();
    }

    private void bottomNavigation() {
        FloatingActionButton giohang = findViewById(R.id.giohang);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout hoadon =  findViewById(R.id.hoadon);

        //sự kiện ấn nút giỏ hàng
        giohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = getIntent();
                String user=i.getStringExtra("user");

                Intent intent  = new Intent(getApplicationContext(), GioHang.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                String user=i.getStringExtra("user");
                Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });

        hoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                String user=i.getStringExtra("user");
                Intent intent  = new Intent(getApplicationContext(), Hoadon.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });

    }
}