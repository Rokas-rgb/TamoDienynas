package me.rockorbonk.tamodienynas;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class login{

    private static final String tamoDienynas = "https://dienynas.tamo.lt/api?UserName=rokasbruz&Password=Rokas123";

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(tamoDienynas))
                .build();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        String html = "<html><head><body><div style=\"font-size:24px;font-weight:bold;line-height:24px;\"> 10 </div></body></head></html>";

        Pattern pattern = Pattern.compile(".*<div style=\"font-size:24px;font-weight:bold;line-height:24px;\">(.*?)</div>.*");
        Matcher matcher = pattern.matcher(html);

        if (matcher.find()) {
            System.out.println(matcher.group(1));

        }
    }
}