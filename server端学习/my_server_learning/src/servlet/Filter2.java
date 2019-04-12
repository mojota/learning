package servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author jamie
 * @date 19-4-11
 */
public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter2 init");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse
            , FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter2 doFilter 放行前");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("filter2 doFilter 放行后");

    }

    @Override
    public void destroy() {
        System.out.println("filter2 destroy");

    }
}
