package com.twitter.mtv.hackathon.models;

import twitter4j.Status;
// new class: User
import twitter4j.User;

public class Tweet {
    private Status tweet;
    // new var
    private User user;

    public Tweet(Status tweet) {
        this.tweet = tweet;
        this.user = tweet.getUser();
    }

    public long id() { return tweet.getId(); }

    public String username() { return tweet.getUser().getScreenName(); }

    public String text() { return tweet.getText(); }

    //adding to Status
    public String isRetweeted() { 
        if (tweet.isRetweet()) {
            return "http://bizbest.wpengine.netdna-cdn.com/wp-content/uploads/2012/12/retweet.jpg";
        } else { return "https://pbs.twimg.com/profile_images/1221566601/Sad_Bird.jpg"; } 
    }

    //get url to profile picture
    public String getProfPicID() {
        return user.getMiniProfileImageURLHttps();
    }

    public String toString() {
        return this.text();
    }
}
