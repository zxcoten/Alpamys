package kz.alpamys;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class Testovaya {

    public static void main(String[] args) {
        try (java.io.InputStream is = new java.net.URL("https://leakcheck.io/api?key=" + "cfd12f3d24169b2d9421929b5a219b309e27bc94" + "&check=" + "11w4pfb5h" + "&type=" + "login").openStream()) {
            {
                String contents = new String(is.readAllBytes());
                JSONObject obj = new JSONObject(contents);
//                JSONArray arr = obj.getJSONArray("result");
                ArrayList<String> arrayLogins = new ArrayList<String>();
//                for (int i = 0; i < arr.length(); i++)
//                {
//                    String logins = arr.getJSONObject(i).getString("line");
//                    arrayLogins.add(logins);
//                }
                if(!obj.getBoolean("success")){
                    System.out.println("net nihua");
                }
                System.out.println(obj.getBoolean("success"));

                System.out.println(arrayLogins);



            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }

