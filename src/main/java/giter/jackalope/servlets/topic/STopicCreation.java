package giter.jackalope.servlets.topic;

import giter.jackalope.cms.Topic;
import giter.jackalope.cms.TopicService;
import giter.jackalope.cms.User;
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

@WebServlet(urlPatterns = "/user/topic/creation.html")
public class STopicCreation extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    List<Block> blocks = new ArrayList<>();
    blocks.add(BCommons.hd());
    blocks.add(BCommons.ft());
    blocks.add(BTopic.creation());

    Attributes attrs = new Attributes("page-topic-creation");
    TemplateLoader.template(req, resp, attrs, blocks);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    User u = (User) req.getSession().getAttribute("user");

    String user = u.getName();
    String title = req.getParameter("title");
    String category = req.getParameter("category");
    String content = req.getParameter("content");
    String _id = req.getParameter("_id");

    Topic t = new Topic(user, title, category, content);
    t.set_id(_id);

    TopicService.save(t);

    resp.sendRedirect(String.format("/topic/%s.html", t.get_id().toString()));

  }
}
