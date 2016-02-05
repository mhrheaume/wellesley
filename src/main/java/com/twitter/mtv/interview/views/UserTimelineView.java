package com.twitter.mtv.interview.views;

import com.google.gson.Gson;
import com.twitter.mtv.interview.models.Tweet;

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

    public TweetView(Tweet tweet) {
      this.id = tweet.id();
      this.username = tweet.username();
      this.text = tweet.text();
    }
  }
}
