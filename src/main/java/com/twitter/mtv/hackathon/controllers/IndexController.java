package com.twitter.mtv.hackathon.controllers;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import com.twitter.mtv.hackathon.views.IndexView;

public class IndexController implements HttpHandler {
  public IndexController() {
  }

  public void handle(HttpExchange t) throws IOException {
    String response = new IndexView().render();

    byte[] bytes = response.getBytes("utf-8");
    t.sendResponseHeaders(200, bytes.length);
    OutputStream os = t.getResponseBody();
    os.write(bytes);
    os.close();
  }
}
