package giter.jackalope.servlets;

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
public class STopic extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    List<Block> blocks = new ArrayList<>();
    blocks.add(BCommons.hd());
    blocks.add(BCommons.ft());
    blocks.add(BTopic.main());

    Attributes attrs = new Attributes("page-topic");
    TemplateLoader.template(req, resp, attrs, blocks);

  }
}
