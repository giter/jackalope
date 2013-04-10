package giter.jackalope;

import giter.jackalope.servlets.ClassPathAnnotationConfiguration;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;

public class App {

  static Pattern RESOURCES = Pattern.compile("(css|js|png|jpg|gif|swf)$");

  public static void main(String[] args) throws Exception {

    Server server = new Server(8080);

    final ResourceHandler resources = new ResourceHandler();
    resources.setDirectoriesListed(false);
    resources.setBaseResource(Resource.newClassPathResource("/web"));

    HandlerCollection handlers = new HandlerCollection() {

      @Override
      public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
          throws IOException, ServletException {

        if (!isStarted()) return;

        if (RESOURCES.matcher(target).find()) {
          resources.handle(target, baseRequest, request, response);
          return;
        }

        Handler[] handlers = getHandlers();
        if (handlers == null) return;
        for (Handler handler : handlers) {
          handler.handle(target, baseRequest, request, response);
          if (baseRequest.isHandled()) return;
        }

      }
    };

    WebAppContext wac = new WebAppContext();
    AnnotationConfiguration conf = new ClassPathAnnotationConfiguration("/");
    wac.setConfigurations(new Configuration[] { conf });
    wac.setContextPath("/");
    handlers.addHandler(wac);

    server.setHandler(handlers);
    server.start();
    server.join();

  }
}
