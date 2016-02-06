package com.twitter.mtv.hackathon.services;

import com.twitter.mtv.hackathon.models.Tweet;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;

public class TwitterService {
  private final Twitter twitterApi;

  private final String consumerKey = "";
  private final String consumerSecret = "";
  private final String accessToken = "";
  private final String accessTokenSecret = "";

  public TwitterService(Twitter twitterApi) {
    this.twitterApi = twitterApi;
  }

  public TwitterService() {
    ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setDebugEnabled(true)
      .setOAuthConsumerKey(consumerKey)
      .setOAuthConsumerSecret(consumerSecret)
      .setOAuthAccessToken(accessToken)
      .setOAuthAccessTokenSecret(accessTokenSecret);

    TwitterFactory tf = new TwitterFactory(cb.build());
    twitterApi = tf.getInstance();
  }

  public List<Tweet> getUserTimeline() {
    ArrayList<Tweet> response = new ArrayList<Tweet>();
    try {
      for (Status tweet : twitterApi.getUserTimeline(586671909)) {
        response.add(new Tweet(tweet));
      }
    } catch (TwitterException e) {
      System.err.println("Error fetching user timeline");
      System.err.println(e);
    }

    return response;
  }
}
