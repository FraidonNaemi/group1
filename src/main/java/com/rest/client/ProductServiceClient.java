package com.rest.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ProductServiceClient {

    
    public static String getProduct(int productID) throws MalformedURLException, IOException {
        URL uri = new URL("http://localhost:8080/group1/rest/sqlapi/product/productID/"+ productID);
        HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/xml");

        if (connection.getResponseCode() != 200) {
            throw new RuntimeException("Failed: HTTP error code: " + connection.getInputStream());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        File file = new File("C:\\group1\\src\\main\\webapp\\WEB-INF\\productID.xml");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);

        String output = "";
        while ((output = br.readLine()) != null) {
         
            bw.write(output);
        

        }

        bw.close();
        connection.disconnect();
        return file.getAbsolutePath();
    }
    

}
