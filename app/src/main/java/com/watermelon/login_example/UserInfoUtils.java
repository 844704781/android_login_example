package com.watermelon.login_example;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by watermelon on 19-3-22.
 */

public class UserInfoUtils {

    private static String userInfoPath = "/data/data/com.watermelon.login_example/user_info.txt";

    public static void writeUserInfo(String username, String password) {

        File file;
        FileOutputStream fileOutputStream;
        try {
            String result = username + "##" + password;

            file = new File(userInfoPath);
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(result.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("写入失败");
        }
    }

    public static Map<String,String> readUserInfo() {
        File file;
        FileReader fileReader;
        BufferedReader bufferedReader;
        try{
            file = new File(userInfoPath);
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
            e.printStackTrace();
            throw new RuntimeException("读取用户信息出错");
        }
    }
}