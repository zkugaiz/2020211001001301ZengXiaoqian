package com.zengxiaoqian.Lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

public class YourNameFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("YourNameFilter--> before chain");
        chain.doFilter(req, resp);
        System.out.println("YourNameFilter-->after chain");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
