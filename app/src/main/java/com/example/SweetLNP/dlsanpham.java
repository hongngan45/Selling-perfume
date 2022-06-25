package com.example.SweetLNP;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;

public class dlsanpham {
    private SharedPreferences preferences;
    public dlsanpham(Context appContext) {
        preferences = PreferenceManager.getDefaultSharedPreferences(appContext);
    }

    public ArrayList<String> getListString(String key) {
        return new ArrayList<String>(Arrays.asList(TextUtils.split(preferences.getString(key, ""), "‚‗‚")));
    }

    public ArrayList<SanPham> getListObject(String key){//Lấy dữ liệu ra
        Gson gson = new Gson();
        ArrayList<String> objStrings = getListString(key);
        ArrayList<SanPham> playerList =  new ArrayList<SanPham>();

        for(String jObjString : objStrings){
            SanPham player  = gson.fromJson(jObjString,  SanPham.class);
            playerList.add(player);
        }
        return playerList;
    }

    public void putListString(String key, ArrayList<String> stringList) {
        checkForNullKey(key);
        String[] myStringList = stringList.toArray(new String[stringList.size()]);
        preferences.edit().putString(key, TextUtils.join("‚‗‚", myStringList)).apply();
    }

    public void putListObject(String key, ArrayList<SanPham> playerList){//Thêm dữ liệu vào
        checkForNullKey(key);
        Gson gson = new Gson();
        ArrayList<String> objStrings = new ArrayList<String>();
        for(SanPham player: playerList){
            objStrings.add(gson.toJson(player));
        }
        putListString(key, objStrings);
    }

    private void checkForNullKey(String key){
        if (key == null){
            throw new NullPointerException();
        }
    }

}

