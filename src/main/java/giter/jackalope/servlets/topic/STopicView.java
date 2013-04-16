package giter.jackalope.servlets.topic;

import giter.jackalope.cms.Topic;
import giter.jackalope.cms.TopicService;
import giter.jackalope.model.Attributes;
import giter.jackalope.model.Block;
import giter.jackalope.pages.BCommons;
import giter.jackalope.pages.BTopic;
import giter.jackalope.utils.TemplateLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/topic/*")
public class STopicView extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    List<Block> blocks = new ArrayList<>();
    blocks.add(BCommons.hd());
    blocks.add(BCommons.ft());

    String path = req.getPathInfo().substring(1);
    Topic topic = TopicService.get(path.substring(0, path.indexOf(".html")));

    if (topic == null) {
      resp.sendError(404);
      return;
    }

    blocks.add(BTopic.main(topic));

    Attributes attrs = new Attributes("page-topic");
    TemplateLoader.template(req, resp, attrs, blocks);

  }
}
