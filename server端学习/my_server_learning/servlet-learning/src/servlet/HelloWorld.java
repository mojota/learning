package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author jamie
 * @date 19-4-10
 */
public class HelloWorld extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Servlet正在初始化init,servletName: " + config.getServletName());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //专门向客服端提供响应的方法
        System.out.println("Servlet正在提供服务");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + "你好，页面" + "</h1>");
        Enumeration<String> hns = req.getHeaderNames();
        while (hns.hasMoreElements()) {
            String hn = hns.nextElement();
            out.println(hn + ":" + req.getHeader(hn));
            out.println("");
        }
        out.println(req.getParameter("p1"));
        out.println("");
        HttpSession session = req.getSession();
        out.println(session.getAttribute("s1"));
        out.println("");
        session.setAttribute("s1","我是session1");

        String p2 = req.getParameter("p2");
        if (p2 != null) {
//            resp.sendRedirect("index.jsp");
//            resp.sendRedirect("http://www.baidu.com");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("servlet销毁了");
    }
}
