package com.guohaoshiye.yueba.session;

import com.guohaoshiye.yueba.entity.Admin;
import com.guohaoshiye.yueba.util.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




public class CheckSession
  implements Filter
{
  public void destroy() {}

  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
    throws IOException, ServletException
  {
    HttpServletRequest request = (HttpServletRequest)servletRequest;

    HttpServletResponse response = (HttpServletResponse)servletResponse;

    String currentURL = request.getRequestURI();
    int num = currentURL.indexOf("/", 1);
    num = num < 0 ? 0 : num;
    String targetURL = currentURL.substring(num, currentURL.length());
    HttpSession session = request.getSession();
    if ((targetURL.contains(".css")) ||
      (targetURL.contains(".js")) ||
      (targetURL.contains("img")) ||
      (targetURL.contains(".jpg")) ||
      (targetURL.contains(".png")) ||
      (targetURL.contains(".woff")) ||
      (targetURL.contains(".json")) ||
      (targetURL.contains(".ttf")) ||
      (targetURL.contains(".woff2")) ||
      (targetURL.contains(".doc")) ||
      (targetURL.contains("/AuthImageServlet")) ||
      (targetURL.contains("/LoginServlet")))
    {
      filterChain.doFilter(request, response);
      return;
    }
    if (!"/login.jsp".equals(targetURL)) {
      if ((session == null) || (session.getAttribute("mapAdmin") == null)) {
        String ipClients = Util.getIpAddress(request);
        Map<String, Admin> mapAdmin = new HashMap();
        mapAdmin.put(ipClients, null);
        session.setAttribute("mapAdmin", mapAdmin);
        response.sendRedirect("login.jsp");
        return;
      }
      String ipClients = Util.getIpAddress(request);
      Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
      Integer i = Integer.valueOf(0);
      for (Map.Entry<String, Admin> entry : mapAdmin.entrySet())
        if (ipClients.equals(entry.getKey())) {
          if (entry.getValue() == null) {
            response.sendRedirect("login.jsp");
          }
        }
        else {
//          localInteger1 = i;Integer localInteger2 = i = Integer.valueOf(i.intValue() + 1);
          i = Integer.valueOf(i.intValue() + 1);
        }
//      Integer localInteger1;
      if (i.intValue() == mapAdmin.size()) {
        mapAdmin.put(ipClients, null);
        session.setAttribute("mapAdmin", mapAdmin);
        response.sendRedirect("login.jsp");
        return;
      }
    }


    filterChain.doFilter(request, response);
  }

  public void init(FilterConfig filterConfig)
    throws ServletException
  {}
}

