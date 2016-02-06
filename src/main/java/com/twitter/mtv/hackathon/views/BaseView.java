package com.twitter.mtv.hackathon.views;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.StringWriter;

public abstract class BaseView {
  private static final String TEMPLATE_ROOT = "templates/";

  private final Mustache mustache;

  public BaseView(String templateName) {
    MustacheFactory mf = new DefaultMustacheFactory();
    mustache = mf.compile(TEMPLATE_ROOT + templateName);
  }

  public abstract String render();

  protected String render(Object renderable) {
    StringWriter stringWriter = new StringWriter();
    mustache.execute(stringWriter, renderable);
    return stringWriter.toString();
  }
}
