package giter.jackalope.utils;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.core.Environment;
import freemarker.ext.servlet.HttpRequestHashModel;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import giter.jackalope.model.Attributes;
import giter.jackalope.model.Block;

public class TemplateLoader {

  static Configuration conf = new Configuration();

  static {

    conf.setClassForTemplateLoading(TemplateLoader.class, "/ftl");
    conf.setDefaultEncoding("UTF-8");
    conf.setTagSyntax(Configuration.SQUARE_BRACKET_TAG_SYNTAX);
    conf.setURLEscapingCharset("UTF-8");
    conf.setWhitespaceStripping(true);
    conf.setTemplateExceptionHandler(new TemplateExceptionHandler() {

      public void handleTemplateException(TemplateException te, Environment env, Writer out) throws TemplateException {
        te.printStackTrace();
      }
    });
  }

  public static void process(HttpServletRequest req, HttpServletResponse resp, String name) throws IOException {

    Template template = conf.getTemplate(name);

    try {
      template.process(new HttpRequestHashModel(req, resp, ObjectWrapper.DEFAULT_WRAPPER), resp.getWriter());
    } catch (TemplateException e) {
      throw new IOException(e);
    }
  }

  public static void template(HttpServletRequest req, HttpServletResponse resp, Attributes attrs, List<Block> blocks)
      throws IOException {

    Template template = conf.getTemplate("/template.ftl");
    req.setAttribute("attrs", attrs);
    req.setAttribute("blocks", blocks);

    try {
      template.process(new HttpRequestHashModel(req, resp, ObjectWrapper.DEFAULT_WRAPPER), resp.getWriter());
    } catch (TemplateException e) {
      throw new IOException(e);
    }
  }
}
