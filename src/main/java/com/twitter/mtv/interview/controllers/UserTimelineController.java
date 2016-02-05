package com.twitter.mtv.interview.controllers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import com.twitter.mtv.interview.models.Tweet;
import com.twitter.mtv.interview.services.TwitterService;
import com.twitter.mtv.interview.views.UserTimelineView;

public class UserTimelineController implements HttpHandler {
  private TwitterService twitter;

  public UserTimelineController(TwitterService twitter) {
    this.twitter = twitter;
  }

  public void handle(HttpExchange t) throws IOException {
    List<Tweet> tweets = twitter.getUserTimeline();
    UserTimelineView view = new UserTimelineView(tweets);
    String response = view.render();

    byte[] bytes = response.getBytes("utf-8");
    t.sendResponseHeaders(200, bytes.length);
    OutputStream os = t.getResponseBody();
    os.write(bytes);
    os.close();
  }
}
