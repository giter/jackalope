package giter.jackalope.servlets;

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
    conf.setTemplateExceptionHandler(new TemplateExceptionHandler() {

      public void handleTemplateException(TemplateException te, Environment env, Writer out) throws TemplateException {
        te.printStackTrace();
      }
    });
  }

  public static void process(HttpServletRequest request, HttpServletResponse response, String name) throws IOException {

    Template template = conf.getTemplate(name);

    try {
      template
          .process(new HttpRequestHashModel(request, response, ObjectWrapper.DEFAULT_WRAPPER), response.getWriter());
    } catch (TemplateException e) {
      throw new IOException(e);
    }
  }

  public static void template(HttpServletRequest request, HttpServletResponse response, Attributes attrs,
      List<Block> blocks) throws IOException {

    Template template = conf.getTemplate("/template.ftl");
    request.setAttribute("attrs", attrs);
    request.setAttribute("blocks", blocks);

    try {
      template
          .process(new HttpRequestHashModel(request, response, ObjectWrapper.DEFAULT_WRAPPER), response.getWriter());
    } catch (TemplateException e) {
      throw new IOException(e);
    }
  }
}
