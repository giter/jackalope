package giter.jackalope.filters;

import giter.jackalope.cms.User;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/user/*")
public class SUserFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
      ServletException {

    HttpServletRequest req = (HttpServletRequest) request;

    User u = (User) req.getSession().getAttribute("user");

    if (u == null) {
      ((HttpServletResponse) response).sendRedirect("/login.html");
      return;
    }

    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
  }

}
