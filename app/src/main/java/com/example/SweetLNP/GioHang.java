package com.example.SweetLNP;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.NumberFormat;
import java.util.Locale;

public class GioHang extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private QLGioHang quanlygiohang;
    private TextView tongtienspTxt, thueTxt, phivanchuenTxt, tongcongTxt, thetrongTxt;
    private double thue;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);

        quanlygiohang = new QLGioHang(this);

        initView();
        initList();
        calculateCard();
        bottomNavigation();
    }
    private void bottomNavigation() {
        FloatingActionButton giohang = findViewById(R.id.giohang);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        Button dathangbtn =  findViewById(R.id.btndDathang);
        LinearLayout hoadon =  findViewById(R.id.hoadon);

        giohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = getIntent();
                String user=i.getStringExtra("user");

                Intent intent  = new Intent(GioHang.this, GioHang.class);
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
//s??? ki???n ???n n??t ?????t h??ng
        dathangbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String user=intent.getStringExtra("user");//g??n user cho bi???n user
                double phantramphi = 0.02;
                int phivanchuyen = 15000;

                thue = Math.round((quanlygiohang.getTotalFee() * phantramphi));
                long tongcong = Math.round((quanlygiohang.getTotalFee() + thue + phivanchuyen) );
                long tongtiensp = Math.round(quanlygiohang.getTotalFee());
                Intent i = new Intent(GioHang.this, ThanhToan.class);//Chuy???n sang giao di???n thanh to??n
                Bundle bundle = new Bundle();//Truy???n c??c d??? li???u sang Thanhtoan
                bundle.putString("user",user);
                bundle.putLong("tongtiensp", tongtiensp);
                bundle.putLong("phivanchuyen", phivanchuyen);
                bundle.putDouble("thue", thue);
                bundle.putLong("tongcong", tongcong);
                i.putExtras(bundle);
                startActivity(i);

            }
        });
    }
    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new DsGioHangAdapter(quanlygiohang.getListCard(), this, new TDsoSP() {
            @Override
            public void changed() {
                calculateCard();//Hi???n th??? c??c th??ng tin v??o c??c textview
            }
        });

        recyclerViewList.setAdapter(adapter);
        if (quanlygiohang.getListCard().isEmpty()) {//n???u k c?? ????n h??ng
            thetrongTxt.setVisibility(View.VISIBLE);//hi???n thetrongTxt
            scrollView.setVisibility(View.GONE);//???n scrollview
        } else {
            thetrongTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }


    private void calculateCard() {
        double phantramphi = 0.02;
        int phivanchuyen = 15000;

        thue = Math.round((quanlygiohang.getTotalFee() * phantramphi));
        long tongtien = Math.round((quanlygiohang.getTotalFee() + thue + phivanchuyen) );
        long tongso = Math.round(quanlygiohang.getTotalFee() );

        Locale localeVN = new Locale("vi", "VN");//?????nh d???ng gi?? ti???n ki???u vi???t nam
        NumberFormat en = NumberFormat.getInstance(localeVN);

        String tongso1 = en.format(Long.valueOf(tongso));
        String tongtien1 = en.format(Long.valueOf(tongtien));
        String phivanchuyen1 = en.format(Long.valueOf(phivanchuyen));
        String thue1 = en.format(thue);

        tongtienspTxt.setText("" + tongso1 +" ??" );
        thueTxt.setText("" + thue1 + " ??");
        phivanchuenTxt.setText("" + phivanchuyen1 + " ??");
        tongcongTxt.setText("" + tongtien1 + " ??");
    }

    private void initView() {
        recyclerViewList = findViewById(R.id.recyclerview);
        tongtienspTxt = findViewById(R.id.tongtienspTxt);
        thueTxt = findViewById(R.id.thueTxt);
        phivanchuenTxt = findViewById(R.id.phivanchuyenTxt);
        tongcongTxt = findViewById(R.id.tongcongTxt);
        thetrongTxt = findViewById(R.id.thetrongTxt);
        scrollView = findViewById(R.id.scrollView4);
    }
}