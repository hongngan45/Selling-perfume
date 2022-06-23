package com.example.SweetLNP;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Animation topAnim, bottomAnim;
        ImageView image;
        TextView text;

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();//ẩn actionbar

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);//gán animation
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);//gán animation

        image = findViewById(R.id.image1);
        text = findViewById(R.id.gaabor);

        image.setAnimation(topAnim);//thực hiện animation cho image
        text.setAnimation(bottomAnim);//thực hiện animation cho text

        new Handler().postDelayed(new Runnable() {//chuyển sang active Dangnhap sau 3 giây
            @Override
            public void run() {
                startActivity(new Intent(intro.this, DangNhap.class));
                finish();
            }
        }, 3000);
    }
}