package com.example.study_servlet.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// @WebFilter(urlPatterns = "/*") // url의 모든 것은 이 필터를 거치게 해줌(어떤 servlet이든 거쳐가게 됨)
public class SessionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) // filterchain을 해줘야 필터에서 끝나지 않고 다음 서블릿으로 넘어갈 수 있음
            throws IOException, ServletException {
        try {
            System.out.println(request.getRemoteHost());
            System.out.println(request.getRemoteAddr());

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/helloWorldServlet");  // 원래 업무와 다른 업무로 방향을 전환할 때 사용함.
            requestDispatcher.forward(request, response);
            // chain.doFilter(request, response); // 필터에서 체크를 거친 뒤 다음 업무로 보내줘야 함.
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
