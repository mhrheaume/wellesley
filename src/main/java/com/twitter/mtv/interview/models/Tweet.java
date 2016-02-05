package com.twitter.mtv.interview.models;

import twitter4j.Status;

public class Tweet {
    private Status tweet;

    public Tweet(Status tweet) {
        this.tweet = tweet;
    }

    public long id() { return tweet.getId(); }

    public String username() { return tweet.getUser().getScreenName(); }

    public String text() { return tweet.getText(); }

    public String toString() {
        return this.text();
    }
}
