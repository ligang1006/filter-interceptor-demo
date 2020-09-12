package net.gaven.filterinterceptordemo.filter;

import net.gaven.filterinterceptordemo.wervice.IFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.jws.Oneway;
import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 过滤器demo
 * @author: lee
 * @create: 2020-09-12 16:03
 **/
public class LogCostFilter implements Filter {
    @Autowired
    IFilterService service;
    private static final Map<String, Object> map = new HashMap<>(1 << 4);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter start.....");

    }

    @Override
    public void destroy() {
        System.out.println("filter end.....");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        map.put("xijie", "123");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String name = httpServletRequest.getHeader("name");
        if (StringUtils.isEmpty(name)){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("用户名为空");
            return;
        }
        String password = httpServletRequest.getHeader("password");
        if (StringUtils.isEmpty(password)){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("用户密码为空");
            return;
        }
        if (name.equals("xijie")){
            String pass =(String) map.get("xijie");
            if (pass.equals(password)){
                System.out.println("login success!");
            }else{
                System.out.println("用户密码错误，登录失败");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("用户密码错误，登录失败");
                return;
            }
        }else {
            System.out.println("用户没有权限，登录失败");
            response.getWriter().write("用户密码错误，登录失败");
            return;
        }
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        System.out.println("Execute cost" + String.valueOf(System.currentTimeMillis() - start));
    }
}
