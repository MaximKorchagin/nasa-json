package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();
        HttpGet request = new HttpGet("https://api.nasa.gov/planetary/apod?api_key=itb3lg7rBDHECa0dLPk2rYZogm4fJ08l5RszTbD9");
        CloseableHttpResponse response = httpClient.execute(request);

        InputStream content = response.getEntity().getContent();

        NASAResponse nasaResponse = objectMapper.readValue(content, new TypeReference<>() {
        });
        System.out.println(nasaResponse);

        HttpGet request2 = new HttpGet(nasaResponse.getUrl());
        CloseableHttpResponse response2 = httpClient.execute(request2);

        try (FileWriter fileWriter = new FileWriter("src/main/resources/response.txt")) {
            fileWriter.write(response2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        httpClient.close();
        content.close();



    }
}