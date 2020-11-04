package com.hyva.idm.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ThirdPartyAccessTokenService {

    public static String getAccessToken() {
        URL url;
        HttpURLConnection con;
        String accessToken = null;
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet("https://api.flipkart.net/oauth-service/oauth/token?grant_type=client_credentials&scope=Seller_Api" +
                    "&client_id=295710645724946a049a984261a541b3340&client_secret=8e0dc6fbc11df702f967ba3500becbc0");
            HttpResponse response;
            try {
                response = client.execute(request);
               // response.getStatusLine().getStatusCode()

                // Get the response
                BufferedReader br;

                br = new BufferedReader(new InputStreamReader(response
                        .getEntity().getContent()));

                String line = "";
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedOperationException e) {
                e.printStackTrace();
            }
//        Map<String, String> map = handleResponse(con);
//        accessToken = map.get(OAuthConstants.ACCESS_TOKEN);
        return accessToken;

    }




}
