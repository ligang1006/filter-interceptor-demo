package net.gaven.filterinterceptordemo.filter;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @description:
 * @author: lee
 * @create: 2020-09-12 17:10
 **/
@WebFilter(filterName = "filter2",urlPatterns = "/api/v1/filter/test")
public class LogCostFilter2 implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        System.out.println("LogFilter2 Execute cost=" + (System.currentTimeMillis() - start));
    }


}
