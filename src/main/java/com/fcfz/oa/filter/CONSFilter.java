package com.fcfz.oa.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CONSFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        //        解决跨域问题、同源访问策略
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");


        response.setContentType("text/html;charset=utf-8");

        chain.doFilter(request, response);

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
    }
}
