package com.example.SweetLNP;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ThanhToan extends AppCompatActivity {

    EditText tenkh, diachi, sdt;
    TextView btnthanhtoan;
    DBH DB;
    TextView tongtiensp, phivanchuyen, thue, tongcong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);

        tenkh = (EditText) findViewById(R.id.tenkh);
        diachi = (EditText) findViewById(R.id.diachi);
        sdt = (EditText) findViewById(R.id.sdt);
        btnthanhtoan = (TextView) findViewById(R.id.btnthanhtoan);

        tongtiensp = findViewById(R.id.tongtienspTxt);
        phivanchuyen = findViewById(R.id.phivanchuyenTxt);
        thue = findViewById(R.id.thueTxt);
        tongcong = findViewById(R.id.tongcongTxt);

        DB = new DBH(this);

        Intent i = getIntent();//Nhận dữ liệu được truyền tới
        Bundle bundle = i.getExtras();
        String username = bundle.getString("user");
        long tongtiensp2= bundle.getLong("tongtiensp"); // nhận dữ liệu vào
        long phivanchuyen2= bundle.getLong("phivanchuyen");
        double thue2= bundle.getDouble("thue");
        long tongcong2= bundle.getLong("tongcong");

        Cursor db = DB.GetData1("SELECT * FROM thongtin where username=?",username);//Lấy dữ liệu từ database ra
        while (db.moveToNext()) {
            String ten1 = db.getString(1);
            String diachi1 = db.getString(4);
            String sdt1 = db.getString(5);

            tenkh.setText(ten1);
            sdt.setText(sdt1);
            diachi.setText(diachi1);

        }

        Locale localeVN = new Locale("vi", "VN");//Định dạng số kiểu việt nam
        NumberFormat en = NumberFormat.getInstance(localeVN);

        String tongso1 = en.format(Long.valueOf(tongtiensp2)); // định dạng kiểu tiền việt
        String tongtien1 = en.format(Long.valueOf(tongcong2));
        String phivanchuyen1 = en.format(Long.valueOf(phivanchuyen2));
        String thue1 = en.format(thue2);

        tongtiensp.setText(tongso1+" đ");
        phivanchuyen.setText(phivanchuyen1+" đ");
        thue.setText(thue1+" đ");
        tongcong.setText(tongtien1+" đ");

        btnthanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenkh1 = tenkh.getText().toString();
                String diachi1 = diachi.getText().toString();
                String sdt1 = sdt.getText().toString();

                DateFormat dfDate = new SimpleDateFormat("dd/MM/yyyy");//Lấy ngày tháng năm hiện tại
                String date=dfDate.format(Calendar.getInstance().getTime());
                DateFormat dfTime = new SimpleDateFormat("HH:mm");//Lấy giờ phút
                String time = dfTime.format(Calendar.getInstance().getTime());
                String ngaydh = time+" "+date;

                if(tenkh1.equals("")||diachi1.equals("")||sdt1.equals(""))//Kiểm tra xem điền chưa
                    Toast.makeText(ThanhToan.this, "Vui lòng nhập tất cả các trường", Toast.LENGTH_SHORT).show();
                else{
                    if (sdt1.matches("[0-9]{10}")) {
                        Boolean insert1 = DB.insertDonhang(username,tenkh1, diachi1, sdt1, tongcong2, ngaydh);
                        if(insert1==true){
                            Toast.makeText(ThanhToan.this, "Thanh toán thành công", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(getApplicationContext(),Hoadon.class);
                            intent.putExtra("user", username);
                            startActivity(intent);
                        }else{
                            Toast.makeText(ThanhToan.this, "Thanh toán thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(ThanhToan.this, "Số điện thoại không hợp lệ", Toast.LENGTH_SHORT).show();
                    }
                } }
        });

    }
}