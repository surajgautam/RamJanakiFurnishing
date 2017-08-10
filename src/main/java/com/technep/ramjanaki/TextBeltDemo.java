package com.technep.ramjanaki;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class TextBeltDemo {
    public static String sendSms() {
        try {

//            http://api.txtlocal.com/docs/sendsms
            // Construct data
            String apiKey = "apikey=" + "";
            String message = "&message=" + "Thank you for signing with Ramjanaki furnishing";
            String sender = "&sender=" + "RamJanaki Furnishing";
            String numbers = "&numbers=" + "+";

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
            }
            rd.close();

            return stringBuffer.toString();
        } catch (Exception e) {
            System.out.println("Error SMS "+e);
            return "Error "+e;
        }
    }

    public static void main(String[] args) {
        System.out.println(sendSms());
    }
}