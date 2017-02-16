package com.udacity.gradle.builditbigger.free;

/**
 * Created by ben.medcalf on 2/16/17.
 */

public class JokeRetrievedEvent
{

    String joke;

    public JokeRetrievedEvent(String joke)
    {
        this.joke = joke;
    }

    public String getJoke()
    {
        return joke;
    }
}
