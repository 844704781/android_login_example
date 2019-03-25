package com.watermelon.login_example;


import android.content.Context;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by watermelon on 19-3-22.
 */

public class UserInfoUtils {


    public static void writeUserInfo(Context context,String username, String password) {

        FileOutputStream fileOutputStream;
        try {
            String result = username + "##" + password;
            fileOutputStream=context.openFileOutput("info.txt",0);
            fileOutputStream.write(result.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("写入失败");
        }
    }

    public static Map<String, String> readUserInfo(Context context) {
        BufferedReader bufferedReader;
        FileInputStream inputStream;
        InputStreamReader inputStreamReader;
        try {
            inputStream = context.openFileInput("info.txt");
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String result = bufferedReader.readLine();
            String[] results = result.split("##");
            Map<String, String> maps = new HashMap<>();
            maps.put("username", results[0]);
            maps.put("password", results[1]);
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            return maps;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
