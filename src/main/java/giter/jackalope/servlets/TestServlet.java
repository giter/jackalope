package giter.jackalope.servlets;

import giter.jackalope.model.Attributes;
import giter.jackalope.model.Block;
import giter.jackalope.pages.TestBlocks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    List<Block> blocks = new ArrayList<>();
    blocks.add(TestBlocks.main());

    TemplateLoader.template(request, response, new Attributes("page-test"), blocks);
  }

}
