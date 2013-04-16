package giter.jackalope.servlets.user;

import giter.jackalope.cms.User;
import giter.jackalope.cms.UserService;
import giter.jackalope.model.Attributes;
import giter.jackalope.model.Block;
import giter.jackalope.pages.BCommons;
import giter.jackalope.pages.BUser;
import giter.jackalope.utils.TemplateLoader;
import giter.jackalope.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.html")
public class SUserLogin extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    List<Block> blocks = new ArrayList<>();
    blocks.add(BCommons.hd());
    blocks.add(BCommons.ft());
    blocks.add(BUser.login());

    Attributes attrs = new Attributes("page-login");
    attrs.attr("title", "用户登录");
    TemplateLoader.template(req, resp, attrs, blocks);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String name = req.getParameter("name");
    String password = req.getParameter("password");

    User u = UserService.login(name, Utils.md5(password));

    if (u != null) {
      req.getSession().setAttribute("user", u);
      resp.sendRedirect("/");
    } else {
      resp.sendRedirect("/login.html");
    }

  }
}
