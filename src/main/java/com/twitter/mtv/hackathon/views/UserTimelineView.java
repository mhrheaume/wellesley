package com.twitter.mtv.hackathon.views;

import com.google.gson.Gson;
import com.twitter.mtv.hackathon.models.Tweet;

import java.util.ArrayList;
import java.util.List;

public class UserTimelineView {
  List<Tweet> tweets;

  public UserTimelineView(List<Tweet> tweets) {
    this.tweets = tweets;
  }

  public String render() {
    List<TweetView> tweetViews = new ArrayList<TweetView>();
    for (Tweet tweet : tweets) {
      tweetViews.add(new TweetView(tweet));
    }

    return new Gson().toJson(tweetViews);
  }

  public class TweetView {
    private long id;
    private String username;
    private String text;
    //add variable
    private String retweet;
    private String profpic;

    public TweetView(Tweet tweet) {
      this.id = tweet.id();
      this.username = tweet.username();
      this.text = tweet.text();
      //add retweet variable
      this.retweet = tweet.isRetweeted();
      this.profpic = tweet.getProfPicID();
    }
  }
}
