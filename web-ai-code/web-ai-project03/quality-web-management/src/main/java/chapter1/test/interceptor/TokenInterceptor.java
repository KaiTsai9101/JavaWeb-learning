package chapter1.test.interceptor;

import chapter1.test.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

// 令牌校验拦截器
@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    // 目标资源处理之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求路径
//        String requestURI = request.getRequestURI();        // 获取请求路径

        // 判断是否是登录请求，如果路径中包含 /login，则放行（登录前没有token）
//        if (requestURI.contains("/login")){
//            log.info("登录请求，放行");
//            return true;
//        }

        // 获取请求头中的token
        String token = request.getHeader("token");

        // 判断token是否存在，如果不存在，则返回未登录，状态码401
        if (token == null || token.isEmpty()){
            log.info("令牌为空，响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);        // HttpServletResponse中SC_UNAUTHORIZED的值为401
            return false;
        }

        // 如果token存在，校验令牌，如果校验失败，则返回错误信息，状态码401
        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("令牌非法，响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);        // HttpServletResponse中SC_UNAUTHORIZED的值为401
            return false;
        }

        // 校验通过，则放行
        log.info("令牌合法，放行");
        return true;
    }
}
