package kz.alpamys.search;

import com.fasterxml.jackson.core.JsonParser;
import org.mortbay.util.ajax.JSON;

import java.io.IOException;
import java.net.MalformedURLException;

public class SearchLogicClass{
 String emailOfInput;
 String typeOfInput;
    public void doSmth(String value, String type){
        try (java.io.InputStream is = new java.net.URL("https://leakcheck.io/api?key=f1582185ff143821025c20f3b0a3a9fd0263d9d6&check=" + value + "&type=" + type).openStream()) {
            {
                String contents = new String(is.readAllBytes());
                System.out.println(contents);
                JsonParser parser;
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
