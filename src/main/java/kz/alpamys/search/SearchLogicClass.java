package kz.alpamys.search;

import org.json.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class SearchLogicClass{
    String API_KEY = "cfd12f3d24169b2d9421929b5a219b309e27bc94";

    public ArrayList<String> doSmth(String value, String type){
        try (java.io.InputStream is = new java.net.URL("https://leakcheck.io/api?key=" + API_KEY + "&check=" + value + "&type=" + type).openStream()) {
            {
                String contents = new String(is.readAllBytes());
                JSONObject obj = new JSONObject(contents);
                JSONArray arr = obj.getJSONArray("result");
                ArrayList<String> arrayLogins = new ArrayList<String>();
                boolean flag = obj.getBoolean("success");
                boolean test1 = obj.getBoolean("success");
                System.out.println(test1);
                if (!flag) {
                    arrayLogins.add("empty");
                    System.out.println("4to to skazhi");
                } else {
                    for (int i = 0; i < arr.length(); i++) {
                        String logins = arr.getJSONObject(i).getString("line");
                        arrayLogins.add(logins);
                    }


                }
                return arrayLogins;
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
