package com.example.SweetLNP;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThongTin extends AppCompatActivity {

    EditText ten, gioitinh, namsinh, diachi, sdt, email;
    TextView btnluu;
    DBH DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin);
        DB = new DBH(this);

        ten = (EditText) findViewById(R.id.ten);
        gioitinh = (EditText) findViewById(R.id.gioitinh);
        diachi = (EditText) findViewById(R.id.diachi);
        namsinh = (EditText) findViewById(R.id.ngaysinh);
        sdt = (EditText) findViewById(R.id.sdt);
        email = (EditText) findViewById(R.id.email);
        btnluu = (TextView) findViewById(R.id.luu);

        Intent i = getIntent();
        String username = i.getStringExtra("user");

        Cursor db = DB.GetData1("SELECT * FROM thongtin where username=?", username);
        while (db.moveToNext()) {
            String tendb = db.getString(1);
            String namsinhdb = db.getString(2);
            String gioitinhdb = db.getString(3);
            String diachidb = db.getString(4);
            String sdtdb = db.getString(5);
            String emaildb = db.getString(6);

            ten.setText(tendb);
            namsinh.setText(namsinhdb);
            gioitinh.setText(gioitinhdb);
            diachi.setText(diachidb);
            sdt.setText(sdtdb);
            email.setText(emaildb);
        }

        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                String username = i.getStringExtra("user");
                String ten1 = ten.getText().toString();
                String namsinh1 = namsinh.getText().toString();
                String gioitinh1 = gioitinh.getText().toString();
                String diachi1 = diachi.getText().toString();
                String sdt1 = sdt.getText().toString();
                String email1 = email.getText().toString();

                if (ten1.equals("") || gioitinh1.equals("") || namsinh1.equals("") || diachi1.equals("") || sdt1.equals("") || email1.equals(""))
                    Toast.makeText(ThongTin.this, "Vui lòng nhập tất cả các trường", Toast.LENGTH_SHORT).show();
                else {
                    if (Patterns.EMAIL_ADDRESS.matcher(email1).matches()) {
                        if (sdt1.matches("[0-9]{10}")) {
                            Boolean insert2 = DB.updateData(username, ten1, namsinh1, gioitinh1, diachi1, sdt1, email1);
                            if (insert2 == true) {
                                Toast.makeText(ThongTin.this, "Lưu thành công", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Thongtincanhan.class);
                                intent.putExtra("user", username);
                                startActivity(intent);
                            } else {
                                Toast.makeText(ThongTin.this, "Lưu thất bại", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(ThongTin.this, "Số điện thoại không hợp lệ", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(ThongTin.this, "Email không hợp lệ ", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}

