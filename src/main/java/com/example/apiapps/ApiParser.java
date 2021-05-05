package com.example.apiapps;

import com.example.apiapps.jobSearchApp.model.Job;
import com.example.apiapps.jokeApp.model.Joke;
import com.google.gson.Gson;
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
        String stringURL = "https://jobs.github.com/positions.json?search=" + search + "&location=" + location;
        URL url = new URL(stringURL);
        InputStreamReader reader = new InputStreamReader(url.openStream());
        Job[] job = new Gson().fromJson(reader, Job[].class);
        return job;
    }
}
