package com.twitter.mtv.hackathon;

import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

import com.twitter.mtv.hackathon.controllers.IndexController;
import com.twitter.mtv.hackathon.controllers.UserTimelineController;
import com.twitter.mtv.hackathon.services.TwitterService;

public class App {
  public static void main(String[] args) throws Exception {
    TwitterService twitter = new TwitterService();

    HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
    server.createContext("/", new IndexController());
    server.createContext("/vine", new UserTimelineController(twitter));
    server.setExecutor(null);

    System.out.println("Starting server on port 8000");
    server.start();
  }
}
