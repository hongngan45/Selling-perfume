package com.example.bandodientu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DangKi extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup, signin;
    DBH DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.btnsignup);
        signin = (Button) findViewById(R.id.btnsignin);
        DB = new DBH(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(DangKi.this, "Vui lòng nhập tất cả các trường", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert==true){
                                Boolean insert1= DB.insertThongtin(user,null,null,null,null,null,null);
                                if(insert1==true){
                                    //Toast.makeText(DangKi.this, "Them thành công", Toast.LENGTH_SHORT).show();
                                    Toast.makeText(DangKi.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),DangNhap.class);
                                    startActivity(intent);
                                }
                                else {
                                    Toast.makeText(DangKi.this, "K thành công", Toast.LENGTH_SHORT).show();
                                }

                            }else{
                                Toast.makeText(DangKi.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(DangKi.this, "Người dùng đã tồn tại!", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(DangKi.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                    }
                } }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DangNhap.class);
                startActivity(intent);
            }
        });
    }
}