package com.watermelon.login_example;

import android.os.Environment;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by watermelon on 19-3-22.
 */

public class UserInfoUtils {

    private static String userInfoPath = Environment.getExternalStorageDirectory().getPath();

    public static void writeUserInfo(String username, String password) {

        File file;
        FileOutputStream fileOutputStream;
        try {
            String result = username + "##" + password;

            file = new File(userInfoPath,"info.txt");
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(result.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            System.err.println(e);
            throw new RuntimeException("写入失败");
        }
    }



    public static Map<String,String> readUserInfo() {


        File file;
        FileReader fileReader;
        BufferedReader bufferedReader;
        try{
            file = new File(userInfoPath,"info.txt");
            if(!file.exists())
            {
                return null;
            }
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
        }catch (Exception e){
            System.err.println(e);
            throw new RuntimeException("读取用户信息出错");
        }
    }
}
