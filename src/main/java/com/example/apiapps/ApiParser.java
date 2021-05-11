package com.example.apiapps;

import com.example.apiapps.jobSearchApp.model.Job;
import com.example.apiapps.jokeApp.model.Joke;
import com.example.apiapps.urlShorterApp.model.Link;
import com.example.apiapps.urlShorterApp.model.ShorterLinkData;
import com.google.gson.Gson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ApiParser {

    public static Joke getJokeFromApi() throws IOException {
        URL url = new URL("https://official-joke-api.appspot.com/random_joke");
        InputStreamReader reader = new InputStreamReader(url.openStream());
        Joke joke = new Gson().fromJson(reader, Joke.class);
        return joke;
    }

    public static Job[] getJobFromApi(String search, String location) throws IOException {

        String stringURL = "https://jobs.github.com/positions.json?";
        if(!search.equals("")){
            stringURL += "search=" + search;
        }
        if(!location.equals("")){
            if(!search.equals("")){
                stringURL += "&";
            }
            stringURL += "location=" + location;
        }
        URL url = new URL(stringURL);
        InputStreamReader reader = new InputStreamReader(url.openStream());
        Job[] job = new Gson().fromJson(reader, Job[].class);
        return job;
    }

    public static String getLink(String value){
        RestTemplate restTemplate = new RestTemplate();
        Link link =  new Link(value);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer <API KEY>");

        HttpEntity<Link> request = new HttpEntity<>(link, headers);

        ShorterLinkData linkData = restTemplate.postForObject("https://api-ssl.bitly.com/v4/shorten", request, ShorterLinkData.class);
        return linkData.getLink();
    }
}
