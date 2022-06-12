package com.example.bandodientu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBH extends SQLiteOpenHelper {

    public static final String DBNAME = "banhang.db";//Tạo database

    public DBH( Context context) {
        super(context, "banhang.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {//Tạo các bảng
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        MyDB.execSQL("create Table donhang(username TEXT, tenkh TEXT, diachi TEXT, sdt TEXT, tongtien Long, ngaydh TEXT)");
        MyDB.execSQL("create Table thongtin(username TEXT primary key, tenkh TEXT, namsinh TEXT,gioitinh TEXT, diachi TEXT, sdt TEXT, email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {//Xóa bảng nếu tồn tại và tạo lại
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists donhang");
        MyDB.execSQL("drop Table if exists thongtin");
        onCreate(MyDB);
    }

    //Thêm dữ liệu các cột vào bảng donhang
    public Boolean insertDonhang(String username, String tenkh, String diachi, String sdt, Long tongtien, String ngaydh ){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("tenkh", tenkh);
        contentValues.put("diachi", diachi);
        contentValues.put("sdt", sdt);
        contentValues.put("tongtien", tongtien);
        contentValues.put("ngaydh", ngaydh);

        long result = MyDB.insert("donhang", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }
    //Thêm dữ liệu các cột vào bảng thong tin
    public Boolean insertThongtin(String username, String ten, String namsinh, String gioitinh, String diachi, String sdt, String email ){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("tenkh", ten);
        contentValues.put("namsinh", namsinh);
        contentValues.put("gioitinh", gioitinh);
        contentValues.put("diachi", diachi);
        contentValues.put("sdt", sdt);
        contentValues.put("email", email);

        long result = MyDB.insert("thongtin", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }
    //Sửa dữ liệu các cột
    public Boolean updateData(String username, String ten,String namsinh, String gioitinh,  String diachi, String sdt, String email ){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues updValues= new ContentValues();
        updValues.put("tenkh", ten);
        updValues.put("namsinh", namsinh);
        updValues.put("gioitinh", gioitinh);
        updValues.put("diachi", diachi);
        updValues.put("sdt", sdt);
        updValues.put("email", email);

        Cursor cursor=MyDB.rawQuery("Select * from thongtin where username=?",new String[] {username});
        if(cursor.getCount()>0){
            long result = MyDB.update("thongtin",  updValues, "username=?" ,new String[] {username});
            if(result==-1)
                return false;
            else
                return true;
        }
        else{
            return false;
        }
    }
    //Thêm dữ liệu các cột vào bảng users
    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    /*public Cursor GetData(String sql){
        SQLiteDatabase MyDB = getReadableDatabase();
        return MyDB.rawQuery(sql,null);
    }*/

    //Lấy dữ liệu
    public Cursor GetData1(String sql, String username){
        SQLiteDatabase MyDB = getReadableDatabase();
        return MyDB.rawQuery(sql, new String[]{username});
    }

//Kiểm tra tài khoản
    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
//Kiểm tra mật khẩu
    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

}
