package chapter1.test.filter;

import chapter1.test.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")      // 拦截所有请求
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获取请求路径
        String requestURI = request.getRequestURI();        // 获取请求路径

        // 判断是否是登录请求，如果路径中包含 /login，则放行（登录前没有token）
        if (requestURI.contains("/login")){
            log.info("登录请求，放行");
            filterChain.doFilter(request, response);
            return;
        }

        // 获取请求头中的token
        String token = request.getHeader("token");

        // 判断token是否存在，如果不存在，则返回未登录，状态码401
        if (token == null || token.isEmpty()){
            log.info("令牌为空，响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);        // HttpServletResponse中SC_UNAUTHORIZED的值为401
            return;
        }

        // 如果token存在，校验令牌，如果校验失败，则返回错误信息，状态码401
        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("令牌非法，响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);        // HttpServletResponse中SC_UNAUTHORIZED的值为401
            return;
        }

        // 校验通过，则放行
        log.info("令牌合法，放行");
        filterChain.doFilter(request, response);
    }
}
