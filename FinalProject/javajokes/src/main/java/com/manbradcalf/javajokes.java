package com.manbradcalf;

import java.util.Random;

public class javajokes {

    public static final String[] SET_VALUES = new String[] {
            "If you’re a young Mafia gangster out on your first date, I bet it’s real embarrassing if someone tries to kill you.",
            "It’s funny that pirates were always going around searching for treasure, and they never realized that the real treasure was the fond memories they were creating.",
            "To me, clowns aren’t funny. In fact, they’re kind of scary. I’ve wondered where this started and I think it goes back to the time I went to the circus, and a clown killed my dad.",
            "If you ever fall off the Sears Tower, just go real limp, because maybe you’ll look like a dummy and people will try to catch you because, hey, free dummy.",
            "Before you criticize someone, you should walk a mile in their shoes. That way, when you criticize them, you’re a mile away and you have their shoes.",
            "Children need encouragement. If a kid gets an answer right, tell him it was a lucky guess. That way he develops a good, lucky feeling.",
            "I hope if dogs ever take over the world, and they chose a king, they don’t just go by size, because I bet there are some Chihuahuas with some good ideas.",
            "Maybe in order to understand mankind, we have to look at the word itself. Basically, it's made up of two separate words — \"mank\" and \"ind.\" What do these words mean? It's a mystery, and that's why so is mankind.",
            "If a kid asks where rain comes from, I think a cute thing to tell him is \"God is crying.\" And if he asks why God is crying, another cute thing to tell him is \"Probably because of something you did.\" "
    };

    public String getJoke() {
        Random random = new Random();
        int index = random.nextInt(SET_VALUES.length);
        return SET_VALUES[index];
    }
}
