package chapter1.test;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @RequestMapping("/request")
    public String request(HttpServletRequest request){
        // 获取请求方式
        String method = request.getMethod();        // 获取请求方式：GET
        System.out.println("请求方式: " +  method);

        // 获取请求url
        String url = request.getRequestURL().toString();        // 获取完整路径：http://localhost:8080/request
        System.out.println("请求url: " + url);

        String uri = request.getRequestURI();       // 获取资源路径：/request
        System.out.println("请求uri: " + uri);

        // 获取请求协议
        String protocol = request.getProtocol();        // 获取请求协议：HTTP/1.1
        System.out.println("请求协议: " + protocol);

        // 获取请求参数 - name, age
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("name: " + name + " age: " + age);

        // 获取请求头 - Accept
        String accept = request.getHeader("Accept");        // 获取请求头：Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/
        System.out.println("Accept: " + accept);

        return "OK";
    }
}
