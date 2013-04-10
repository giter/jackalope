package giter.jackalope;

import giter.jackalope.utils.ClassPathAnnotationConfiguration;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;

public class App {

  public static void main(String[] args) throws Exception {

    Server server = new Server(8080);

    final ResourceHandler resources = new ResourceHandler() {

      Pattern RESOURCES = Pattern.compile("(css|js|png|jpg|gif|swf)$");

      @Override
      public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
          throws IOException, ServletException {

        if (RESOURCES.matcher(target).find()) {
          super.handle(target, baseRequest, request, response);
          return;
        }
      }
    };

    resources.setDirectoriesListed(false);
    resources.setBaseResource(Resource.newClassPathResource("/web"));

    HandlerCollection handlers = new HandlerCollection();

    WebAppContext wac = new WebAppContext();
    AnnotationConfiguration conf = new ClassPathAnnotationConfiguration("/");
    wac.setConfigurations(new Configuration[] { conf });
    wac.setContextPath("/");

    handlers.addHandler(resources);
    handlers.addHandler(wac);

    server.setHandler(handlers);
    server.start();
    server.join();

  }
}
