package com.watermelon.login_example;


import android.content.Context;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by watermelon on 19-3-22.
 */

public class UserInfoUtils {

    private static String userInfoPath = "/data/data/com.watermelon.login_example/user_info.txt";

    public static void writeUserInfo(Context context,String username, String password) {

        File file;
        FileOutputStream fileOutputStream;
        try {
            String result = username + "##" + password;

            String path=context.getFilesDir().getPath();
            file = new File(path,"user_info.txt");
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(result.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("写入失败");
        }
    }

    public static Map<String,String> readUserInfo(Context context) {
        File file;
        FileReader fileReader;
        BufferedReader bufferedReader;
        try{
            String path = context.getFilesDir().getPath();
            file = new File(path,"user_info.txt");
            if(file.exists())
            {
                fileReader=new FileReader(file);
                bufferedReader=new BufferedReader(fileReader);
                String result=bufferedReader.readLine();
                String[] results=result.split("##");
                Map<String ,String> maps =new HashMap<>();
                maps.put("username",results[0]);
                maps.put("password",results[1]);
                bufferedReader.close();
                fileReader.close();
                return maps;
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("读取用户信息出错");
        }
        return null;
    }
}
