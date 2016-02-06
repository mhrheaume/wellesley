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

  private final String consumerKey = "GYu1tAS67PImQPfFB3KLktG1z";
  private final String consumerSecret = "XcZ7DmG0MHbEu5N14m4dtXg75v2sT97e2Iw5ovujcwKvlJbp3T";
  private final String accessToken = "4880128883-2Z4U2UpryEZdj53JaWLD2LBx0PySnd1faaedFZT";
  private final String accessTokenSecret = "FRKtxzP6bDfIWeMm5LJeRMQxPTwBMF6k9ZyjDmQiTPq4S";

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
      for (Status tweet : twitterApi.getUserTimeline("HillaryClinton")) {
        response.add(new Tweet(tweet));
      }
    } catch (TwitterException e) {
      System.err.println("Error fetching user timeline");
      System.err.println(e);
    }

    return response;
  }
}
