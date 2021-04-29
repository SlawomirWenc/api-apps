package com.example.apiapps;

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
}
