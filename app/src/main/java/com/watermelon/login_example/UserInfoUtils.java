package com.watermelon.login_example;


import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by watermelon on 19-3-22.
 */

public class UserInfoUtils {


    public static void writeUserInfo(Context context,String username, String password) {
        SharedPreferences sp=context.getSharedPreferences("user",context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("username",username);
        editor.putString("password",password);
        editor.commit();
    }

    public static Map<String,String> readUserInfo(Context context) {
        SharedPreferences sp=context.getSharedPreferences("user",context.MODE_PRIVATE);
        String username=sp.getString("username",null);
        String password=sp.getString("password",null);

        if(username==null||"".equals(username))
        {
            return null;
        }
        Map<String,String>map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        return map;
    }

    public static boolean readState(Context context) {
        SharedPreferences sp=context.getSharedPreferences("user",context.MODE_PRIVATE);
        return sp.getBoolean("state",false);
    }

    public static void writeState(Context context, boolean b) {
        SharedPreferences sp=context.getSharedPreferences("user",context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putBoolean("state",b);
        editor.commit();
    }
}
