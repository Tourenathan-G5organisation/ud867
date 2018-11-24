package com.tourenathan.bakingapp.lib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JokeProvider {

    private static Iterator<String> jokeIterator;

    public static String getNextJoke() {
        List<String> jokesData = jokesList();
        if (jokesData.size() != 0) {
            if (jokeIterator == null) {
                jokeIterator = jokesList().iterator();
            }
            if (!jokeIterator.hasNext()) {
                jokeIterator = jokesList().iterator();
            }
            return jokeIterator.next();
        }

        return null;

    }

    private static List<String> jokesList() {
        List<String> jokes = new ArrayList<>();
        jokes.add("You are very funny");
        jokes.add("I'm sure you didn't know that.");
        jokes.add("Me too i'm funny");
        jokes.add("Here is joke 4");
        jokes.add("Here is joke 5");
        jokes.add("Here is joke 6");
        jokes.add("Here is joke 7");
        jokes.add("Here is joke 8");
        jokes.add("Here is joke 9");
        jokes.add("Here is joke 10");
        return jokes;
    }
}
