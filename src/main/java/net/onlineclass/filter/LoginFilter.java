package net.onlineclass.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.onlineclass.domain.User;
import net.onlineclass.service.impl.UserServiceImpl;
import net.onlineclass.utils.JsonData;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter(urlPatterns = "/api/v1/pri/*",filterName = "loginFilter")
public class LoginFilter implements Filter {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter Init ======");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter Do ======");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String token = request.getHeader("token");
        if(!(token == null || "".equals(token))){
            User user = UserServiceImpl.sessionMap.get(token);
            if(user != null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                JsonData jsonData = JsonData.buildError(-2,"登录失败,Token无效");
                String jsonStr = objectMapper.writeValueAsString(jsonData);
                readJson(response,jsonStr);
            }
        }else{
            JsonData jsonData = JsonData.buildError(-3,"未登录");
            String jsonStr = objectMapper.writeValueAsString(jsonData);
            readJson(response,jsonStr);
        }
    }

    private void readJson(HttpServletResponse response, String json){
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");

        try {
            PrintWriter printWriter = response.getWriter();
            printWriter.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        System.out.println("Filter Destroy ======");
        Filter.super.destroy();
    }
}
