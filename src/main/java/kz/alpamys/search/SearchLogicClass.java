package kz.alpamys.search;

import org.json.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class SearchLogicClass{

    public ArrayList<String> doSmth(String value, String type){
        try (java.io.InputStream is = new java.net.URL("https://leakcheck.io/api?key=f1582185ff143821025c20f3b0a3a9fd0263d9d6&check=" + value + "&type=" + type).openStream()) {
            {
                String contents = new String(is.readAllBytes());
                JSONObject obj = new JSONObject(contents);
                JSONArray arr = obj.getJSONArray("result");
                ArrayList<String> arrayLogins = new ArrayList<String>();
                for (int i = 0; i < arr.length(); i++)
                {
                    String logins = arr.getJSONObject(i).getString("line");
                    arrayLogins.add(logins);
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
