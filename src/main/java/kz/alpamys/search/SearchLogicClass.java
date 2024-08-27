package kz.alpamys.search;

import org.json.*;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class SearchLogicClass{
    String API_KEY = "cfd12f3d24169b2d9421929b5a219b309e27bc94";

    public String doSmth(String value, String type){
        try (InputStream is = new URL("https://leakcheck.io/api?key=" + API_KEY + "&check=" + value + "&type=" + type).openStream()) {
            {
                String contents = new String(is.readAllBytes());
                JSONObject obj = new JSONObject(contents);
                ArrayList<String> arrayLogins = new ArrayList<String>();
                boolean flag = obj.getBoolean("success");
                if (!flag) {
                    arrayLogins.add("Данных по вашему запросу не найдено!");
                } else {
                    JSONArray arr = obj.getJSONArray("result");
                    for (int i = 0; i < arr.length(); i++) {
                        String logins = arr.getJSONObject(i).getString("line");
                        arrayLogins.add(logins);
                    }


                }

                return arrayLogins.toString();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
