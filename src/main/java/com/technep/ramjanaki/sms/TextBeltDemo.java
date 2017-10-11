package com.technep.ramjanaki.sms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Random;


public class TextBeltDemo {

    public static String sendSms(Integer code,String number) {
        try {

//            http://api.txtlocal.com/docs/sendsms
            // Construct data
            String apiKey = "apikey=" + "Fe2K522x5+4-CJVNGSCluYcJRKCIVDNVfXemoht7Zn";
            /*Random random = new Random();
            Integer code =  10000 + random.nextInt(99999);*/
            String message = "&message=" + "Thank you for signing with Ramjanaki furnishing.Your verification code is "+ code;
            String sender = "&sender=" + "RamJanaki Furnishing";
            String numbers = "&numbers=" + "+977"+number;

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
            System.out.println("MESSAGE SENDING SUCCESSFULLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
            return stringBuffer.toString();

        } catch (Exception e) {
            System.out.println("Error SMS "+e);
            return "Error "+e;
        }
    }

    }